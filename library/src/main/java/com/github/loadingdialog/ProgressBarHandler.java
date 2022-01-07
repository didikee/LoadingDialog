package com.github.loadingdialog;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;

/**
 *
 * description: 
 */
public class ProgressBarHandler implements ImageHandler<ProgressBar> {

    @NonNull
    @Override
    public ProgressBar getImage(@NonNull Context context) {
        ProgressBar progressBar = new ProgressBar(context);
        progressBar.setIndeterminate(true);
        Drawable drawable = progressBar.getIndeterminateDrawable();
        if (drawable != null) {
            DrawableCompat.setTint(drawable, Color.WHITE);
        }else {
            Log.d("===","000");
        }
        return progressBar;
    }

    @Nullable
    @Override
    public FrameLayout.LayoutParams getParams(@NonNull Context context) {
        return null;
    }
}
