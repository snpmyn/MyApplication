package widget.dialog.base;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2020-08-21
 *
 * @author zsp
 * @desc 单例对话框基类
 * <p>
 * 继承{@link BaseDialog}实现对话框，关闭时调{{@link #dismiss()}}。
 * 继承{@link BaseInstanceDialog}实现对话框，关闭时调{{@link #handle(Class)}}。
 */
public abstract class BaseInstanceDialog extends BaseDialog {
    private static List<BaseInstanceDialog> currentBaseInstanceDialogs = new ArrayList<>();

    /**
     * constructor
     *
     * @param context        上下文
     * @param selfThemeResId 自身主题资源 ID
     */
    protected BaseInstanceDialog(Context context, int selfThemeResId) {
        super(context, selfThemeResId);
        handle(this.getClass());
        setCurrentDialog();
    }

    /**
     * 获取当前对话框
     *
     * @param c 类
     * @return 当前对话框
     */
    private static BaseInstanceDialog getCurrentDialog(Class<?> c) {
        for (BaseInstanceDialog baseInstanceDialog : currentBaseInstanceDialogs) {
            if (baseInstanceDialog.getClass() == c) {
                return baseInstanceDialog;
            }
        }
        return null;
    }

    /**
     * 设置当前对话框
     */
    private void setCurrentDialog() {
        BaseInstanceDialog baseInstanceDialog;
        for (int i = 0; i < currentBaseInstanceDialogs.size(); i++) {
            baseInstanceDialog = currentBaseInstanceDialogs.get(i);
            if (baseInstanceDialog.getClass() == this.getClass()) {
                currentBaseInstanceDialogs.remove(baseInstanceDialog);
                i--;
            }
        }
        currentBaseInstanceDialogs.add(this);
    }

    /**
     * 处理
     *
     * @param c 类
     */
    public void handle(Class<?> c) {
        try {
            BaseInstanceDialog baseInstanceDialog = getCurrentDialog(c);
            if (null != baseInstanceDialog) {
                if (baseInstanceDialog.isShowing()) {
                    baseInstanceDialog.dismiss();
                }
                currentBaseInstanceDialogs.remove(baseInstanceDialog);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
