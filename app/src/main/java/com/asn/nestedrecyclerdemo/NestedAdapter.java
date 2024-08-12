package com.asn.nestedrecyclerdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NestedAdapter extends RecyclerView.Adapter<NestedAdapter.NestHolder> {

    private List<MyData.NestedData> nestedDataList;
    private OnChildClick childClick;
    private int parentPosition;

    public NestedAdapter(List<MyData.NestedData> nestedDataList, OnChildClick childClick, int parentPosition) {
        this.nestedDataList = nestedDataList;
        this.childClick = childClick;
        this.parentPosition = parentPosition;
    }

    @NonNull
    @Override
    public NestedAdapter.NestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NestHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_nested, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NestedAdapter.NestHolder holder, int position) {
        MyData.NestedData item = nestedDataList.get(position);
        holder.tvTitle.setText(item.getNestTitle());

        holder.itemView.setOnClickListener(v -> {
            //取得點擊到的item，並使用interface回傳
            childClick.onChildClick(item,parentPosition);
        });
    }

    @Override
    public int getItemCount() {
        return nestedDataList.size();
    }

    interface OnChildClick {
        void onChildClick(MyData.NestedData data,int parentPosition);
    }

    public class NestHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;

        public NestHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.textView_nestTitle);
        }
    }
}
