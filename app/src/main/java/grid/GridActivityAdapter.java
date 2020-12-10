package grid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import utils.resource.ResourceUtils;
import widget.adapter.BaseGridViewAdapter;
import widget.grid.IGrid;

/**
 * Created on 2020-09-23
 *
 * @author zsp
 * @desc 网格页适配器
 */
public class GridActivityAdapter<T extends IGrid> extends BaseGridViewAdapter<T> {
    public GridActivityAdapter(Context context) {
        super(context);
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (null == view) {
            view = layoutInflater.inflate(R.layout.item_grid_activity, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        T module = getItem(i);
        // 设置条目子视图点击监听
        setOnItemChildViewClickListener(i, module, viewHolder.gridActivityItemIv);
        // 显示
        if (!TextUtils.isEmpty(module.getStringIconId())) {
            viewHolder.gridActivityItemIv.setBackgroundResource(ResourceUtils.getResId(module.getStringIconId(), R.drawable.class));
        } else if (module.getIntIconId() != 0) {
            viewHolder.gridActivityItemIv.setBackgroundResource(module.getIntIconId());
        }
        viewHolder.gridActivityItemTv.setText(module.getTitle());
        return view;
    }

    private static class ViewHolder {
        private final ImageView gridActivityItemIv;
        private final TextView gridActivityItemTv;

        ViewHolder(View view) {
            gridActivityItemIv = view.findViewById(R.id.gridActivityItemIv);
            gridActivityItemTv = view.findViewById(R.id.gridActivityItemTv);
        }
    }
}
