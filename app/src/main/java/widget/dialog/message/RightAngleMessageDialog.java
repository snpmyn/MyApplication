package widget.dialog.message;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.myapplication.R;

import widget.dialog.base.BaseInstanceDialog;
import widget.dialog.message.listener.OnRightAngleMessageDialogButtonClickListener;

/**
 * Created on 2020-08-19
 *
 * @author zsp
 * @desc 直角消息对话框
 */
public class RightAngleMessageDialog extends BaseInstanceDialog {
    private TextView rightAngleMessageDialogTvTitle;
    private TextView rightAngleMessageDialogTvContent;
    private Button rightAngleMessageDialogBtnLeft;
    private Button rightAngleMessageDialogBtnRight;
    private OnRightAngleMessageDialogButtonClickListener onRightAngleMessageDialogLeftButtonClickListener, onRightAngleMessageDialogRightButtonClickListener;

    /**
     * constructor
     *
     * @param context        上下文
     * @param selfThemeResId 自身主题资源 ID
     */
    private RightAngleMessageDialog(Context context, int selfThemeResId) {
        super(context, selfThemeResId);
    }

    /**
     * 布局资源 ID
     *
     * @return 布局资源 ID
     */
    @Override
    protected int layoutResID() {
        return R.layout.dialog_right_angle_message;
    }

    /**
     * 初始控件
     */
    @Override
    protected void stepUI() {
        rightAngleMessageDialogTvTitle = view.findViewById(R.id.rightAngleMessageDialogTvTitle);
        rightAngleMessageDialogTvContent = view.findViewById(R.id.rightAngleMessageDialogTvContent);
        rightAngleMessageDialogBtnLeft = view.findViewById(R.id.rightAngleMessageDialogBtnLeft);
        rightAngleMessageDialogBtnRight = view.findViewById(R.id.rightAngleMessageDialogBtnRight);
    }

    /**
     * 设置监听
     */
    @Override
    protected void setListener() {
        rightAngleMessageDialogBtnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null == onRightAngleMessageDialogLeftButtonClickListener) {
                    handle(RightAngleMessageDialog.class);
                } else {
                    onRightAngleMessageDialogLeftButtonClickListener.buttonClick(view, RightAngleMessageDialog.this);
                }
            }
        });
        rightAngleMessageDialogBtnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null == onRightAngleMessageDialogRightButtonClickListener) {
                    handle(RightAngleMessageDialog.class);
                } else {
                    onRightAngleMessageDialogRightButtonClickListener.buttonClick(view, RightAngleMessageDialog.this);
                }
            }
        });
    }

    /**
     * 初始数据
     */
    @Override
    protected void initData() {

    }

    /**
     * 设置标题
     * <p>
     * 默认隐藏，设置标题时显示。
     *
     * @param title 标题
     */
    private void setTitle(String title) {
        if (TextUtils.isEmpty(title)) {
            return;
        }
        rightAngleMessageDialogTvTitle.setText(title);
        rightAngleMessageDialogTvTitle.setVisibility(View.VISIBLE);
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        rightAngleMessageDialogTvContent.setText(content);
    }

    /**
     * 设置内容水平居中
     */
    private void setContentHorizontalCenter() {
        rightAngleMessageDialogTvContent.setGravity(Gravity.CENTER);
    }

    /**
     * 设置标题颜色
     * <p>
     * 默认 <color name="textInput">#333333</color>
     *
     * @param titleColor 标题颜色
     */
    private void setTitleColor(int titleColor) {
        rightAngleMessageDialogTvTitle.setTextColor(titleColor);
    }

    /**
     * 设置内容颜色
     * <p>
     * 默认 <color name="textHint">#666666</color>
     *
     * @param contentColor 内容颜色
     */
    private void setContentColor(int contentColor) {
        rightAngleMessageDialogTvContent.setTextColor(contentColor);
    }

    /**
     * 设置左按钮文本
     *
     * @param leftButtonText 左按钮文本
     */
    private void setLeftButtonText(String leftButtonText) {
        rightAngleMessageDialogBtnLeft.setText(leftButtonText);
    }

    /**
     * 设置右按钮文本
     *
     * @param rightButtonText 右按钮文本
     */
    private void setRightButtonText(String rightButtonText) {
        rightAngleMessageDialogBtnRight.setText(rightButtonText);
    }

    /**
     * 设置左按钮默认选中
     */
    private void setLeftButtonDefaultSelect() {
        setButtonDefaultSelect(rightAngleMessageDialogBtnLeft);
    }

    /**
     * 设置右按钮默认选中
     */
    private void setRightButtonDefaultSelect() {
        setButtonDefaultSelect(rightAngleMessageDialogBtnRight);
    }

    /**
     * 设置按钮默认选中
     *
     * @param button 按钮
     */
    @SuppressLint("ClickableViewAccessibility")
    private void setButtonDefaultSelect(final Button button) {
        button.setBackground(ContextCompat.getDrawable(context, R.drawable.color_primary_white_drawable_selector));
        button.setTextColor(ContextCompat.getColor(context, R.color.white));
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        button.setTextColor(ContextCompat.getColor(context, R.color.colorPrimary));
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int[] location = new int[2];
                        view.getLocationOnScreen(location);
                        int x = location[0];
                        int y = location[1];
                        float rawX = motionEvent.getRawX();
                        // TODO: 2020-09-25 motionEvent.getRawY() - 20 滑至按钮边缘优化
                        float rawY = motionEvent.getRawY() - 20;
                        if (rawX < x || rawX > (x + view.getWidth()) || rawY < y || rawY > (y + view.getHeight())) {
                            button.setTextColor(ContextCompat.getColor(context, R.color.white));
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        button.setTextColor(ContextCompat.getColor(context, R.color.white));
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }

    /**
     * 设置直角消息对话框左按钮点击监听
     *
     * @param onRightAngleMessageDialogLeftButtonClickListener 直角消息对话框左按钮点击监听
     */
    private void setOnRightAngleMessageDialogLeftButtonClickListener(OnRightAngleMessageDialogButtonClickListener onRightAngleMessageDialogLeftButtonClickListener) {
        this.onRightAngleMessageDialogLeftButtonClickListener = onRightAngleMessageDialogLeftButtonClickListener;
    }

    /**
     * 设置直角消息对话框右按钮点击监听
     *
     * @param onRightAngleMessageDialogRightButtonClickListener 直角消息对话框右按钮点击监听
     */
    private void setOnRightAngleMessageDialogRightButtonClickListener(OnRightAngleMessageDialogButtonClickListener onRightAngleMessageDialogRightButtonClickListener) {
        this.onRightAngleMessageDialogRightButtonClickListener = onRightAngleMessageDialogRightButtonClickListener;
    }

    public static class Builder {
        private RightAngleMessageDialog rightAngleMessageDialog;

        public Builder(Context context, int selfThemeResId) {
            this.rightAngleMessageDialog = new RightAngleMessageDialog(context, selfThemeResId);
        }

        public Builder setTitle(String title) {
            rightAngleMessageDialog.setTitle(title);
            return this;
        }

        public Builder setContent(String content) {
            rightAngleMessageDialog.setContent(content);
            return this;
        }

        public Builder setContentHorizontalCenter() {
            rightAngleMessageDialog.setContentHorizontalCenter();
            return this;
        }

        public Builder setTitleColor(int titleColor) {
            rightAngleMessageDialog.setTitleColor(titleColor);
            return this;
        }

        public Builder setContentColor(int contentColor) {
            rightAngleMessageDialog.setContentColor(contentColor);
            return this;
        }

        public Builder setLeftButtonText(String leftButtonText) {
            rightAngleMessageDialog.setLeftButtonText(leftButtonText);
            return this;
        }

        public Builder setRightButtonText(String rightButtonText) {
            rightAngleMessageDialog.setRightButtonText(rightButtonText);
            return this;
        }

        public Builder setLeftButtonDefaultSelect() {
            rightAngleMessageDialog.setLeftButtonDefaultSelect();
            return this;
        }

        public Builder setRightButtonDefaultSelect() {
            rightAngleMessageDialog.setRightButtonDefaultSelect();
            return this;
        }

        public Builder setOnRightAngleMessageDialogLeftButtonClickListener(OnRightAngleMessageDialogButtonClickListener onLeftButtonClickListener) {
            rightAngleMessageDialog.setOnRightAngleMessageDialogLeftButtonClickListener(onLeftButtonClickListener);
            return this;
        }

        public Builder setOnRightAngleMessageDialogRightButtonClickListener(OnRightAngleMessageDialogButtonClickListener onRightButtonClickListener) {
            rightAngleMessageDialog.setOnRightAngleMessageDialogRightButtonClickListener(onRightButtonClickListener);
            return this;
        }

        public RightAngleMessageDialog build() {
            return rightAngleMessageDialog;
        }
    }
}
