package dialog;

import android.annotation.SuppressLint;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import androidx.core.content.ContextCompat;

import com.example.fairy.utils.data.CaesarCipherUtils;
import com.example.fairy.utils.sign.SignUtils;
import com.example.fairy.widget.dialog.loading.CanCancelLoadingDialog;
import com.example.fairy.widget.dialog.loading.CommonLoadingDialog;
import com.example.fairy.widget.dialog.message.RightAngleMessageDialog;
import com.example.fairy.widget.dialog.message.RoundCornerMessageDialog;
import com.example.fairy.widget.toast.ToastKit;
import com.example.myapplication.R;

import base.BaseActivity;

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
                .setOnRightAngleMessageDialogLeftButtonClickListener((view, rightAngleMessageDialog1) -> {
                    rightAngleMessageDialog1.handle(rightAngleMessageDialog1.getClass());
                    ToastKit.showShort("取消");
                })
                .setOnRightAngleMessageDialogRightButtonClickListener((view, rightAngleMessageDialog12) -> {
                    rightAngleMessageDialog12.handle(rightAngleMessageDialog12.getClass());
                    ToastKit.showShortWithGravity(CaesarCipherUtils.encrypt("确定", 10) + "||"
                            + CaesarCipherUtils.decrypt(CaesarCipherUtils.encrypt("确定", 10), 10), Gravity.CENTER_VERTICAL);
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
                .setOnRightAngleMessageDialogLeftButtonClickListener((view, rightAngleMessageDialog1) -> {
                    rightAngleMessageDialog1.handle(rightAngleMessageDialog1.getClass());
                    ToastKit.showLong("cancel");
                })
                .setOnRightAngleMessageDialogRightButtonClickListener((view, rightAngleMessageDialog12) -> {
                    rightAngleMessageDialog12.handle(rightAngleMessageDialog12.getClass());
                    ToastKit.showLongWithGravity(CaesarCipherUtils.encrypt("ensure", 10) + "||"
                            + CaesarCipherUtils.decrypt(CaesarCipherUtils.encrypt("ensure", 10), 10), Gravity.CENTER_VERTICAL);
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
                .setOnRoundCornerMessageDialogLeftButtonClickListener((view, roundCornerMessageDialog1) -> {
                    roundCornerMessageDialog1.handle(roundCornerMessageDialog1.getClass());
                    ToastKit.showShort("取消");
                })
                .setOnRoundCornerMessageDialogRightButtonClickListener((view, roundCornerMessageDialog12) -> {
                    roundCornerMessageDialog12.handle(roundCornerMessageDialog12.getClass());
                    ToastKit.showShort(CaesarCipherUtils.encrypt("确定", 10) + "||"
                            + CaesarCipherUtils.decrypt(CaesarCipherUtils.encrypt("确定", 10), 10));
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
                .setOnRoundCornerMessageDialogLeftButtonClickListener((view, roundCornerMessageDialog1) -> {
                    roundCornerMessageDialog1.handle(roundCornerMessageDialog1.getClass());
                    ToastKit.showShort("cancel");
                })
                .setOnRoundCornerMessageDialogRightButtonClickListener((view, roundCornerMessageDialog12) -> {
                    roundCornerMessageDialog12.handle(roundCornerMessageDialog12.getClass());
                    ToastKit.showShort(CaesarCipherUtils.encrypt("ensure", 10) + "||"
                            + CaesarCipherUtils.decrypt(CaesarCipherUtils.encrypt("ensure", 10), 10));
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
                .setOnBackPressedListener(() -> ToastKit.showShort(SignUtils.getSignMd5Hex(DialogActivity.this, "com.example.myapplication") + "||" +
                        SignUtils.getSignSha256Hex(DialogActivity.this, "com.example.myapplication"))).build();
        commonLoadingDialog.setCancelable(false);
        commonLoadingDialog.show();
    }

    /**
     * 可取消加载对话框
     */
    private void canCancelLoadingDialog() {
        CanCancelLoadingDialog canCancelLoadingDialog = new CanCancelLoadingDialog.Builder(this, 0)
                .setHint("加载中")
                .setOnClickToCloseListener(() -> ToastKit.showShort("clickToClose"))
                .setOnDialogCloseListener(() -> ToastKit.showShort("dialogClose"))
                .setOnBackPressedListener(() -> ToastKit.showShort("backPressed")).build();
        canCancelLoadingDialog.show();
    }
}
