package utils.system;

import android.os.Build;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import utils.log.LogUtils;

/**
 * Created on 2020-09-09
 *
 * @author zsp
 * @desc ROM 工具类
 */
public class RomUtils {
    /**
     * 获取 EMUI 版本号
     *
     * @return EMUI 版本号
     */
    static double getEmuiVersionCode() {
        try {
            String systemProperty = getSystemProperty("ro.build.version.emui");
            String versionCode = null;
            if (systemProperty != null) {
                versionCode = systemProperty.substring(systemProperty.indexOf("_") + 1);
            }
            return Double.parseDouble(versionCode);
        } catch (Exception e) {
            LogUtils.exception(e);
        }
        return 4.0;
    }

    /**
     * 获取 MIUI 版本号
     * <p>
     * 失败返 -1
     *
     * @return MIUI 版本号
     */
    static int getMiuiVersion() {
        String systemProperty = getSystemProperty("ro.miui.ui.version.name");
        if (systemProperty != null) {
            try {
                return Integer.parseInt(systemProperty.substring(1));
            } catch (Exception e) {
                LogUtils.exception(e);
            }
        }
        return -1;
    }

    private static String getSystemProperty(String propertyName) {
        String line;
        BufferedReader bufferedReader = null;
        try {
            Process process = Runtime.getRuntime().exec("getprop " + propertyName);
            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()), 1024);
            line = bufferedReader.readLine();
            bufferedReader.close();
        } catch (IOException ex) {
            return null;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    LogUtils.exception(e);
                }
            }
        }
        return line;
    }

    public static boolean huaWeiRom() {
        return Build.MANUFACTURER.contains("HUAWEI");
    }

    public static boolean xiaoMiRom() {
        return !TextUtils.isEmpty(getSystemProperty("ro.miui.ui.version.name"));
    }

    public static boolean meiZuRom() {
        String systemProperty = getSystemProperty("ro.build.display.id");
        if (TextUtils.isEmpty(systemProperty)) {
            return false;
        } else
            return systemProperty.contains("flyme") || systemProperty.toLowerCase().contains("flyme");
    }

    public static boolean qiHoo360Rom() {
        return Build.MANUFACTURER.contains("QiKU") || Build.MANUFACTURER.contains("360");
    }
}
