package com.saniou.santieba.widget.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import android.widget.Scroller;

import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;

public class MPhotoView extends AppCompatImageView {

    private final static int MIN_ROTATE = 35;
    private final static int ANIMA_DURING = 340;
    private final static float MAX_SCALE = 2.5f;

    private int MAX_FLING_OVER_SCROLL = 0;
    private int MAX_OVER_RESISTANCE = 0;
    private int MAX_ANIM_FROM_WAITE = 500;

    private int mMinRotate;
    private int mAnimaDuring;
    private float mMaxScale;

    private Matrix mBaseMatrix = new Matrix();
    private Matrix mAnimaMatrix = new Matrix();
    private Matrix mTmpMatrix = new Matrix();
    //用于合成的过度 Matrix
    private Matrix mSynthesisMatrix = new Matrix();

    private RotateGestureDetector mRotateDetector;
    private GestureDetector mDetector;
    private ScaleGestureDetector mScaleDetector;

    private boolean hasMultiTouch;
    private boolean hasDrawable;
    private boolean isKnowSize;
    private boolean hasOverTranslate;
    private boolean isEnable = false;
    private boolean isRotateEnable = false;
    private boolean isInit;
    /**
     * 当前是否处于放大状态
     */
    private boolean isZoonUp;
    private boolean canRotate;

    private boolean imgLargeWidth;
    private boolean imgLargeHeight;

    private float mRotateFlag;
    private float mDegrees;
    private float mScale = 1.0f;
    private int mTranslateX;
    private int mTranslateY;

    private float mHalfBaseRectWidth;
    private float mHalfBaseRectHeight;

    private RectF mWidgetRect = new RectF();
    private RectF mBaseRect = new RectF();
    private RectF mImgRect = new RectF();
    private RectF mTmpRect = new RectF();
    private RectF mCommonRect = new RectF();

    private PointF mWidgetCenter = new PointF();
    private PointF mScaleCenter = new PointF();
    private PointF mRotateCenter = new PointF();

    private Transform mTranslate = new Transform();

    private Info mFromInfo;
    private long mInfoTime;
    private Runnable mCompleteCallBack;

    public MPhotoView(Context context) {
        super(context);
        init();
    }

    public MPhotoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MPhotoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        super.setScaleType(ScaleType.MATRIX);
        mRotateDetector = new RotateGestureDetector(mRotateListener);
        mDetector = new GestureDetector(getContext(), mGestureListener);
        mScaleDetector = new ScaleGestureDetector(getContext(), mScaleListener);
        float density = getResources().getDisplayMetrics().density;
        MAX_FLING_OVER_SCROLL = (int) (density * 30);
        MAX_OVER_RESISTANCE = (int) (density * 140);

        mMinRotate = MIN_ROTATE;
        mAnimaDuring = ANIMA_DURING;
        mMaxScale = MAX_SCALE;
    }

    /**
     * 设置动画的插入器
     */
    public void setInterpolator(Interpolator interpolator) {
        mTranslate.setInterpolator(interpolator);
    }

    /**
     * 获取动画持续时间
     */
    public int getAnimaDuring() {
        return mAnimaDuring;
    }

    /**
     * 设置动画的持续时间
     */
    public void setAnimaDuring(int during) {
        mAnimaDuring = during;
    }

    /**
     * 设置最大可以缩放的倍数
     */
    public void setMaxScale(float maxScale) {
        mMaxScale = maxScale;
    }

    /**
     * 获取最大可以缩放的倍数
     */
    public float getMaxScale() {
        return mMaxScale;
    }

    /**
     * 启用缩放功能
     */
    public void enable() {
        isEnable = true;
    }

    /**
     * 禁用缩放功能
     */
    public void disenable() {
        isEnable = false;
    }

    /**
     * 启用旋转功能
     */
    public void enableRotate() {
        isRotateEnable = true;
    }

    /**
     * 禁用旋转功能
     */
    public void disableRotate() {
        isRotateEnable = false;
    }

    @Override
    public void setImageResource(@DrawableRes int resId) {
        setImageDrawable(ContextCompat.getDrawable(getContext(), resId));
    }

    @Override
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);

        if (drawable == null) {
            hasDrawable = false;
            return;
        }

        if (!hasSize(drawable)) {
            return;
        }

        if (!hasDrawable) {
            hasDrawable = true;
        }

        initBase();
    }

    private boolean hasSize(Drawable d) {
        return !((d.getIntrinsicHeight() <= 0 || d.getIntrinsicWidth() <= 0)
                && (d.getMinimumWidth() <= 0 || d.getMinimumHeight() <= 0)
                && (d.getBounds().width() <= 0 || d.getBounds().height() <= 0));
    }

    private void initBase() {
        if (!hasDrawable) {
            return;
        }
        if (!isKnowSize) {
            return;
        }

        mBaseMatrix.reset();
        mAnimaMatrix.reset();

        isZoonUp = false;

        Drawable img = getDrawable();

        int w = getWidth();
        int h = getHeight();
        int imgw = getDrawableWidth(img);
        int imgh = getDrawableHeight(img);
        mBaseRect.set(0, 0, imgw, imgh);
        // 以图片中心点居中位移
        int tx = (w - imgw) / 2;
        int ty = (h - imgh) / 2;

        float sx = 1;
        float sy = 1;

        // 缩放，默认不超过控件大小减去一个有效边距的值
        int imageAreaW = w - 10;
        if (imgw > imageAreaW) {
            sx = (float) imageAreaW / imgw;
        }
        int imageAreaH = h - 10;
        if (imgh > imageAreaH) {
            sy = (float) imageAreaH / imgh;
        }

        float scale = sx < sy ? sx : sy;

        mBaseMatrix.reset();
        mBaseMatrix.postTranslate(tx, ty);
        mBaseMatrix.postScale(scale, scale, mWidgetCenter.x, mWidgetCenter.y);
        mBaseMatrix.mapRect(mBaseRect);

        mHalfBaseRectWidth = mBaseRect.width() / 2;
        mHalfBaseRectHeight = mBaseRect.height() / 2;

        mScaleCenter.set(mWidgetCenter);
        mRotateCenter.set(mScaleCenter);

        executeTranslate();
        isInit = true;

        if (mFromInfo != null && System.currentTimeMillis() - mInfoTime < MAX_ANIM_FROM_WAITE) {
            animaFrom(mFromInfo);
        }

        mFromInfo = null;
    }

    /**
     * 开始变换
     */
    private void executeTranslate() {
        mSynthesisMatrix.reset();
        mSynthesisMatrix.set(mBaseMatrix);
        mSynthesisMatrix.postConcat(mAnimaMatrix);
        setImageMatrix(mSynthesisMatrix);

        mAnimaMatrix.mapRect(mImgRect, mBaseRect);

        imgLargeWidth = mImgRect.width() > mWidgetRect.width();
        imgLargeHeight = mImgRect.height() > mWidgetRect.height();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mWidgetRect.set(0, 0, w, h);
        mWidgetCenter.set(w / 2, h / 2);

        if (!isKnowSize) {
            isKnowSize = true;
            initBase();
        }
    }

    private float mXDown;

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        getParent().requestDisallowInterceptTouchEvent(isEnable);
        boolean touchEvent = super.dispatchTouchEvent(event);
        return isEnable || touchEvent;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean touchEvent = super.onTouchEvent(event);
        boolean requestTouch = true;
        float eventX = event.getX();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mXDown = event.getRawX();
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mXDown = 0;
                break;
            default:
        }

        if (isEnable) {
            if (event.getPointerCount() == 1 && event.getAction() == MotionEvent.ACTION_MOVE) {
                // 左划 图片的右边缘在 widget 之外
                boolean canMoveLeft =
                        mXDown > eventX && mImgRect.right > mWidgetRect.right;
                boolean canMoveRight =
                        mXDown < eventX && mImgRect.left < mWidgetRect.left;
                requestTouch = canMoveLeft || canMoveRight;
            }
        }
        getParent().requestDisallowInterceptTouchEvent(requestTouch);
        if (isEnable) {
            final int action = event.getActionMasked();
            if (event.getPointerCount() >= 2) {
                hasMultiTouch = true;
            }
            mDetector.onTouchEvent(event);
            if (isRotateEnable) {
                mRotateDetector.onTouchEvent(event);
            }
            mScaleDetector.onTouchEvent(event);

            if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL) {
                onUp();
            }
            return requestTouch;
        }
        return touchEvent;
    }

    /**
     * 放手时还原
     */
    private void onUp() {
        if (mTranslate.isRuning) {
            return;
        }

        if (canRotate || mDegrees % 90 != 0) {
            float toDegrees = (mDegrees / 90F) * 90F;
            float remainder = mDegrees % 90;

            if (remainder > 45) {
                toDegrees += 90;
            } else if (remainder < -45) {
                toDegrees -= 90;
            }

            mTranslate.withRotate((int) mDegrees, (int) toDegrees);

            mDegrees = toDegrees;
        }

        float scale = mScale;

        if (mScale < 1) {
            scale = 1;
            mTranslate.withScale(mScale, 1);
        } else if (mScale > mMaxScale) {
            scale = mMaxScale;
            mTranslate.withScale(mScale, mMaxScale);
        }

        float cx = mImgRect.left + mImgRect.width() / 2;
        float cy = mImgRect.top + mImgRect.height() / 2;

        mScaleCenter.set(cx, cy);
        mRotateCenter.set(cx, cy);

        mTranslateX = 0;
        mTranslateY = 0;

        mTmpMatrix.reset();
        mTmpMatrix.postTranslate(-mBaseRect.left, -mBaseRect.top);
        mTmpMatrix.postTranslate(cx - mHalfBaseRectWidth, cy - mHalfBaseRectHeight);
        mTmpMatrix.postScale(scale, scale, cx, cy);
        mTmpMatrix.postRotate(mDegrees, cx, cy);
        mTmpMatrix.mapRect(mTmpRect, mBaseRect);

        doTranslateReset(mTmpRect);
        mTranslate.start();
    }

    private void doTranslateReset(RectF imgRect) {
        int tx = 0;
        int ty = 0;

        if (imgRect.width() <= mWidgetRect.width()) {
            if (!isImageCenterWidth(imgRect)) {
                tx = -(int) ((mWidgetRect.width() - imgRect.width()) / 2 - imgRect.left);
            }
        } else {
            if (imgRect.left > mWidgetRect.left) {
                tx = (int) (imgRect.left - mWidgetRect.left);
            } else if (imgRect.right < mWidgetRect.right) {
                tx = (int) (imgRect.right - mWidgetRect.right);
            }
        }

        if (imgRect.height() <= mWidgetRect.height()) {
            if (!isImageCenterHeight(imgRect)) {
                ty = -(int) ((mWidgetRect.height() - imgRect.height()) / 2 - imgRect.top);
            }
        } else {
            if (imgRect.top > mWidgetRect.top) {
                ty = (int) (imgRect.top - mWidgetRect.top);
            } else if (imgRect.bottom < mWidgetRect.bottom) {
                ty = (int) (imgRect.bottom - mWidgetRect.bottom);
            }
        }

        if (tx != 0 || ty != 0) {
            if (!mTranslate.mFlingScroller.isFinished()) {
                mTranslate.mFlingScroller.abortAnimation();
            }
            mTranslate.withTranslate(mTranslateX, mTranslateY, -tx, -ty);
        }
    }

    private boolean isImageCenterHeight(RectF rect) {
        return Math.abs(Math.round(rect.top) - (mWidgetRect.height() - rect.height()) / 2) < 1;
    }

    private boolean isImageCenterWidth(RectF rect) {
        return Math.abs(Math.round(rect.left) - (mWidgetRect.width() - rect.width()) / 2) < 1;
    }

    private OnRotateListener mRotateListener = new OnRotateListener() {

        @Override
        public void onRotate(float degrees, float focusX, float focusY) {
            mRotateFlag += degrees;
            if (canRotate) {
                mDegrees += degrees;
                mAnimaMatrix.postRotate(degrees, focusX, focusY);
            } else {
                if (Math.abs(mRotateFlag) >= mMinRotate) {
                    canRotate = true;
                    mRotateFlag = 0;
                }
            }
        }
    };

    private ScaleGestureDetector.OnScaleGestureListener mScaleListener =
            new ScaleGestureDetector.OnScaleGestureListener() {
                @Override
                public boolean onScale(ScaleGestureDetector detector) {
                    float scaleFactor = detector.getScaleFactor();

                    if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                        return false;
                    }

                    mScale *= scaleFactor;
                    mAnimaMatrix.postScale(scaleFactor, scaleFactor, detector.getFocusX(),
                            detector.getFocusY());
                    executeTranslate();
                    return true;
                }

                @Override
                public boolean onScaleBegin(ScaleGestureDetector detector) {
                    return true;
                }

                @Override
                public void onScaleEnd(ScaleGestureDetector detector) {

                }
            };

    private float resistanceScrollByX(float overScroll, float detalX) {
        float s = detalX * (Math.abs(Math.abs(overScroll) - MAX_OVER_RESISTANCE) /
                (float) MAX_OVER_RESISTANCE);
        return s;
    }

    private float resistanceScrollByY(float overScroll, float detalY) {
        float s = detalY * (Math.abs(Math.abs(overScroll) - MAX_OVER_RESISTANCE) /
                (float) MAX_OVER_RESISTANCE);
        return s;
    }

    /**
     * 匹配两个Rect的共同部分输出到out，若无共同部分则输出0，0，0，0
     */
    private void mapRect(RectF r1, RectF r2, RectF out) {

        float l, r, t, b;

        l = r1.left > r2.left ? r1.left : r2.left;
        r = r1.right < r2.right ? r1.right : r2.right;

        if (l > r) {
            out.set(0, 0, 0, 0);
            return;
        }

        t = r1.top > r2.top ? r1.top : r2.top;
        b = r1.bottom < r2.bottom ? r1.bottom : r2.bottom;

        if (t > b) {
            out.set(0, 0, 0, 0);
            return;
        }

        out.set(l, t, r, b);
    }

    private void checkRect() {
        if (!hasOverTranslate) {
            mapRect(mWidgetRect, mImgRect, mCommonRect);
        }
    }

    private GestureDetector.OnGestureListener mGestureListener =
            new GestureDetector.SimpleOnGestureListener() {

                @Override
                public boolean onDown(MotionEvent e) {
                    hasOverTranslate = false;
                    hasMultiTouch = false;
                    canRotate = false;
                    return false;
                }

                @Override
                public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                    if (hasMultiTouch) {
                        return false;
                    }
                    if (!imgLargeWidth && !imgLargeHeight) {
                        return false;
                    }
                    if (mTranslate.isRuning) {
                        return false;
                    }

                    float vx = velocityX;
                    float vy = velocityY;

                    if (Math.round(mImgRect.left) >= mWidgetRect.left ||
                            Math.round(mImgRect.right) <= mWidgetRect.right) {
                        vx = 0;
                    }

                    if (Math.round(mImgRect.top) >= mWidgetRect.top ||
                            Math.round(mImgRect.bottom) <= mWidgetRect.bottom) {
                        vy = 0;
                    }

                    if (canRotate || mDegrees % 90 != 0) {
                        float toDegrees = (int) (mDegrees / 90) * 90;
                        float remainder = mDegrees % 90;

                        if (remainder > 45) {
                            toDegrees += 90;
                        } else if (remainder < -45) {
                            toDegrees -= 90;
                        }

                        mTranslate.withRotate((int) mDegrees, (int) toDegrees);

                        mDegrees = toDegrees;
                    }

                    doTranslateReset(mImgRect);

                    mTranslate.withFling(vx, vy);

                    mTranslate.start();

                    return super.onFling(e1, e2, velocityX, velocityY);
                }

                @Override
                public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                    if (mTranslate.isRuning) {
                        mTranslate.stop();
                    }

                    if (canScrollHorizontallySelf(distanceX)) {
                        if (distanceX < 0 && mImgRect.left - distanceX > mWidgetRect.left) {
                            distanceX = mImgRect.left;
                        }
                        if (distanceX > 0 && mImgRect.right - distanceX < mWidgetRect.right) {
                            distanceX = mImgRect.right - mWidgetRect.right;
                        }

                        mAnimaMatrix.postTranslate(-distanceX, 0);
                        mTranslateX -= distanceX;
                    } else if (imgLargeWidth || hasMultiTouch || hasOverTranslate) {
                        checkRect();
                        if (!hasMultiTouch) {
                            if (distanceX < 0 && mImgRect.left - distanceX > mCommonRect.left) {
                                distanceX = resistanceScrollByX(mImgRect.left - mCommonRect.left,
                                        distanceX);
                            }
                            if (distanceX > 0 && mImgRect.right - distanceX < mCommonRect.right) {
                                distanceX = resistanceScrollByX(mImgRect.right - mCommonRect.right,
                                        distanceX);
                            }
                        }

                        mTranslateX -= distanceX;
                        mAnimaMatrix.postTranslate(-distanceX, 0);
                        hasOverTranslate = true;
                    }

                    if (canScrollVerticallySelf(distanceY)) {
                        if (distanceY < 0 && mImgRect.top - distanceY > mWidgetRect.top) {
                            distanceY = mImgRect.top;
                        }
                        if (distanceY > 0 && mImgRect.bottom - distanceY < mWidgetRect.bottom) {
                            distanceY = mImgRect.bottom - mWidgetRect.bottom;
                        }

                        mAnimaMatrix.postTranslate(0, -distanceY);
                        mTranslateY -= distanceY;
                    } else if (imgLargeHeight || hasOverTranslate || hasMultiTouch) {
                        checkRect();
                        if (!hasMultiTouch) {
                            if (distanceY < 0 && mImgRect.top - distanceY > mCommonRect.top) {
                                distanceY = resistanceScrollByY(mImgRect.top - mCommonRect.top, distanceY);
                            }
                            if (distanceY > 0 && mImgRect.bottom - distanceY < mCommonRect.bottom) {
                                distanceY = resistanceScrollByY(mImgRect.bottom - mCommonRect.bottom,
                                        distanceY);
                            }
                        }

                        mAnimaMatrix.postTranslate(0, -distanceY);
                        mTranslateY -= distanceY;
                        hasOverTranslate = true;
                    }

                    executeTranslate();
                    return true;
                }

                @Override
                public boolean onDoubleTap(MotionEvent e) {

                    mTranslate.stop();

                    float from;
                    float to;

                    float imgcx = mImgRect.left + mImgRect.width() / 2;
                    float imgcy = mImgRect.top + mImgRect.height() / 2;

                    mScaleCenter.set(imgcx, imgcy);
                    mRotateCenter.set(imgcx, imgcy);
                    mTranslateX = 0;
                    mTranslateY = 0;

                    if (isZoonUp) {
                        from = mScale;
                        to = 1;
                    } else {
                        from = mScale;
                        to = mMaxScale;

                        mScaleCenter.set(e.getX(), e.getY());
                    }

                    mTmpMatrix.reset();
                    mTmpMatrix.postTranslate(-mBaseRect.left, -mBaseRect.top);
                    mTmpMatrix.postTranslate(mRotateCenter.x, mRotateCenter.y);
                    mTmpMatrix.postTranslate(-mHalfBaseRectWidth, -mHalfBaseRectHeight);
                    mTmpMatrix.postRotate(mDegrees, mRotateCenter.x, mRotateCenter.y);
                    mTmpMatrix.postScale(to, to, mScaleCenter.x, mScaleCenter.y);
                    mTmpMatrix.postTranslate(mTranslateX, mTranslateY);
                    mTmpMatrix.mapRect(mTmpRect, mBaseRect);
                    doTranslateReset(mTmpRect);

                    isZoonUp = !isZoonUp;
                    mTranslate.withScale(from, to);
                    mTranslate.start();

                    return false;
                }
            };

    public boolean canScrollHorizontallySelf(float direction) {
        if (mImgRect.width() <= mWidgetRect.width()) {
            return false;
        }
        if (direction < 0 && Math.round(mImgRect.left) - direction >= mWidgetRect.left) {
            return false;
        }
        if (direction > 0 && Math.round(mImgRect.right) - direction <= mWidgetRect.right) {
            return false;
        }
        return true;
    }

    public boolean canScrollVerticallySelf(float direction) {
        if (mImgRect.height() <= mWidgetRect.height()) {
            return false;
        }
        if (direction < 0 && Math.round(mImgRect.top) - direction >= mWidgetRect.top) {
            return false;
        }
        if (direction > 0 && Math.round(mImgRect.bottom) - direction <= mWidgetRect.bottom) {
            return false;
        }
        return true;
    }

    @Override
    public boolean canScrollHorizontally(int direction) {
        return hasMultiTouch || canScrollHorizontallySelf(direction);
    }

    @Override
    public boolean canScrollVertically(int direction) {
        return hasMultiTouch || canScrollVerticallySelf(direction);
    }

    public Info getInfo() {
        RectF rect = new RectF();
        int[] p = new int[2];
        getLocationInWindow(p);
        rect.set(p[0] + mImgRect.left, p[1] + mImgRect.top, p[0] + mImgRect.right,
                p[1] + mImgRect.bottom);
        return new Info(rect, mImgRect, mWidgetRect, mBaseRect, mWidgetCenter, mScale, mDegrees,
                getScaleType());
    }

    private void reset() {
        mAnimaMatrix.reset();
        executeTranslate();
        mScale = 1;
        mTranslateX = 0;
        mTranslateY = 0;
    }

    /**
     * 在PhotoView内部还没有图片的时候同样可以调用该方法 此时并不会播放动画，当给PhotoView设置图片后会自动播放动画。
     * 若等待时间过长也没有给控件设置图片，则会忽略该动画，若要再次播放动画则需要重新调用该方法 (等待的时间默认500毫秒，可以通过setMaxAnimFromWaiteTime(int)设置最大等待时间)
     */
    public void animaFrom(Info info) {
        if (isInit) {
            reset();

            Info mine = getInfo();

            float scaleX = info.mRect.width() / mine.mImgRect.width();
            float scaleY = info.mRect.height() / mine.mImgRect.height();
            float scale = Math.min(scaleX, scaleY);

            float ocx = info.mRect.left + info.mRect.width() / 2;
            float ocy = info.mRect.top + info.mRect.height() / 2;

            float mcx = mine.mRect.left + mine.mRect.width() / 2;
            float mcy = mine.mRect.top + mine.mRect.height() / 2;

            mAnimaMatrix.reset();
            float dy = ocy - mcy;
            float dx = ocx - mcx;
            // scale 之后原 trans 也将等倍扩大
            mAnimaMatrix.postScale(scale, scale, mWidgetCenter.x, mWidgetCenter.y);
            mAnimaMatrix.postTranslate(dx, dy);
            mAnimaMatrix.postRotate(info.mDegrees, ocx, ocy);
            executeTranslate();
            mScaleCenter.set(ocx, ocy);
            mRotateCenter.set(ocx, ocy);

            onUp();
        } else {
            mFromInfo = info;
            mInfoTime = System.currentTimeMillis();
        }
    }

    public void animaTo(Info info, Runnable completeCallBack) {
        if (isInit) {
            mTranslate.stop();
            mTranslateX = 0;
            mTranslateY = 0;

            float tcx = info.mRect.left + info.mRect.width() / 2;
            float tcy = info.mRect.top + info.mRect.height() / 2;

            mScaleCenter.set(mImgRect.left + mImgRect.width() / 2,
                    mImgRect.top + mImgRect.height() / 2);
            mRotateCenter.set(mScaleCenter);

            // 将图片旋转回正常位置，用以计算
            mAnimaMatrix.postRotate(-mDegrees, mScaleCenter.x, mScaleCenter.y);
            mAnimaMatrix.mapRect(mImgRect, mBaseRect);

            // 缩放
            float scaleX = info.mImgRect.width() / mBaseRect.width();
            float scaleY = info.mImgRect.height() / mBaseRect.height();
            float scale = scaleX > scaleY ? scaleX : scaleY;

            mAnimaMatrix.postRotate(mDegrees, mScaleCenter.x, mScaleCenter.y);
            mAnimaMatrix.mapRect(mImgRect, mBaseRect);

            mDegrees = mDegrees % 360;

            mTranslate.withTranslate(0, 0, (int) (tcx - mScaleCenter.x),
                    (int) (tcy - mScaleCenter.y));
            mTranslate.withScale(mScale, scale);
            mTranslate.withRotate((int) mDegrees, (int) info.mDegrees, mAnimaDuring * 2 / 3);

            mCompleteCallBack = completeCallBack;
            mTranslate.start();
        } else {
            completeCallBack.run();
        }
    }

    /**
     * 旋转
     */
    public void rotate(float degrees) {
        mDegrees += degrees;
        int centerX = (int) (mWidgetRect.left + mWidgetRect.width() / 2);
        int centerY = (int) (mWidgetRect.top + mWidgetRect.height() / 2);

        mAnimaMatrix.postRotate(degrees, centerX, centerY);
        executeTranslate();
    }

    /*************************  *************************/
    public static Info getImageViewInfo(ImageView imgView) {
        int[] p = new int[2];
        imgView.getLocationInWindow(p);

        Drawable drawable = imgView.getDrawable();

        Matrix matrix = imgView.getImageMatrix();

        int width = getDrawableWidth(drawable);
        int height = getDrawableHeight(drawable);

        RectF imgRect = new RectF(0, 0, width, height);
        matrix.mapRect(imgRect);

        RectF rect = new RectF(p[0] + imgRect.left, p[1] + imgRect.top, p[0] + imgRect.right,
                p[1] + imgRect.bottom);
        RectF widgetRect = new RectF(0, 0, imgView.getWidth(), imgView.getHeight());
        RectF baseRect = new RectF(widgetRect);
        PointF screenCenter = new PointF(widgetRect.width() / 2, widgetRect.height() / 2);

        return new Info(rect, imgRect, widgetRect, baseRect, screenCenter, 1, 0,
                imgView.getScaleType());
    }

    private static int getDrawableWidth(Drawable d) {
        int width = d.getIntrinsicWidth();
        if (width <= 0) {
            width = d.getMinimumWidth();
        }
        if (width <= 0) {
            width = d.getBounds().width();
        }
        return width;
    }

    private static int getDrawableHeight(Drawable d) {
        int height = d.getIntrinsicHeight();
        if (height <= 0) {
            height = d.getMinimumHeight();
        }
        if (height <= 0) {
            height = d.getBounds().height();
        }
        return height;
    }

    /*************************  *************************/
    private class InterpolatorProxy implements Interpolator {

        private Interpolator mTarget;

        private InterpolatorProxy() {
            mTarget = new DecelerateInterpolator();
        }

        public void setTargetInterpolator(Interpolator interpolator) {
            mTarget = interpolator;
        }

        @Override
        public float getInterpolation(float input) {
            if (mTarget != null) {
                return mTarget.getInterpolation(input);
            }
            return input;
        }
    }

    /*************************  *************************/
    private class Transform implements Runnable {

        boolean isRuning;

        OverScroller mTranslateScroller;
        OverScroller mFlingScroller;
        Scroller mScaleScroller;
        Scroller mRotateScroller;

        int mLastFlingX;
        int mLastFlingY;

        int mLastTranslateX;
        int mLastTranslateY;

        InterpolatorProxy mInterpolatorProxy = new InterpolatorProxy();

        Transform() {
            Context ctx = getContext();
            mTranslateScroller = new OverScroller(ctx, mInterpolatorProxy);
            mScaleScroller = new Scroller(ctx, mInterpolatorProxy);
            mFlingScroller = new OverScroller(ctx, mInterpolatorProxy);
            mRotateScroller = new Scroller(ctx, mInterpolatorProxy);
        }

        public void setInterpolator(Interpolator interpolator) {
            mInterpolatorProxy.setTargetInterpolator(interpolator);
        }

        void withTranslate(int startX, int startY, int deltaX, int deltaY) {
            mLastTranslateX = 0;
            mLastTranslateY = 0;
            mTranslateScroller.startScroll(0, 0, deltaX, deltaY, mAnimaDuring);
        }

        void withScale(float form, float to) {
            mScaleScroller.startScroll((int) (form * 10000), 0, (int) ((to - form) * 10000), 0,
                    mAnimaDuring);
        }

        void withRotate(int fromDegrees, int toDegrees) {
            mRotateScroller.startScroll(fromDegrees, 0, toDegrees - fromDegrees, 0, mAnimaDuring);
        }

        void withRotate(int fromDegrees, int toDegrees, int during) {
            mRotateScroller.startScroll(fromDegrees, 0, toDegrees - fromDegrees, 0, during);
        }

        void withFling(float velocityX, float velocityY) {
            mLastFlingX = velocityX < 0 ? Integer.MAX_VALUE : 0;
            int distanceX = (int) (velocityX > 0 ? Math.abs(mImgRect.left)
                    : mImgRect.right - mWidgetRect.right);
            distanceX = velocityX < 0 ? Integer.MAX_VALUE - distanceX : distanceX;
            int minX = velocityX < 0 ? distanceX : 0;
            int maxX = velocityX < 0 ? Integer.MAX_VALUE : distanceX;
            int overX = velocityX < 0 ? Integer.MAX_VALUE - minX : distanceX;

            mLastFlingY = velocityY < 0 ? Integer.MAX_VALUE : 0;
            int distanceY = (int) (velocityY > 0 ? Math.abs(mImgRect.top)
                    : mImgRect.bottom - mWidgetRect.bottom);
            distanceY = velocityY < 0 ? Integer.MAX_VALUE - distanceY : distanceY;
            int minY = velocityY < 0 ? distanceY : 0;
            int maxY = velocityY < 0 ? Integer.MAX_VALUE : distanceY;
            int overY = velocityY < 0 ? Integer.MAX_VALUE - minY : distanceY;

            if (velocityX == 0) {
                maxX = 0;
                minX = 0;
            }

            if (velocityY == 0) {
                maxY = 0;
                minY = 0;
            }

            mFlingScroller
                    .fling(mLastFlingX, mLastFlingY, (int) velocityX, (int) velocityY, minX, maxX,
                            minY, maxY,
                            Math.abs(overX) < MAX_FLING_OVER_SCROLL * 2 ? 0 : MAX_FLING_OVER_SCROLL,
                            Math.abs(overY) < MAX_FLING_OVER_SCROLL * 2 ? 0
                                    : MAX_FLING_OVER_SCROLL);
        }

        void start() {
            isRuning = true;
            postExecute();
        }

        void stop() {
            removeCallbacks(this);
            mTranslateScroller.abortAnimation();
            mScaleScroller.abortAnimation();
            mFlingScroller.abortAnimation();
            mRotateScroller.abortAnimation();
            isRuning = false;
        }

        @Override
        public void run() {
            boolean endAnimation = true;

            if (mScaleScroller.computeScrollOffset()) {
                mScale = mScaleScroller.getCurrX() / 10000f;
                endAnimation = false;
            }

            if (mTranslateScroller.computeScrollOffset()) {
                int currX = mTranslateScroller.getCurrX();
                int tx = currX - mLastTranslateX;
                int currY = mTranslateScroller.getCurrY();
                int ty = currY - mLastTranslateY;
                mTranslateX += tx;
                mTranslateY += ty;
                mLastTranslateX = currX;
                mLastTranslateY = currY;
                endAnimation = false;
            }

            if (mFlingScroller.computeScrollOffset()) {
                int x = mFlingScroller.getCurrX() - mLastFlingX;
                int y = mFlingScroller.getCurrY() - mLastFlingY;

                mLastFlingX = mFlingScroller.getCurrX();
                mLastFlingY = mFlingScroller.getCurrY();

                mTranslateX += x;
                mTranslateY += y;
                endAnimation = false;
            }

            if (mRotateScroller.computeScrollOffset()) {
                mDegrees = mRotateScroller.getCurrX();
                endAnimation = false;
            }

            if (!endAnimation) {
                applyAnima();
                postExecute();
            } else {
                isRuning = false;
                if (mCompleteCallBack != null) {
                    mCompleteCallBack.run();
                    mCompleteCallBack = null;
                }
            }
        }

        private void applyAnima() {
            mAnimaMatrix.reset();
            mAnimaMatrix.postTranslate(-mBaseRect.left, -mBaseRect.top);
            mAnimaMatrix.postTranslate(mRotateCenter.x, mRotateCenter.y);
            mAnimaMatrix.postTranslate(-mHalfBaseRectWidth, -mHalfBaseRectHeight);
            mAnimaMatrix.postRotate(mDegrees, mRotateCenter.x, mRotateCenter.y);
            mAnimaMatrix.postScale(mScale, mScale, mScaleCenter.x, mScaleCenter.y);
            mAnimaMatrix.postTranslate(mTranslateX, mTranslateY);
            executeTranslate();
        }

        private void postExecute() {
            if (isRuning) {
                post(this);
            }
        }
    }
}
