package com.saniou.santieba.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Base64;
import android.widget.ImageView;

import androidx.annotation.IntDef;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.target.Target;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.nio.channels.FileChannel;

public class ImageUtil {
    /**
     * 智能省流
     */
    public static final int SETTINGS_SMART_ORIGIN = 0;
    /**
     * 智能无图
     */
    public static final int SETTINGS_SMART_LOAD = 1;
    /**
     * 始终高质量
     */
    public static final int SETTINGS_ALL_ORIGIN = 2;
    /**
     * 始终无图
     */
    public static final int SETTINGS_ALL_NO = 3;

    public static final int LOAD_TYPE_SMALL_PIC = 0;
    public static final int LOAD_TYPE_AVATAR = 1;
    public static final int LOAD_TYPE_NO_RADIUS = 2;
    public static final String TAG = "ImageUtil";

    public static File compressImage(Bitmap bitmap, File output, int maxSize) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int quality = 100;
        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        while (baos.toByteArray().length / 1024 > maxSize && quality > 0) {  //循环判断如果压缩后图片是否大于20kb,大于继续压缩 友盟缩略图要求不大于18kb
            baos.reset();//重置baos即清空baos
            quality -= 5;//每次都减少5
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, baos);//这里压缩options%，把压缩后的数据存放到baos中
        }
        try {
            FileOutputStream fos = new FileOutputStream(output);
            try {
                fos.write(baos.toByteArray());
                fos.flush();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return output;
    }

    public static File bitmapToFile(Bitmap bitmap, File output) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int quality = 100;
        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, baos);
        try {
            FileOutputStream fos = new FileOutputStream(output);
            try {
                fos.write(baos.toByteArray());
                fos.flush();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return output;
    }

    public static File compressImage(Bitmap bitmap, File output) {
        return compressImage(bitmap, output, 100);
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(),
                drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    public static boolean copyFile(FileInputStream src, FileOutputStream dest) {
        boolean result = false;
        if ((src == null) || (dest == null)) {
            return result;
        }

        FileChannel srcChannel = null;
        FileChannel dstChannel = null;

        try {
            srcChannel = src.getChannel();
            dstChannel = dest.getChannel();
            srcChannel.transferTo(0, srcChannel.size(), dstChannel);
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
            return result;
        }
        try {
            srcChannel.close();
            dstChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean copyFile(File src, File dest) {
        boolean result = false;
        if ((src == null) || (dest == null)) {
            return result;
        }
        if (dest.exists()) {
            dest.delete();
        }
        try {
            dest.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileChannel srcChannel = null;
        FileChannel dstChannel = null;

        try {
            srcChannel = new FileInputStream(src).getChannel();
            dstChannel = new FileOutputStream(dest).getChannel();
            srcChannel.transferTo(0, srcChannel.size(), dstChannel);
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
            return result;
        }
        try {
            srcChannel.close();
            dstChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static void changeBrightness(ImageView imageView, int brightness) {
        ColorMatrix cMatrix = new ColorMatrix();
        cMatrix.set(new float[]{1, 0, 0, 0, brightness, 0, 1, 0, 0, brightness, // 改变亮度
                0, 0, 1, 0, brightness, 0, 0, 0, 1, 0});
        imageView.setColorFilter(new ColorMatrixColorFilter(cMatrix));
    }

    public static String imageToBase64(InputStream is) {
        if (is == null) {
            return null;
        }
        byte[] data = null;
        String result = null;
        try {
            //创建一个字符流大小的数组。
            data = new byte[is.available()];
            //写入数组
            is.read(data);
            //用默认的编码格式进行编码
            result = Base64.encodeToString(data, Base64.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return result;
    }

    public static String imageToBase64(File file) {
        if (file == null) {
            return null;
        }
        String result = null;
        try {
            InputStream is = new FileInputStream(file);
            result = imageToBase64(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public interface ShareTaskCallback {
        void onGetUri(Uri uri);
    }

    @IntDef({LOAD_TYPE_SMALL_PIC, LOAD_TYPE_AVATAR, LOAD_TYPE_NO_RADIUS})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LoadType {
    }

    @IntDef({SETTINGS_SMART_ORIGIN, SETTINGS_SMART_LOAD, SETTINGS_ALL_ORIGIN, SETTINGS_ALL_NO})
    public @interface ImageLoadSettings {
    }

    public static class DownloadAsyncTask extends AsyncTask<Void, Integer, File> {
        private WeakReference<Context> contextWeakReference;
        private TaskCallback callback;
        private String url;

        public DownloadAsyncTask(Context context, String url, TaskCallback callback) {
            this.contextWeakReference = new WeakReference<>(context);
            this.url = url;
            this.callback = callback;
        }

        public TaskCallback getCallback() {
            return callback;
        }

        public String getUrl() {
            return url;
        }

        private Context getContext() {
            return contextWeakReference.get();
        }

        @Override
        protected File doInBackground(Void... voids) {
            File file = null;
            try {
                FutureTarget<File> future = Glide.with(getContext())
                        .asFile()
                        .load(getUrl())
                        .submit(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
                file = future.get();
                return file;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return file;
        }

        @Override
        protected void onPostExecute(File file) {
            super.onPostExecute(file);
            getCallback().onPostExecute(file);
        }

        public interface TaskCallback {
            void onPostExecute(File file);
        }
    }
}
