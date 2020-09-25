package utils.window;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.view.View;

import widget.dialog.message.RoundCornerMessageDialog;
import widget.dialog.message.listener.OnRoundCornerMessageDialogButtonClickListener;
import utils.system.HuaWeiUtils;
import utils.system.MeiZuUtils;
import utils.system.QiHoo360Utils;
import utils.system.RomUtils;
import utils.system.XiaoMiUtils;

/**
 * Created on 2020-09-10
 *
 * @author zsp
 * @desc 系统悬浮窗工具类
 */
public class SystemAlertWindowUtils {
    private static volatile SystemAlertWindowUtils instance;

    public static SystemAlertWindowUtils getInstance() {
        if (null == instance) {
            synchronized (SystemAlertWindowUtils.class) {
                if (null == instance) {
                    instance = new SystemAlertWindowUtils();
                }
            }
        }
        return instance;
    }

    public boolean execute(Context context) {
        if (checkSystemAlertWindowPermission(context)) {
            return true;
        }
        dialogHint(context);
        return false;
    }

    private boolean checkSystemAlertWindowPermission(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // 6.0+ 谷歌增加管理悬浮窗权限，方式统一。
            return Settings.canDrawOverlays(context);
        } else if (RomUtils.xiaoMiRom()) {
            return XiaoMiUtils.checkSystemAlertWindowPermission(context);
        } else if (RomUtils.meiZuRom()) {
            return MeiZuUtils.checkSystemAlertWindowPermission(context);
        } else if (RomUtils.huaWeiRom()) {
            return HuaWeiUtils.checkSystemAlertWindowPermission(context);
        } else if (RomUtils.qiHoo360Rom()) {
            return QiHoo360Utils.checkSystemAlertWindowPermission(context);
        } else {
            return true;
        }
    }

    private void dialogHint(final Context context) {
        RoundCornerMessageDialog roundCornerMessageDialog = new RoundCornerMessageDialog.Builder(context, 0)
                .setContent("您的手机没有授予悬浮窗权限，请开启后再试")
                .setContentHorizontalCenter()
                .setLeftButtonText("暂不开启")
                .setRightButtonText("现在去开启")
                .setOnRoundCornerMessageDialogLeftButtonClickListener(new OnRoundCornerMessageDialogButtonClickListener() {
                    @Override
                    public void buttonClick(View view, RoundCornerMessageDialog roundCornerMessageDialog) {
                        roundCornerMessageDialog.handle(roundCornerMessageDialog.getClass());
                        handle(context, false);
                    }
                })
                .setOnRoundCornerMessageDialogRightButtonClickListener(new OnRoundCornerMessageDialogButtonClickListener() {
                    @Override
                    public void buttonClick(View view, RoundCornerMessageDialog roundCornerMessageDialog) {
                        roundCornerMessageDialog.handle(roundCornerMessageDialog.getClass());
                        handle(context, true);
                    }
                }).build();
        roundCornerMessageDialog.setCancelable(false);
        roundCornerMessageDialog.show();
    }

    private void handle(Context context, boolean bool) {
        if (!bool) {
            // do something
            return;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + context.getPackageName()));
            context.startActivity(intent);
        } else if (RomUtils.xiaoMiRom()) {
            XiaoMiUtils.requestPermission(context);
        } else if (RomUtils.meiZuRom()) {
            MeiZuUtils.requestPermission(context);
        } else if (RomUtils.huaWeiRom()) {
            HuaWeiUtils.requestPermission(context);
        } else if (RomUtils.qiHoo360Rom()) {
            QiHoo360Utils.requestPermission(context);
        }
    }
}
