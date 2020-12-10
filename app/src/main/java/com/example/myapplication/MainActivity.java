package com.example.myapplication;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.MainActivityListViewAdapter;
import com.example.myapplication.adapter.MainActivityRecyclerViewAdapter;
import com.example.myapplication.module.MainActivityModule;

import java.util.ArrayList;
import java.util.List;

import base.BaseActivity;
import customview.CustomViewActivity;
import dialog.DialogActivity;
import grid.GridActivity;
import image.ImageActivity;
import property.PropertyActivity;
import value.Magic;
import widget.adapter.helper.AdapterHelper;
import widget.adapter.decoration.HorizontalDividerDecoration;
import widget.adapter.decoration.VerticalDividerDecoration;
import widget.adapter.listener.OnItemClickListener;
import widget.dialog.message.RoundCornerMessageDialog;
import widget.dialog.message.listener.OnRoundCornerMessageDialogButtonClickListener;
import mvp.MvpActivity;
import toast.ToastActivity;
import widget.listview.MeasuredListView;
import widget.toast.ToastKit;
import utils.intent.IntentUtils;
import utils.listener.AppListener;

/**
 * @desc: 主页
 * @author: zsp
 * @date: 2020-08-18 09:11
 */
public class MainActivity extends BaseActivity implements View.OnClickListener, ListView.OnItemClickListener, OnItemClickListener {
    private MeasuredListView mainActivityMlv;
    private RecyclerView mainActivityRv;
    private Button mainActivityBtn;
    private List<MainActivityModule> mainActivityModuleList;
    private MainActivityListViewAdapter mainActivityListViewAdapter;
    private MainActivityRecyclerViewAdapter mainActivityRecyclerViewAdapter;
    private int type;

    /**
     * 布局资源 ID
     *
     * @return 布局资源 ID
     */
    @Override
    protected int layoutResId() {
        return R.layout.activity_main;
    }

    /**
     * 初始控件
     */
    @Override
    protected void stepUi() {
        mainActivityMlv = findViewById(R.id.mainActivityMlv);
        mainActivityRv = findViewById(R.id.mainActivityRv);
        mainActivityBtn = findViewById(R.id.mainActivityBtn);
    }

    /**
     * 初始配置
     */
    @Override
    protected void initConfiguration() {
        // 控件
        mainActivityRv.addItemDecoration(new HorizontalDividerDecoration
                .Builder(this)
                .colorResId(R.color.colorPrimary)
                .size(getResources().getDimensionPixelSize(R.dimen.px_1))
                .margin(12)
                .margin(12, 12)
                .marginDimen(R.dimen.dp_12)
                .marginDimen(R.dimen.dp_12, R.dimen.dp_12)
                .marginProvider(new HorizontalDividerDecoration.MarginProvider() {
                    @Override
                    public int dividerLeftMargin(int position, RecyclerView parent) {
                        return 36;
                    }

                    @Override
                    public int dividerRightMargin(int position, RecyclerView parent) {
                        return 36;
                    }
                })
                .showLastDivider()
                .build());
        mainActivityRv.addItemDecoration(new VerticalDividerDecoration
                .Builder(this)
                .colorResId(R.color.colorPrimary)
                .size(getResources().getDimensionPixelSize(R.dimen.px_1))
                .margin(12)
                .margin(12, 12)
                .marginDimen(R.dimen.dp_12)
                .marginDimen(R.dimen.dp_12, R.dimen.dp_12)
                .marginProvider(new VerticalDividerDecoration.MarginProvider() {
                    @Override
                    public int dividerTopMargin(int position, RecyclerView parent) {
                        return 0;
                    }

                    @Override
                    public int dividerBottomMargin(int position, RecyclerView parent) {
                        return 0;
                    }
                })
                .showLastDivider()
                .build());
        mainActivityRv.setLayoutManager(new LinearLayoutManager(this));
        // 数据
        mainActivityModuleList = new ArrayList<>(6);
        // 适配器
        mainActivityListViewAdapter = new MainActivityListViewAdapter(this);
        mainActivityRecyclerViewAdapter = new MainActivityRecyclerViewAdapter(this);
    }

    /**
     * 设置监听
     */
    @Override
    protected void setListener() {
        // 控件
        mainActivityBtn.setOnClickListener(this);
        mainActivityMlv.setOnItemClickListener(this);
        // 适配器
        mainActivityListViewAdapter.setOnItemChildViewClickListener(new AdapterHelper.OnItemChildViewClickListener<MainActivityModule>() {
            @Override
            public void onItemChildViewClick(int position, MainActivityModule item, View childView) {
                ToastKit.showLong((mainActivityListViewAdapter.itemIsVisible(mainActivityMlv, position) ? "可见" : "不可见") + " || " + item.getCommentate());
            }
        });
        mainActivityRecyclerViewAdapter.setOnItemClickListener(this);
        mainActivityRecyclerViewAdapter.setOnItemChildViewClickListener(new AdapterHelper.OnItemChildViewClickListener<MainActivityModule>() {
            @Override
            public void onItemChildViewClick(int position, MainActivityModule item, View childView) {
                ToastKit.showLong((mainActivityListViewAdapter.itemIsVisible(mainActivityMlv, position) ? "可见" : "不可见") + " || " + item.getCommentate());
            }
        });
        // 注册回调
        AppListener.getInstance().registerCallback(new AppListener.Callback() {
            @Override
            public void onStateChange(boolean areForeground) {
                ToastKit.showShort(areForeground ? "来到前台" : "进入后台");
            }
        });
    }

    /**
     * 初始数据
     */
    @Override
    protected void initData() {
        // 是否前台
        if (AppListener.getInstance().areForeground()) {
            ToastKit.showShort("前台操作");
        }
        // 请求权限
        requestPermissions();
        // 数据
        mainActivityModuleList.add(new MainActivityModule("自定义VIEW", "自定义VIEW 注释"));
        mainActivityModuleList.add(new MainActivityModule("对话框", "对话框 注释"));
        mainActivityModuleList.add(new MainActivityModule("吐司", "吐司 注释"));
        mainActivityModuleList.add(new MainActivityModule("MVP", "MVP 注释"));
        mainActivityModuleList.add(new MainActivityModule("属性", "属性 注释"));
        mainActivityModuleList.add(new MainActivityModule("图像", "图像 注释"));
        mainActivityModuleList.add(new MainActivityModule("网格", "网格 注释"));
    }

    /**
     * 开始逻辑
     */
    @Override
    protected void startLogic() {
        mainActivityListViewAdapter.show(mainActivityMlv, mainActivityModuleList);
    }

    /**
     * 请求权限
     */
    private void requestPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0x01);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // 小米机型无论授予权限否，shouldShowRequestPermissionRationale 都为 false。故需另加判断 grantResults[0] == -1。
        if ((requestCode == Magic.INT_ZERO_X_ZERO_ONE) && (grantResults[0] == -1) && !shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)) {
            RoundCornerMessageDialog roundCornerMessageDialog = new RoundCornerMessageDialog.Builder(this, 0)
                    .setTitle("权限")
                    .setTitleColor(ContextCompat.getColor(this, R.color.fontInput))
                    .setContent("需授予读写权限")
                    .setContentColor(ContextCompat.getColor(this, R.color.fontHint))
                    .setContentHorizontalCenter()
                    .setLeftButtonText("cancel")
                    .setRightButtonText("ensure")
                    .setOnRoundCornerMessageDialogLeftButtonClickListener(new OnRoundCornerMessageDialogButtonClickListener() {
                        @Override
                        public void buttonClick(View view, RoundCornerMessageDialog roundCornerMessageDialog) {
                            roundCornerMessageDialog.handle(roundCornerMessageDialog.getClass());
                        }
                    })
                    .setOnRoundCornerMessageDialogRightButtonClickListener(new OnRoundCornerMessageDialogButtonClickListener() {
                        @Override
                        public void buttonClick(View view, RoundCornerMessageDialog roundCornerMessageDialog) {
                            roundCornerMessageDialog.handle(roundCornerMessageDialog.getClass());
                        }
                    }).build();
            roundCornerMessageDialog.setCancelable(false);
            roundCornerMessageDialog.show();
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.mainActivityBtn) {
            type = (type == 0) ? 1 : 0;
            switch (type) {
                case 0:
                    mainActivityRv.setVisibility(View.GONE);
                    mainActivityMlv.setVisibility(View.VISIBLE);
                    mainActivityListViewAdapter.show(mainActivityMlv, mainActivityModuleList);
                    mainActivityBtn.setText(R.string.useRecyclerView);
                    break;
                case 1:
                    mainActivityMlv.setVisibility(View.GONE);
                    mainActivityRv.setVisibility(View.VISIBLE);
                    mainActivityRecyclerViewAdapter.show(mainActivityRv, mainActivityModuleList);
                    mainActivityBtn.setText(R.string.useListView);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        execute(i);
    }

    /**
     * 条目点击
     *
     * @param view     条目视图
     * @param position 位置
     */
    @Override
    public void onItemClick(View view, int position) {
        execute(position);
    }

    /**
     * 执行
     *
     * @param position 位置
     */
    private void execute(int position) {
        String name = mainActivityModuleList.get(position).getName();
        switch (name) {
            case "自定义VIEW":
                IntentUtils.getInstance().jump(this, CustomViewActivity.class);
                break;
            case "对话框":
                IntentUtils.getInstance().jump(this, DialogActivity.class);
                break;
            case "吐司":
                IntentUtils.getInstance().jump(this, ToastActivity.class);
                break;
            case "MVP":
                IntentUtils.getInstance().jump(this, MvpActivity.class);
                break;
            case "属性":
                IntentUtils.getInstance().jump(this, PropertyActivity.class);
                break;
            case "图像":
                IntentUtils.getInstance().jump(this, ImageActivity.class);
                break;
            case "网格":
                IntentUtils.getInstance().jump(this, GridActivity.class);
                break;
            default:
                break;
        }
    }
}
