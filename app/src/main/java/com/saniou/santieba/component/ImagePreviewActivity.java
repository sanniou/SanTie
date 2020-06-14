package com.saniou.santieba.component;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ActivityUtils;
import com.saniou.santieba.R;
import com.saniou.santieba.model.TiebaRequest;
import com.saniou.santieba.vo.PhotoViewItem;
import com.saniou.santieba.widget.photoview.Info;
import com.saniou.santieba.widget.photoview.PhotoView;
import com.sanniou.multiitem.DataItem;
import com.sanniou.multiitem.MultiItemAdapter;
import com.sanniou.multiitem.MultiItemArrayList;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class ImagePreviewActivity extends AppCompatActivity {

    public static final String KEY_IMAGE_INFO = "keyImageInfo";
    public static final String KEY_ANIMA_INFO = "KEY_ANIMA_INFO";
    public static final String KEY_IMAGE_POSITION = "keyImagePosition";
    private List<String> images;
    private int mPosition;
    private Info mInfo;

    private MultiItemArrayList<DataItem> items = new MultiItemArrayList<>();
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            initView();
        } catch (IOException e) {
            e.printStackTrace();
            finish();
        }
    }

    private void initView() throws IOException {
        setContentView(R.layout.activity_image_preview);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new MultiItemAdapter<>(items));
        mRecyclerView = recyclerView;
        initData();
    }


    protected void initData() throws IOException {
        String jsonString = getIntent().getStringExtra(KEY_IMAGE_INFO);
        mPosition = getIntent().getIntExtra(KEY_IMAGE_POSITION, 0);
        mInfo = getIntent().getParcelableExtra(KEY_ANIMA_INFO);
        images = TiebaRequest.INSTANCE.getMoshi().<List<String>>adapter(Types.newParameterizedType(List.class, String.class))
                .fromJson(jsonString);

        for (String image : images) {
            items.add(new PhotoViewItem(image));
        }

        mRecyclerView.scrollToPosition(mPosition);
    }

    /**
     * ---------------------------------------------------- static method
     * ----------------------------------------------------
     */

    public static void imagePreview(int index, List<String> images) {
        imagePreview(index, images, null);
    }

    public static void imagePreview(List<String> images) {
        imagePreview(0, images);
    }

    public static void imagePreview(String... images) {
        imagePreview(Arrays.asList(images));
    }

    public static void imagePreview(int position, String... images) {
        imagePreview(position, Arrays.asList(images));
    }

    public static void imagePreview(int index, List<String> images, ImageView view) {
        Info imageViewInfo = null;
        if (view != null) {
            imageViewInfo = PhotoView.getImageViewInfo(view);
        }

        Intent intent = new Intent(view.getContext(), ImagePreviewActivity.class);

        intent.putExtra(ImagePreviewActivity.KEY_IMAGE_INFO,
                TiebaRequest.INSTANCE.getMoshi().adapter(Types.newParameterizedType(List.class, String.class)).toJson(images));
        intent.putExtra(ImagePreviewActivity.KEY_IMAGE_POSITION, index);
        intent.putExtra(ImagePreviewActivity.KEY_ANIMA_INFO, imageViewInfo);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_NEW_TASK);
        ActivityUtils.startActivity(intent);
    }

    @Override
    public void finishAfterTransition() {
        finish();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }


    @Override
    public void onBackPressed() {
//        if (mInfo != null) {
//            PhotoView photoView = (PhotoView) mRecyclerView.getLayoutManager().getChildAt(0);
//            photoView.animaTo(
//                    mInfo,
//                    () -> {
//                        mInfo = null;
//                        onBackPressed();
//                    });
//        } else {
        super.onBackPressed();
//        }
    }
}
