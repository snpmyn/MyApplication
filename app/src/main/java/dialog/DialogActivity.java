package dialog;

import android.annotation.SuppressLint;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import androidx.core.content.ContextCompat;

import com.example.myapplication.R;

import base.BaseActivity;
import widget.dialog.loading.CanCancelLoadingDialog;
import widget.dialog.loading.CommonLoadingDialog;
import widget.dialog.loading.listener.OnBackPressedListener;
import widget.dialog.loading.listener.OnClickToCloseListener;
import widget.dialog.loading.listener.OnDialogCloseListener;
import widget.dialog.message.RightAngleMessageDialog;
import widget.dialog.message.RoundCornerMessageDialog;
import widget.dialog.message.listener.OnRightAngleMessageDialogButtonClickListener;
import widget.dialog.message.listener.OnRoundCornerMessageDialogButtonClickListener;
import widget.toast.ToastKit;
import utils.data.CaesarCipherUtils;
import utils.sign.SignUtils;

/**
 * @desc: 对话框页
 * @author: zsp
 * @date: 2020-08-19 13:36
 */
public class DialogActivity extends BaseActivity implements View.OnClickListener {
    private Button dialogActivityBtnRightAngleMessageDialogWithNoTitle;
    private Button dialogActivityBtnRightAngleMessageDialogWithTitle;
    private Button dialogActivityBtnRoundCornerMessageDialogWithNoTitle;
    private Button dialogActivityBtnRoundCornerMessageDialogWithTitle;
    private Button dialogActivityBtnLoadingDialog;
    private Button dialogActivityBtnCanCancelLoadingDialog;

    /**
     * 布局资源 ID
     *
     * @return 布局资源 ID
     */
    @Override
    protected int layoutResId() {
        return R.layout.activity_dialog;
    }

    /**
     * 初始控件
     */
    @Override
    protected void stepUi() {
        dialogActivityBtnRightAngleMessageDialogWithNoTitle = findViewById(R.id.dialogActivityBtnRightAngleMessageDialogWithNoTitle);
        dialogActivityBtnRightAngleMessageDialogWithTitle = findViewById(R.id.dialogActivityBtnRightAngleMessageDialogWithTitle);
        dialogActivityBtnRoundCornerMessageDialogWithNoTitle = findViewById(R.id.dialogActivityBtnRoundCornerMessageDialogWithNoTitle);
        dialogActivityBtnRoundCornerMessageDialogWithTitle = findViewById(R.id.dialogActivityBtnRoundCornerMessageDialogWithTitle);
        dialogActivityBtnLoadingDialog = findViewById(R.id.dialogActivityBtnCommonLoadingDialog);
        dialogActivityBtnCanCancelLoadingDialog = findViewById(R.id.dialogActivityBtnCanCancelLoadingDialog);
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
        dialogActivityBtnRightAngleMessageDialogWithNoTitle.setOnClickListener(this);
        dialogActivityBtnRightAngleMessageDialogWithTitle.setOnClickListener(this);
        dialogActivityBtnRoundCornerMessageDialogWithNoTitle.setOnClickListener(this);
        dialogActivityBtnRoundCornerMessageDialogWithTitle.setOnClickListener(this);
        dialogActivityBtnLoadingDialog.setOnClickListener(this);
        dialogActivityBtnCanCancelLoadingDialog.setOnClickListener(this);
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
            // 直角消息对话框（无标题）
            case R.id.dialogActivityBtnRightAngleMessageDialogWithNoTitle:
                rightAngleMessageDialogWithNoTitle();
                break;
            // 直角消息对话框（有标题）
            case R.id.dialogActivityBtnRightAngleMessageDialogWithTitle:
                rightAngleMessageDialogWithTitle();
                break;
            // 圆角消息对话框（无标题）
            case R.id.dialogActivityBtnRoundCornerMessageDialogWithNoTitle:
                roundCornerMessageDialogWithNoTitle();
                break;
            // 圆角消息对话框（有标题）
            case R.id.dialogActivityBtnRoundCornerMessageDialogWithTitle:
                roundCornerMessageDialogWithTitle();
                break;
            // 普通加载对话框
            case R.id.dialogActivityBtnCommonLoadingDialog:
                commonLoadingDialog();
                break;
            // 可取消加载对话框
            case R.id.dialogActivityBtnCanCancelLoadingDialog:
                canCancelLoadingDialog();
                break;
            default:
                break;
        }
    }

    /**
     * 直角消息对话框（无标题）
     */
    private void rightAngleMessageDialogWithNoTitle() {
        RightAngleMessageDialog rightAngleMessageDialog = new RightAngleMessageDialog.Builder(this, 0)
                .setTitle(null)
                .setTitleColor(ContextCompat.getColor(this, R.color.fontInput))
                .setContent("示例")
                .setContentColor(ContextCompat.getColor(this, R.color.fontHint))
                .setContentHorizontalCenter()
                .setLeftButtonText("取消")
                .setRightButtonText("确定")
                .setLeftButtonDefaultSelect()
                .setOnRightAngleMessageDialogLeftButtonClickListener(new OnRightAngleMessageDialogButtonClickListener() {
                    @Override
                    public void buttonClick(View view, RightAngleMessageDialog rightAngleMessageDialog) {
                        rightAngleMessageDialog.handle(rightAngleMessageDialog.getClass());
                        ToastKit.showShort("取消");
                    }
                })
                .setOnRightAngleMessageDialogRightButtonClickListener(new OnRightAngleMessageDialogButtonClickListener() {
                    @Override
                    public void buttonClick(View view, RightAngleMessageDialog rightAngleMessageDialog) {
                        rightAngleMessageDialog.handle(rightAngleMessageDialog.getClass());
                        ToastKit.showShortWithGravity(CaesarCipherUtils.encrypt("确定", 10) + "||"
                                + CaesarCipherUtils.decrypt(CaesarCipherUtils.encrypt("确定", 10), 10), Gravity.CENTER_VERTICAL);
                    }
                }).build();
        rightAngleMessageDialog.show();
    }

    /**
     * 直角消息对话框（有标题）
     */
    private void rightAngleMessageDialogWithTitle() {
        RightAngleMessageDialog rightAngleMessageDialog = new RightAngleMessageDialog.Builder(this, 0)
                .setTitle("消息对话框")
                .setTitleColor(ContextCompat.getColor(this, R.color.fontInput))
                .setContent("示例")
                .setContentColor(ContextCompat.getColor(this, R.color.fontHint))
                .setContentHorizontalCenter()
                .setLeftButtonText("cancel")
                .setRightButtonText("ensure")
                .setRightButtonDefaultSelect()
                .setOnRightAngleMessageDialogLeftButtonClickListener(new OnRightAngleMessageDialogButtonClickListener() {
                    @Override
                    public void buttonClick(View view, RightAngleMessageDialog rightAngleMessageDialog) {
                        rightAngleMessageDialog.handle(rightAngleMessageDialog.getClass());
                        ToastKit.showLong("cancel");
                    }
                })
                .setOnRightAngleMessageDialogRightButtonClickListener(new OnRightAngleMessageDialogButtonClickListener() {
                    @Override
                    public void buttonClick(View view, RightAngleMessageDialog rightAngleMessageDialog) {
                        rightAngleMessageDialog.handle(rightAngleMessageDialog.getClass());
                        ToastKit.showLongWithGravity(CaesarCipherUtils.encrypt("ensure", 10) + "||"
                                + CaesarCipherUtils.decrypt(CaesarCipherUtils.encrypt("ensure", 10), 10), Gravity.CENTER_VERTICAL);
                    }
                }).build();
        rightAngleMessageDialog.show();
    }

    /**
     * 圆角消息对话框（无标题）
     */
    private void roundCornerMessageDialogWithNoTitle() {
        RoundCornerMessageDialog roundCornerMessageDialog = new RoundCornerMessageDialog.Builder(this, 0)
                .setTitle(null)
                .setTitleColor(ContextCompat.getColor(this, R.color.fontInput))
                .setContent("示例")
                .setContentColor(ContextCompat.getColor(this, R.color.fontHint))
                .setContentHorizontalCenter()
                .setLeftButtonText("取消")
                .setRightButtonText("确定")
                .setLeftButtonDefaultSelect()
                .setOnRoundCornerMessageDialogLeftButtonClickListener(new OnRoundCornerMessageDialogButtonClickListener() {
                    @Override
                    public void buttonClick(View view, RoundCornerMessageDialog roundCornerMessageDialog) {
                        roundCornerMessageDialog.handle(roundCornerMessageDialog.getClass());
                        ToastKit.showShort("取消");
                    }
                })
                .setOnRoundCornerMessageDialogRightButtonClickListener(new OnRoundCornerMessageDialogButtonClickListener() {
                    @Override
                    public void buttonClick(View view, RoundCornerMessageDialog roundCornerMessageDialog) {
                        roundCornerMessageDialog.handle(roundCornerMessageDialog.getClass());
                        ToastKit.showShort(CaesarCipherUtils.encrypt("确定", 10) + "||"
                                + CaesarCipherUtils.decrypt(CaesarCipherUtils.encrypt("确定", 10), 10));
                    }
                }).build();
        roundCornerMessageDialog.show();
    }

    /**
     * 圆角消息对话框（有标题）
     */
    private void roundCornerMessageDialogWithTitle() {
        RoundCornerMessageDialog roundCornerMessageDialog = new RoundCornerMessageDialog.Builder(this, 0)
                .setTitle("消息对话框")
                .setTitleColor(ContextCompat.getColor(this, R.color.fontInput))
                .setContent("示例")
                .setContentColor(ContextCompat.getColor(this, R.color.fontHint))
                .setContentHorizontalCenter()
                .setLeftButtonText("cancel")
                .setRightButtonText("ensure")
                .setRightButtonDefaultSelect()
                .setOnRoundCornerMessageDialogLeftButtonClickListener(new OnRoundCornerMessageDialogButtonClickListener() {
                    @Override
                    public void buttonClick(View view, RoundCornerMessageDialog roundCornerMessageDialog) {
                        roundCornerMessageDialog.handle(roundCornerMessageDialog.getClass());
                        ToastKit.showShort("cancel");
                    }
                })
                .setOnRoundCornerMessageDialogRightButtonClickListener(new OnRoundCornerMessageDialogButtonClickListener() {
                    @Override
                    public void buttonClick(View view, RoundCornerMessageDialog roundCornerMessageDialog) {
                        roundCornerMessageDialog.handle(roundCornerMessageDialog.getClass());
                        ToastKit.showShort(CaesarCipherUtils.encrypt("ensure", 10) + "||"
                                + CaesarCipherUtils.decrypt(CaesarCipherUtils.encrypt("ensure", 10), 10));
                    }
                }).build();
        roundCornerMessageDialog.setCancelable(false);
        roundCornerMessageDialog.show();
    }

    /**
     * 普通加载对话框
     */
    private void commonLoadingDialog() {
        CommonLoadingDialog commonLoadingDialog = new CommonLoadingDialog.Builder(this, 0)
                .setHint("加载中")
                .setOnBackPressedListener(new OnBackPressedListener() {
                    @Override
                    public void backPressed() {
                        ToastKit.showShort(SignUtils.getSignMd5Hex(DialogActivity.this, "com.example.myapplication") + "||" +
                                SignUtils.getSignSha256Hex(DialogActivity.this, "com.example.myapplication"));
                    }
                }).build();
        commonLoadingDialog.show();
    }

    /**
     * 可取消加载对话框
     */
    private void canCancelLoadingDialog() {
        CanCancelLoadingDialog canCancelLoadingDialog = new CanCancelLoadingDialog.Builder(this, 0)
                .setHint("加载中")
                .setOnClickToCloseListener(new OnClickToCloseListener() {
                    @Override
                    public void clickToClose() {
                        ToastKit.showShort("clickToClose");
                    }
                })
                .setOnDialogCloseListener(new OnDialogCloseListener() {
                    @Override
                    public void dialogClose() {
                        ToastKit.showShort("dialogClose");
                    }
                })
                .setOnBackPressedListener(new OnBackPressedListener() {
                    @Override
                    public void backPressed() {
                        ToastKit.showShort("backPressed");
                    }
                }).build();
        canCancelLoadingDialog.setCancelable(false);
        canCancelLoadingDialog.show();
    }
}
