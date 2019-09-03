package com.saniou.santieba.vo;

import androidx.annotation.ColorInt;

import com.saniou.santieba.R;
import com.sanniou.common.utilcode.util.SizeUtils;
import com.sanniou.common.widget.recyclerview.Item;

public class DividerItem implements Item {
    public int height;
    public int color;
    public int backgroundColor;
    public int padding;

    public DividerItem(int height) {
        this.height = height;
    }

    public DividerItem() {
        this.height = SizeUtils.dp2px(12);
    }

    public DividerItem(int height, @ColorInt int color) {
        this.height = height;
        this.color = color;
    }

    public DividerItem(int height, @ColorInt int color, @ColorInt int backgroundColor, int padding) {
        this.height = height;
        this.color = color;
        this.backgroundColor = backgroundColor;
        this.padding = padding;
    }

    @Override
    public int getGridSpan() {
        return -1;
    }

    @Override
    public int getType() {
        return R.layout.item_divider;
    }
}
