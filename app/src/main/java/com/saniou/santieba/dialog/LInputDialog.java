package com.saniou.santieba.dialog;

import android.content.Context;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.blankj.utilcode.util.KeyboardUtils;
import com.saniou.santieba.R;

public class LInputDialog extends LContentDialog<CharSequence, LInputDialog> {

    private EditText mEtContent;

    public LInputDialog(@NonNull Context context) {
        super(context, R.layout.dialog_input);
    }

    @Override
    public void show() {
        super.show();
        mEtContent.postDelayed(
                () -> KeyboardUtils.showSoftInput(mEtContent),
                300L);
    }

    @Override
    public void dismiss() {
        KeyboardUtils.hideSoftInput(mEtContent);
        super.dismiss();
    }

    public CharSequence getTerxt() {
        return mEtContent.getText();
    }

    public LInputDialog inputHint(CharSequence message) {
        mEtContent.setHint(message);
        return this;
    }

    public LInputDialog inputMessage(CharSequence message) {
        mEtContent.setText(message);
        mEtContent.setSelection(message.length());
        return this;
    }

    @Override
    protected void initContent(View inflate) {
        this.mEtContent = (EditText) inflate;
    }
}
