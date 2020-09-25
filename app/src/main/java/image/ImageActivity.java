package image;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myapplication.R;

import base.BaseActivity;
import utils.image.DrawableUtils;
import utils.view.ViewUtils;
import widget.toast.ToastKit;

/**
 * @desc: 图像页
 * @author: zsp
 * @date: 2020-09-14 15:31
 */
public class ImageActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageActivityIv;
    private Button imageActivityBtnLocalLoad;
    private Button imageActivityBtnNetworkLoad;

    /**
     * 布局资源 ID
     *
     * @return 布局资源 ID
     */
    @Override
    protected int layoutResID() {
        return R.layout.activity_image;
    }

    /**
     * 初始控件
     */
    @Override
    protected void stepUI() {
        imageActivityIv = findViewById(R.id.imageActivityIv);
        imageActivityBtnLocalLoad = findViewById(R.id.imageActivityBtnLocalLoad);
        imageActivityBtnNetworkLoad = findViewById(R.id.imageActivityBtnNetworkLoad);
    }

    /**
     * 初始配置
     */
    @Override
    protected void initConfiguration() {

    }

    /**
     * 设置监听
     */
    @Override
    protected void setListener() {
        ViewUtils viewUtils = new ViewUtils();
        viewUtils.doubleClickCheck(imageActivityIv, new ViewUtils.OnDoubleClickListener() {
            @Override
            public void onDoubleClick() {
                ToastKit.showShort("双重点击");
            }
        });
        imageActivityBtnLocalLoad.setOnClickListener(this);
        imageActivityBtnNetworkLoad.setOnClickListener(this);
    }

    /**
     * 初始数据
     */
    @Override
    protected void initData() {

    }

    /**
     * 开始逻辑
     */
    @Override
    protected void startLogic() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            // 本地加载
            case R.id.imageActivityBtnLocalLoad:
                imageActivityIv.setImageResource(DrawableUtils.getDrawableResIdByName("ic_airport_shuttle_font_input_24dp", R.mipmap.ic_launcher));
                break;
            // 网络加载
            case R.id.imageActivityBtnNetworkLoad:
                ToastKit.showShort("未实现");
                break;
            default:
                break;
        }
    }
}
