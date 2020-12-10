package com.example.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.myapplication.R;
import com.example.myapplication.module.MainActivityModule;

import widget.adapter.BaseRecyclerViewAdapter;

/**
 * Created on 2020-09-21
 *
 * @author zsp
 * @desc 主页 RecyclerView 适配器
 */
public class MainActivityRecyclerViewAdapter extends BaseRecyclerViewAdapter<MainActivityModule, MainActivityRecyclerViewAdapter.MainActivityViewHolder> {
    public MainActivityRecyclerViewAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public MainActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_main_activity, parent, false);
        return new MainActivityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainActivityViewHolder holder, int position) {
        MainActivityModule mainActivityModule = getItem(position);
        // 设置条目子视图点击监听
        setOnItemChildViewClickListener(position, mainActivityModule, holder.mainActivityItemIv);
        // 显示
        holder.mainActivityItemTv.setText(mainActivityModule.getName());
    }

    class MainActivityViewHolder extends BaseRecyclerViewAdapter.BaseViewHolder {
        private final TextView mainActivityItemTv;
        private final ImageView mainActivityItemIv;

        MainActivityViewHolder(@NonNull View itemView) {
            super(itemView);
            mainActivityItemTv = itemView.findViewById(R.id.mainActivityItemTv);
            mainActivityItemIv = itemView.findViewById(R.id.mainActivityItemIv);
        }
    }
}
