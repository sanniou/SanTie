package com.saniou.santieba.dialog;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.library.baseAdapters.BR;

import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.saniou.santieba.R;
import com.sanniou.multiitem.DataItem;

/**
 * 解决弹出 dialog 后 Android5.0+ status bar 变黑
 */
public class ItemBottomDialog extends BottomSheetDialog {

  private DataItem mItem;

  public ItemBottomDialog(@NonNull Context context, DataItem item) {
    this(context, 0, item);
  }

  public ItemBottomDialog(@NonNull Context context, @StyleRes int theme, DataItem item) {
    super(context, theme);
    mItem = item;
    setCanceledOnTouchOutside(false);
  }

  protected ItemBottomDialog(@NonNull Context context, boolean cancelable,
      OnCancelListener cancelListener, DataItem item) {
    super(context, cancelable, cancelListener);
    setCanceledOnTouchOutside(false);
    mItem = item;
  }

  public ItemBottomDialog canceledOnTouchOutside(boolean b) {
    setCanceledOnTouchOutside(b);
    return this;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    int height = ScreenUtils.getScreenHeight();
    int statusBarHeight = BarUtils.getStatusBarHeight();
    int dialogHeight = height - statusBarHeight;
    getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
        dialogHeight == 0 ? ViewGroup.LayoutParams.MATCH_PARENT : dialogHeight);
  }

  @Override
  public void show() {
    setContentView(createView());
    getDelegate().findViewById(R.id.design_bottom_sheet)
        .setBackgroundColor(Color.TRANSPARENT);
    super.show();
  }

  public ItemBottomDialog showSelf() {
    show();
    return this;
  }

  private View createView() {
    ViewDataBinding binding =
        DataBindingUtil.inflate(LayoutInflater.from(getContext()), mItem.getItemType(), null, false);
    binding.setVariable(BR.item, mItem);
    binding.executePendingBindings();
    return binding.getRoot();
  }
}
