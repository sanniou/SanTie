//package com.saniou.santieba.dialog;
//
//import android.content.Context;
//import android.graphics.Color;
//import android.os.Bundle;
//import android.view.ViewGroup;
//
//import androidx.annotation.DrawableRes;
//import androidx.annotation.NonNull;
//import androidx.annotation.StyleRes;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.blankj.utilcode.util.BarUtils;
//import com.blankj.utilcode.util.ScreenUtils;
//import com.google.android.material.bottomsheet.BottomSheetDialog;
//import com.saniou.santieba.R;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * 解决弹出 dialog 后 Android5.0+ status bar 变黑
// */
//public class LBottomSheetDialog<T> extends BottomSheetDialog {
//
//  private BaseClickableAdapter.OnItemClickListener<T> mListener;
//  private List<T> mStrings;
//  private List<Integer> mIcons;
//  private BaseClickableAdapter<T> mAdapter;
//  private ItemConvertHelper<T> mConvertHelper;
//
//  public LBottomSheetDialog(@NonNull Context context) {
//    this(context, 0);
//  }
//
//  public LBottomSheetDialog(@NonNull Context context, @StyleRes int theme) {
//    super(context, theme);
//    setCanceledOnTouchOutside(false);
//  }
//
//  protected LBottomSheetDialog(@NonNull Context context, boolean cancelable,
//      OnCancelListener cancelListener) {
//    super(context, cancelable, cancelListener);
//    setCanceledOnTouchOutside(false);
//  }
//
//  public LBottomSheetDialog<T> canceledOnTouchOutside(boolean b) {
//    setCanceledOnTouchOutside(b);
//    return this;
//  }
//
//  @Override
//  protected void onCreate(Bundle savedInstanceState) {
//    super.onCreate(savedInstanceState);
//    int height = ScreenUtils.getScreenHeight();
//    int statusBarHeight = BarUtils.getStatusBarHeight();
//    int dialogHeight = height - statusBarHeight;
//    getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
//        dialogHeight == 0 ? ViewGroup.LayoutParams.MATCH_PARENT : dialogHeight);
//  }
//
//  @Override
//  public void show() {
//    setContentView(onCreateView());
//    super.show();
//  }
//
//  private RecyclerView onCreateView() {
//    RecyclerView view = new RecyclerView(getContext());
//    view.setBackgroundColor(Color.WHITE);
//    view.setLayoutManager(new LinearLayoutManager(getContext()));
//    mAdapter = new BaseClickableAdapter<T>(R.layout.item_popup) {
//      @Override
//      public void onBindHolder(LViewHolder holder, T item) {
//        holder.setText(R.id.text1,
//            mConvertHelper != null ? mConvertHelper.convertToString(item) : item.toString());
//        int position = holder.getAdapterPosition();
//        if (mIcons != null && mIcons.size() > position) {
//          holder.setImageResource(R.id.image1, mIcons.get(position));
//        }
//      }
//    }.setOnItemClickListener(new BaseClickableAdapter.OnItemClickListener<T>() {
//      @Override
//      public void onItemClick(LViewHolder holder, T item) {
//        if (mListener != null) {
//          mListener.onItemClick(holder, item);
//        }
//        dismiss();
//      }
//    });
//    mAdapter.setData(mStrings);
//    view.setAdapter(mAdapter);
//    return view;
//  }
//
//  public LBottomSheetDialog<T> onItemClick(
//      BaseClickableAdapter.OnItemClickListener<T> listener) {
//    mListener = listener;
//    return this;
//  }
//
//  public LBottomSheetDialog<T> items(T... items) {
//    return items(Arrays.asList(items));
//  }
//
//  public LBottomSheetDialog<T> items(List<T> items) {
//    mStrings = items;
//    if (mAdapter != null) {
//      mAdapter.setData(mStrings);
//      mAdapter.notifyDataSetChanged();
//    }
//    return this;
//  }
//
//  public LBottomSheetDialog<T> icons(@DrawableRes Integer... icons) {
//    mIcons = Arrays.asList(icons);
//    return this;
//  }
//
//  public LBottomSheetDialog<T> convert(ItemConvertHelper<T> convertHelper) {
//    mConvertHelper = convertHelper;
//    return this;
//  }
//
//  public interface ItemConvertHelper<T> {
//
//    String convertToString(T item);
//  }
//}
