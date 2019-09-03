package com.saniou.santieba.utils;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.text.Html.ImageGetter;

import androidx.core.content.ContextCompat;

import com.saniou.santieba.R;
import com.saniou.santieba.R.drawable;

public class EmojiImageGetter implements ImageGetter {

    private Context mContext;
    private int resId;

    public EmojiImageGetter(Context context) {
        this.mContext = context;
    }

    @Override
    public Drawable getDrawable(String str) {
        try {
            this.resId = ResourceMapping.getResId(str, drawable.class);
            Drawable drawable = ContextCompat.getDrawable(this.mContext, this.resId);
            drawable.setBounds(0, 0, (drawable.getIntrinsicWidth() / 5) * 4,
                    (drawable.getIntrinsicHeight() / 5) * 4);
            return drawable;
        } catch (NotFoundException unused) {
            Drawable drawable2 = ContextCompat
                    .getDrawable(this.mContext, drawable.ic_base_banner_current);
            drawable2
                    .setBounds(0, 0, drawable2.getIntrinsicWidth() / 2, drawable2.getIntrinsicHeight() / 2);
            return drawable2;
        }
    }
}
