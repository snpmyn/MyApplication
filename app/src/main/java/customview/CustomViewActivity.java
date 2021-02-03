package customview;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;

import com.example.fairy.utils.intent.IntentJump;
import com.example.myapplication.R;

import base.BaseActivity;
import customview.arc.ArcActivity;
import customview.circle.CircleActivity;
import customview.line.LineActivity;
import customview.oval.OvalActivity;
import customview.path.PathActivity;
import customview.point.PointActivity;
import customview.rect.RectActivity;
import customview.text.TextActivity;

/**
 * @desc: 自定义 VIEW 页
 * @author: zsp
 * @date: 2020-08-19 10:53
 */
public class CustomViewActivity extends BaseActivity implements View.OnClickListener {
    private Button mainActivityBtnCircle;
    private Button mainActivityBtnLine;
    private Button mainActivityBtnRect;
    private Button mainActivityBtnPoint;
    private Button mainActivityBtnOval;
    private Button mainActivityBtnText;
    private Button mainActivityBtnArc;
    private Button mainActivityBtnPath;

    /**
     * 布局资源 ID
     *
     * @return 布局资源 ID
     */
    @Override
    protected int layoutResId() {
        return R.layout.activity_custom_view;
    }

    /**
     * 初始控件
     */
    @Override
    protected void stepUi() {
        mainActivityBtnCircle = findViewById(R.id.mainActivityBtnCircle);
        mainActivityBtnLine = findViewById(R.id.mainActivityBtnLine);
        mainActivityBtnRect = findViewById(R.id.mainActivityBtnRect);
        mainActivityBtnPoint = findViewById(R.id.mainActivityBtnPoint);
        mainActivityBtnOval = findViewById(R.id.mainActivityBtnOval);
        mainActivityBtnText = findViewById(R.id.mainActivityBtnText);
        mainActivityBtnArc = findViewById(R.id.mainActivityBtnArc);
        mainActivityBtnPath = findViewById(R.id.mainActivityBtnPath);
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
        mainActivityBtnCircle.setOnClickListener(this);
        mainActivityBtnLine.setOnClickListener(this);
        mainActivityBtnRect.setOnClickListener(this);
        mainActivityBtnPoint.setOnClickListener(this);
        mainActivityBtnOval.setOnClickListener(this);
        mainActivityBtnText.setOnClickListener(this);
        mainActivityBtnArc.setOnClickListener(this);
        mainActivityBtnPath.setOnClickListener(this);
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

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            // 圆
            case R.id.mainActivityBtnCircle:
                IntentJump.getInstance().jump(null, this, false, CircleActivity.class);
                break;
            // 线
            case R.id.mainActivityBtnLine:
                IntentJump.getInstance().jump(null, this, false, LineActivity.class);
                break;
            // 矩形
            case R.id.mainActivityBtnRect:
                IntentJump.getInstance().jump(null, this, false, RectActivity.class);
                break;
            // 点
            case R.id.mainActivityBtnPoint:
                IntentJump.getInstance().jump(null, this, false, PointActivity.class);
                break;
            // 椭圆
            case R.id.mainActivityBtnOval:
                IntentJump.getInstance().jump(null, this, false, OvalActivity.class);
                break;
            // 文本
            case R.id.mainActivityBtnText:
                IntentJump.getInstance().jump(null, this, false, TextActivity.class);
                break;
            // 弧
            case R.id.mainActivityBtnArc:
                IntentJump.getInstance().jump(null, this, false, ArcActivity.class);
                break;
            // 路径
            case R.id.mainActivityBtnPath:
                IntentJump.getInstance().jump(null, this, false, PathActivity.class);
                break;
            default:
                break;
        }
    }
}
