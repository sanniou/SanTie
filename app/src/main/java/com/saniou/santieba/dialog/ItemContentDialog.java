package com.saniou.santieba.dialog;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.library.baseAdapters.BR;

import com.blankj.utilcode.util.LogUtils;
import com.sanniou.multiitem.DataItem;
import com.sanniou.multiitem.WrapperDataItem;


public class ItemContentDialog extends LContentDialog<DataItem, ItemContentDialog> {

  private DataItem mItem;
  private ViewDataBinding mDataBinding;

  public ItemContentDialog(@NonNull Context context, DataItem item) {
    super(context, item.getItemType(), item);
  }

  @Override
  protected void initDialog(Object obj) {
    mItem = (DataItem) obj;
    super.initDialog(obj);
  }

  @Override
  protected void initContent(View inflate) {
    mDataBinding = DataBindingUtil.bind(inflate);
    if (mDataBinding == null) {
      LogUtils.e("DataBinding  null");
      return;
    }
    mDataBinding.setVariable(BR.item, mItem);
    mDataBinding.executePendingBindings();
    if (mItem instanceof WrapperDataItem) {
      ((WrapperDataItem) mItem).executeHandlers(mDataBinding.getRoot());
    }
  }

  public void executePendingBindings() {
    mDataBinding.executePendingBindings();
  }
}
