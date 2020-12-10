package property;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;
import java.util.Properties;

import base.BaseActivity;
import utils.property.PropertyUtils;

/**
 * @desc: 属性页
 * @author: zsp
 * @date: 2020-09-11 15:47
 */
public class PropertyActivity extends BaseActivity implements View.OnClickListener {
    private TextView propertyActivityTv;
    private Button propertyActivityBtnGetProperty;

    /**
     * 布局资源 ID
     *
     * @return 布局资源 ID
     */
    @Override
    protected int layoutResId() {
        return R.layout.activity_property;
    }

    /**
     * 初始控件
     */
    @Override
    protected void stepUi() {
        propertyActivityTv = findViewById(R.id.propertyActivityTv);
        propertyActivityBtnGetProperty = findViewById(R.id.propertyActivityBtnGetProperty);
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
        propertyActivityBtnGetProperty.setOnClickListener(this);
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
        if (view.getId() == R.id.propertyActivityBtnGetProperty) {
            PropertyUtils propertyUtils = new PropertyUtils();
            Properties properties = propertyUtils.getProperties(this, "currency_code");
            StringBuilder stringBuilder = new StringBuilder(properties.getProperty("0000", "default value" + "\n\n"));
            List<String> list = propertyUtils.getPropertyKeyOrValueList(this, "currency_code", 0);
            for (String s : list) {
                stringBuilder.append(s).append((list.indexOf(s) == (list.size() - 1)) ? "" : " || ");
            }
            propertyActivityTv.setText(stringBuilder.toString());
        }
    }
}
