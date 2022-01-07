package com.github.loadingdialog;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 *
 * description: 
 */
public interface ImageHandler<V extends View> {
    @NonNull
    V getImage(@NonNull Context context);

    @Nullable
    FrameLayout.LayoutParams getParams(@NonNull Context context);
}
