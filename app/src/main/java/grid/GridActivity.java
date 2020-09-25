package grid;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import base.BaseActivity;
import grid.module.GridActivityMode;
import widget.grid.HorizontalGridView;
import widget.grid.OnItemChildViewClickListener;
import widget.grid.OnItemClickListener;
import widget.toast.ToastKit;

/**
 * @desc: 网格页
 * @author: zsp
 * @date: 2020-09-23 10:07
 */
public class GridActivity extends BaseActivity {
    private HorizontalGridView<GridActivityMode> gridActivityHgv;
    private List<GridActivityMode> gridActivityModeList;

    /**
     * 布局资源 ID
     *
     * @return 布局资源 ID
     */
    @Override
    protected int layoutResID() {
        return R.layout.activity_grid;
    }

    /**
     * 初始控件
     */
    @Override
    protected void stepUI() {
        gridActivityHgv = findViewById(R.id.gridActivityHgv);
    }

    /**
     * 初始配置
     */
    @Override
    protected void initConfiguration() {
        gridActivityHgv.setMaxCountEveryPage(8);
        gridActivityHgv.loop(true);
        gridActivityModeList = new ArrayList<>();
    }

    /**
     * 设置监听
     */
    @Override
    protected void setListener() {
        gridActivityHgv.setOnItemClickListener(new OnItemClickListener<GridActivityMode>() {
            @Override
            public void onItemClick(GridActivityMode grid, int position) {
                ToastKit.showShort(grid.getId() + "||" + grid.getTitle() + "||" + grid.getDescription());
            }
        });
        gridActivityHgv.setOnItemChildViewClickListener(new OnItemChildViewClickListener<GridActivityMode>() {
            @Override
            public void onItemChildViewClick(GridActivityMode grid, int position) {
                ToastKit.showShort(grid.getTitle() + " 子视图点击");
            }
        });
    }

    /**
     * 初始数据
     */
    @Override
    protected void initData() {
        gridActivityModeList.add(new GridActivityMode("1", "甲", R.mipmap.ic_launcher, "", "说明"));
        gridActivityModeList.add(new GridActivityMode("2", "乙", R.mipmap.ic_launcher, "", "说明"));
        gridActivityModeList.add(new GridActivityMode("3", "丙", R.mipmap.ic_launcher, "", "说明"));
        gridActivityModeList.add(new GridActivityMode("4", "丁", R.mipmap.ic_launcher, "", "说明"));
        gridActivityModeList.add(new GridActivityMode("5", "金", R.mipmap.ic_launcher, "", "说明"));
        gridActivityModeList.add(new GridActivityMode("6", "木", R.mipmap.ic_launcher, "", "说明"));
        gridActivityModeList.add(new GridActivityMode("7", "水", R.mipmap.ic_launcher, "", "说明"));
        gridActivityModeList.add(new GridActivityMode("8", "火", R.mipmap.ic_launcher, "", "说明"));
        gridActivityModeList.add(new GridActivityMode("9", "土", R.mipmap.ic_launcher, "", "说明"));
        gridActivityModeList.add(new GridActivityMode("0", "天", R.mipmap.ic_launcher, "", "说明"));
        gridActivityModeList.add(new GridActivityMode("11", "地", R.mipmap.ic_launcher, "", "说明"));
        gridActivityModeList.add(new GridActivityMode("12", "玄", R.mipmap.ic_launcher, "", "说明"));
        gridActivityModeList.add(new GridActivityMode("13", "黄", R.mipmap.ic_launcher, "", "说明"));
        gridActivityModeList.add(new GridActivityMode("14", "宇", R.mipmap.ic_launcher, "", "说明"));
        gridActivityModeList.add(new GridActivityMode("15", "宙", R.mipmap.ic_launcher, "", "说明"));
        gridActivityModeList.add(new GridActivityMode("16", "洪", R.mipmap.ic_launcher, "", "说明"));
        gridActivityModeList.add(new GridActivityMode("17", "荒", R.mipmap.ic_launcher, "", "说明"));
    }

    /**
     * 开始逻辑
     */
    @Override
    protected void startLogic() {
        gridActivityHgv.setData(gridActivityModeList);
    }
}
