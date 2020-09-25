package toast;

import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

import java.util.Map;

import base.BaseActivity;
import widget.toast.ToastKit;
import widget.toast.WindowHeadToast;
import widget.toast.listener.OnViewClickListener;
import utils.window.SystemAlertWindowUtils;

/**
 * @desc: 吐司页
 * @author: zsp
 * @date: 2020-09-03 09:04
 */
public class ToastActivity extends BaseActivity implements View.OnClickListener {
    private Button toastActivityBtnPop;

    /**
     * 布局资源 ID
     *
     * @return 布局资源 ID
     */
    @Override
    protected int layoutResID() {
        return R.layout.activity_toast;
    }

    /**
     * 初始控件
     */
    @Override
    protected void stepUI() {
        toastActivityBtnPop = findViewById(R.id.toastActivityBtnPop);
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
        toastActivityBtnPop.setOnClickListener(this);
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
        if (view.getId() == R.id.toastActivityBtnPop) {
            pop();
        }
    }

    /**
     * 弹出
     */
    private void pop() {
        if (SystemAlertWindowUtils.getInstance().execute(this)) {
            final WindowHeadToast windowHeadToast = new WindowHeadToast(this, "我的客服", "您收到一条新消息", null);
            windowHeadToast.setOnViewClickListener(new OnViewClickListener() {
                @Override
                public void onViewClick(Map<String, String> extraMap) {
                    ToastKit.showShort("点击");
                    windowHeadToast.dismiss();
                }
            });
            windowHeadToast.show();
        }
    }
}
