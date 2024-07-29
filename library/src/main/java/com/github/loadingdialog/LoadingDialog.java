package com.github.loadingdialog;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.github.loadingdialog.interal.StatusViewModel;

import java.util.HashMap;

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

    public void show(Builder builder){
        HashMap<Integer, StatusViewModel> viewMap = builder.viewMap;
        StatusViewModel statusViewModel = viewMap.get(DefaultLoadingStatus.LOADING.getStatus());

    }


    public void setMessage(CharSequence text) {
        if (dialog != null) {
            dialog.setMessage(text);
        }
    }

    public static class Builder {
        public final Context context;
        public final HashMap<Integer, StatusViewModel> viewMap = new HashMap<>();

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setLoadingView(int layoutRes) {
            int status = DefaultLoadingStatus.LOADING.getStatus();
            setStatusLayout(layoutRes, status);
            return this;
        }

        public Builder setSuccessView(int layoutRes) {
            int status = DefaultLoadingStatus.SUCCESS.getStatus();
            setStatusLayout(layoutRes, status);
            return this;
        }

        public Builder setErrorView(int layoutRes) {
            int status = DefaultLoadingStatus.ERROR.getStatus();
            setStatusLayout(layoutRes, status);
            return this;
        }

        private void setStatusLayout(int layoutRes, int status) {
            if (viewMap.containsKey(status)) {
                StatusViewModel viewModel = viewMap.get(status);
                if (viewModel == null) {
                    viewModel = new StatusViewModel();
                }
                viewModel.layoutRes = layoutRes;
                viewMap.put(status, viewModel);
            }
        }

        private void setStatusView(View view, int status) {
            if (viewMap.containsKey(status)) {
                StatusViewModel viewModel = viewMap.get(status);
                if (viewModel == null) {
                    viewModel = new StatusViewModel();
                }
                viewModel.layoutView = view;
                viewMap.put(status, viewModel);
            }
        }
    }

}
