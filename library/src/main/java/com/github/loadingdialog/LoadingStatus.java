package com.github.loadingdialog;

/**
 *
 * description: 
 */
public interface LoadingStatus {
    int LOADING = 0;
    int SUCCESS = 0;
    int ERROR = 0;
    /**
     * 获取状态
     * @return
     */
    int getStatus();
}
