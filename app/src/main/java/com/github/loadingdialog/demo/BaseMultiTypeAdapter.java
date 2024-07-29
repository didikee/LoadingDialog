package com.github.loadingdialog.demo;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseMultiTypeAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private static final int TYPE_EMPTY = -1;
    private static final int TYPE_ERROR = -2; // retry
    private int currentType = 0;
    private final List<Integer> typeData = new ArrayList<>();


    public void enableEmpty() {
        currentType = TYPE_EMPTY;
        typeData.clear();
        typeData.add(currentType);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_EMPTY) {

        } else if (viewType == TYPE_ERROR) {

        } else {
            return onCreateViewHolder(viewType, parent);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == TYPE_EMPTY) {

        } else if (itemViewType == TYPE_ERROR) {

        }
    }

    @NonNull
    protected abstract VH onCreateViewHolder(int viewType, @NonNull ViewGroup parent);

    public abstract void onBindViewHolder(int position, @NonNull VH holder);

    @Override
    public int getItemViewType(int position) {
        int size = typeData.size();
        if (size > 0 && getItemCountActual() == 0 && position < size) {
            return typeData.get(position);
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        int itemCountActual = getItemCountActual();
        int size = typeData.size();
        if (itemCountActual == 0 && size > 0) {
            return size;
        }
        return itemCountActual;
    }

    /**
     * @return
     */
    public abstract int getItemCountActual();
}
