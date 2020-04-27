package com.saniou.santieba.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import com.blankj.utilcode.util.LogUtils;
import com.saniou.santieba.R;

import static com.google.android.material.internal.ContextUtils.getActivity;


public abstract class LContentDialog<T, C extends LContentDialog<T, C>> extends Dialog {

  private TextView mTitle;
  private Button mCancel;
  private Button mOk;
  private OnActionListener<T, C> mCancelListener;
  private OnActionListener<T, C> mOkListener;
  private int contentLayout;
  private ViewStub mTitleStub;
  private View.OnClickListener mListener;
  private boolean mDismissable = true;
  private View mButtons;
  private View mContentView;
  private View mButtonTopLine;
  private View mDialogLayout;
  private View mTopClose;
  private View mBottomClose;
  private ImageView mAttachClose;
  private View mSingleView;

  public LContentDialog(@NonNull Context context, @LayoutRes int contentLayout) {
    this(context, contentLayout, null);
  }

  public LContentDialog(@NonNull Context context, @LayoutRes int contentLayout, Object obj) {
    super(context, R.style.LApplicationDialog);
    this.contentLayout = contentLayout;
    initDialog(obj);
  }

  protected void initDialog(Object obj) {
   /* if (ScreenUtils.isPortrait()) {
      ScreenUtils.adaptScreen4VerticalSlide(
          ContextHelper.getActivity(getContext()), BaseActivity.DESIGN_PX,
          false);
    } else {
      ScreenUtils.adaptScreen4VerticalSlide(
          ContextHelper.getActivity(getContext()), BaseActivity.DESIGN_PX,
          false);
    }*/

    setContentView(R.layout.dialog_base);
    mDialogLayout = findViewById(R.id.dialog_layout);
    ViewStub viewStub = findViewById(R.id.dialog_content);
    viewStub.setLayoutResource(contentLayout);
    mContentView = viewStub.inflate();
    initContent(mContentView);

//    ScreenUtils.restoreAdaptScreen();
    mTitleStub = findViewById(R.id.dialog_title);
    mBottomClose = findViewById(R.id.button_close_bottom);
    mAttachClose = findViewById(R.id.button_close_attach);
    mTopClose = findViewById(R.id.button_close_top);
    mButtons = findViewById(R.id.dialog_buttons);
    mButtonTopLine = findViewById(R.id.line_top_of_buttons);
    mCancel = findViewById(R.id.dialog_cancel);
    mSingleView = findViewById(R.id.button_char_view);
    mOk = findViewById(R.id.dialog_sure);
    mListener = view -> {
      if (mDismissable) {
        dismiss();
      }
      if (view.getId() == R.id.dialog_sure && mOkListener != null) {
        mOkListener.onClick(LContentDialog.this, (Button) view);
      } else if (view.getId() == R.id.dialog_cancel && mCancelListener != null) {
        mCancelListener.onClick(LContentDialog.this, (Button) view);
      }
    };
    ViewParent parent = mDialogLayout.getParent();
    if (parent != null) {
      ((ViewGroup) parent).setOnClickListener(mListener);
      mDialogLayout.setOnClickListener(v -> {
        // do nothing
      });
    }
    mOk.setOnClickListener(mListener);
    mCancel.setOnClickListener(mListener);

    mTopClose.setOnClickListener(mListener);
    mBottomClose.setOnClickListener(mListener);
    mAttachClose.setOnClickListener(mListener);
  }

  protected abstract void initContent(View inflate);

  private C getThis() {
    return (C) this;
  }

  public C gravity(int gravity) {
    ((LinearLayout.LayoutParams) mContentView.getLayoutParams()).gravity = gravity;
    mContentView.requestLayout();
    return (C) this;
  }

  public C title(CharSequence title) {
    if (title == null) {
      return getThis();
    }
    if (mTitle == null) {
      if (mTitleStub != null) {
        mTitle = (TextView) mTitleStub.inflate();
        mTitleStub = null;
      } else {
        LogUtils.e("title   设置失败");
        return getThis();
      }
    }
    mTitle.setText(title);
    return getThis();
  }

  public final C cancelHint(CharSequence hint) {
    mCancel.setText(hint);
    return getThis();
  }

  public Button getCancel() {
    return mCancel;
  }

  public Button getOk() {
    return mOk;
  }

  public final C cancelColor(@ColorInt int color) {
    mCancel.setTextColor(color);
    return getThis();
  }

  public final C okColor(@ColorInt int color) {
    mOk.setTextColor(color);
    return getThis();
  }

  public C okHint(CharSequence hint) {
    mOk.setText(hint);
    return getThis();
  }

  public C showOk(boolean show) {
    mOk.setVisibility(show ? View.VISIBLE : View.GONE);
    return getThis();
  }

  public C showButtons(boolean show) {
    mButtons.setVisibility(show ? View.VISIBLE : View.GONE);
    mButtonTopLine.setVisibility(show ? View.VISIBLE : View.GONE);
    return getThis();
  }

  public C showCancle(boolean show) {
    mCancel.setVisibility(show ? View.VISIBLE : View.GONE);
    return getThis();
  }

  public C dismissable(boolean cancelable) {
    setCancelable(cancelable);
    mDismissable = cancelable;
    return getThis();
  }

  public C showOkSingle(boolean single) {
    if (single) {
      mCancel.setVisibility(View.GONE);
      mSingleView.setVisibility(View.GONE);
    } else {
      mCancel.setVisibility(View.VISIBLE);
      mSingleView.setVisibility(View.VISIBLE);
    }
    return getThis();
  }

  public C okListener(LContentDialog.OnActionListener<T, C> okListener) {
    mOkListener = okListener;
    return getThis();
  }

  public C cancelListener(LContentDialog.OnActionListener<T, C> cancelListener) {
    mCancelListener = cancelListener;
    return getThis();
  }

  public C dismiddListener(OnDismissListener listener) {
    setOnDismissListener(listener);
    return getThis();
  }

  public LContentDialog<T, C> showCloseTop() {
    showButtons(false);
    mTopClose.setVisibility(View.VISIBLE);
    return this;
  }

  public LContentDialog<T, C> hideCloseTop() {
    mTopClose.setVisibility(View.GONE);
    return this;
  }

  public LContentDialog<T, C> showCloseBottom() {
    showButtons(false);
    mBottomClose.setVisibility(View.VISIBLE);
    return this;
  }

  public LContentDialog<T, C> hideCloseBottom() {
    mBottomClose.setVisibility(View.GONE);
    return this;
  }

  public LContentDialog<T, C> setAttachClose(int res) {
    mAttachClose.setImageResource(res);
    return this;
  }

  public LContentDialog<T, C> showAttachClose() {
    showButtons(false);
    mAttachClose.setVisibility(View.VISIBLE);
    return this;
  }

  public LContentDialog<T, C> hideAttachClose() {
    mAttachClose.setVisibility(View.GONE);
    return this;
  }

  public C showSlef() {
    show();
    return getThis();
  }

  @Override
  public void show() {
    Activity activity = getActivity(getContext());
    if (activity == null) {
      return;
    } else {
      if (activity.isDestroyed()) {
        return;
      }
    }

    super.show();
  }

  public interface OnActionListener<T, C extends LContentDialog<T, C>> {

    void onClick(LContentDialog<T, C> dialog, Button button);
  }
}
