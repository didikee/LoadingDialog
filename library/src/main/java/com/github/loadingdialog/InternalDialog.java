package com.github.loadingdialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

/**
 *
 * description: 
 */
final class InternalDialog extends Dialog {
    private View contentView;
    private FrameLayout imageContainer;
    private TextView msgTextView;
    private CharSequence message;
    private final ImageHandler<? extends View> imageHandler;

    public InternalDialog(@NonNull Context context, @NonNull ImageHandler<? extends View> imageHandler) {
        super(context, 0);
        this.imageHandler = imageHandler;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._loadingdialog_interal_dialog);

        contentView = findViewById(R.id.content);
        msgTextView = findViewById(R.id.message);
        imageContainer = findViewById(R.id.layout_image);

        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        // 去掉dialog window的遮罩，1是显示遮罩，0是完成透明
        attributes.dimAmount = 0f;
        window.setAttributes(attributes);

        // 去掉dialog content的背景
        window.setBackgroundDrawableResource(android.R.color.transparent);

        contentView.setBackground(createContentBackground());

        View image = imageHandler.getImage(getContext());
        FrameLayout.LayoutParams params = imageHandler.getParams(getContext());
        if (params == null) {
            params = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
            params.gravity = Gravity.CENTER;
        }
        imageContainer.addView(image, params);

        // bind data
        setMessage(message);
    }

    private GradientDrawable createContentBackground() {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(Color.parseColor("#90000000"));
        drawable.setCornerRadius(15f);
        return drawable;
    }

    public void setMessage(CharSequence text) {
        this.message = text;
        if (msgTextView != null) {
            msgTextView.setText(text);
        }
    }


    public void setImage(View view) {
        View image = imageHandler.getImage(getContext());

    }
}
