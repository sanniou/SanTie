package com.saniou.santieba.dialog;

import android.content.Context;
import android.os.Handler;
import android.view.View;

import androidx.annotation.NonNull;

import com.saniou.santieba.R;


public class LProgressDialog extends LContentDialog<Integer, LProgressDialog> {

  private final Handler mHandler;
  private int progress;

  public LProgressDialog(@NonNull Context context) {
    this(context, R.layout.dialog_progress);
  }

  public LProgressDialog(@NonNull Context context, int contentLayout) {
    super(context, contentLayout);
    mHandler = new Handler();
  }

  @Override
  protected void initContent(View inflate) {

  }

  public LProgressDialog Progress(Integer content) {
    progress = content;
    return this;
  }

  public Integer Progress() {
    return progress;
  }

  @Override
  public void dismiss() {
    mHandler.removeCallbacksAndMessages(null);
    if (!isShowing()) {
      return;
    }
    super.dismiss();
  }

  @Override
  public LProgressDialog showSlef() {
    show();
    return this;
  }

  public void showDelayed(int delayed) {
    mHandler.postDelayed(this::show, delayed);
  }
}
