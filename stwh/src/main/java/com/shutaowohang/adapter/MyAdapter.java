package com.shutaowohang.adapter;

/**
 * Created by 78421 on 2016/11/27.
 */



import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shutaowohang.R;

import java.util.List;

/**
 * Created by liuzipeng on 15/12/4.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<String> mList;
    private LayoutInflater mInflater;

    public MyAdapter(LayoutInflater inflater, List<String> mList) {
        this.mList = mList;
        mInflater=inflater;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType != 1) {
            view = mInflater.inflate(R.layout.item, parent, false);
        } else {
            view = mInflater.inflate(R.layout.last_item, parent, false);
        }

        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == mList.size() - 1) {
            return 1;
        } else {
            return 0;
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
