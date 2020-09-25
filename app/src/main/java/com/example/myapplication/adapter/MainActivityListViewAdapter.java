package com.example.myapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.module.MainActivityModule;

import widget.adapter.BaseListViewAdapter;

/**
 * Created on 2020-09-18
 *
 * @author zsp
 * @desc 主页 ListView 适配器
 */
public class MainActivityListViewAdapter extends BaseListViewAdapter<MainActivityModule> {
    public MainActivityListViewAdapter(Context context) {
        super(context);
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (null == view) {
            viewHolder = new ViewHolder();
            view = layoutInflater.inflate(R.layout.item_main_activity, null, false);
            viewHolder.mainActivityItemTv = view.findViewById(R.id.mainActivityItemTv);
            viewHolder.mainActivityItemIv = view.findViewById(R.id.mainActivityItemIv);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        MainActivityModule mainActivityModule = getItem(i);
        // 设置条目子视图点击监听
        setOnItemChildViewClickListener(i, mainActivityModule, viewHolder.mainActivityItemIv);
        // 显示
        viewHolder.mainActivityItemTv.setText(mainActivityModule.getName());
        return view;
    }

    private static class ViewHolder {
        private TextView mainActivityItemTv;
        private ImageView mainActivityItemIv;
    }
}
