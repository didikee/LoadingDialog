package com.github.loadingdialog;

import android.app.Activity;
import android.content.Context;

/**
 *
 * description: 
 */
public final class LoadingDialog {
    private final Context context;
    private InternalDialog dialog;

    public LoadingDialog(Context context) {
        this.context = context;
        if (!(context instanceof Activity)) {
            throw new RuntimeException("Context must be Activity");
        }
    }

    public void show() {
//        dialog = new InternalDialog(context, new ProgressBarHandler());
        dialog = new InternalDialog(context, new BasicCircleBarHandler());
        dialog.setMessage("Loading...");
        dialog.show();
    }

    public void setMessage(CharSequence text) {
        if (dialog != null ) {
            dialog.setMessage(text);
        }
    }
}
