package com.saniou.santieba.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.saniou.santieba.R;

public class LMessageDialog extends LContentDialog<CharSequence, LMessageDialog> {

  private TextView mContent;

  public LMessageDialog(@NonNull Context context) {
    super(context, R.layout.dialog_message);
  }

  public LMessageDialog setMessage(CharSequence message) {
    mContent.setText(message);
    return this;
  }

  @Override
  protected void initContent(View inflate) {
    mContent = (TextView) inflate;
  }

  public CharSequence getMessage() {
    return mContent.getText();
  }
}
