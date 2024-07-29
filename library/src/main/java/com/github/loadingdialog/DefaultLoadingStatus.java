package com.github.loadingdialog;

/**
 *
 * description: 
 */
public enum DefaultLoadingStatus implements LoadingStatus {
    LOADING(LoadingStatus.LOADING),
    SUCCESS(LoadingStatus.SUCCESS),
    ERROR(LoadingStatus.ERROR);

    private final int status;

    DefaultLoadingStatus(int status) {
        this.status = status;
    }

    @Override
    public int getStatus() {
        return status;
    }
}
