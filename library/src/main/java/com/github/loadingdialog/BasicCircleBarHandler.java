package com.github.loadingdialog;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import com.github.loadingdialog.views.LoadCircleView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 *
 * description: 
 */
public class BasicCircleBarHandler implements ImageHandler<View> {
    @NonNull
    @Override
    public View getImage(@NonNull Context context) {
        LoadCircleView view = new LoadCircleView(context);
        return view;
    }

    @Nullable
    @Override
    public FrameLayout.LayoutParams getParams(@NonNull Context context) {
//        int size = context.getResources().getDimensionPixelSize(android.R.dimen.app_icon_size);
//        return new FrameLayout.LayoutParams(size,size);
        return null;
    }

}
