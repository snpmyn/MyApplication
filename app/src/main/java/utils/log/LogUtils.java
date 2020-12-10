package utils.log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.UnknownHostException;

/**
 * Created on 2020-09-10
 *
 * @author zsp
 * @desc 日志工具类
 */
public class LogUtils {
    private static final int VERBOSE = 2;
    private static final int DEBUG = 3;
    private static final int INFO = 4;
    private static final int WARN = 5;
    private static final int ERROR = 6;
    private static Method methodDebug;
    private static Method methodError;
    private static Method methodInfo;
    private static Method methodVerbose;
    private static Method methodWarn;
    private static Method methodDebugWithThrowable;
    private static Method methodErrorWithThrowable;
    private static Method methodInfoWithThrowable;
    private static Method methodVerboseWithThrowable;
    private static Method methodWarnWithThrowable;
    private static Class<?> c;

    static {
        try {
            c = Class.forName("android.util.Log");
            methodDebug = c.getDeclaredMethod("d", String.class, String.class);
            methodError = c.getDeclaredMethod("e", String.class, String.class);
            methodInfo = c.getDeclaredMethod("i", String.class, String.class);
            methodVerbose = c.getDeclaredMethod("v", String.class, String.class);
            methodWarn = c.getDeclaredMethod("w", String.class, String.class);
            methodDebugWithThrowable = c.getDeclaredMethod("d", String.class, String.class, Throwable.class);
            methodErrorWithThrowable = c.getDeclaredMethod("e", String.class, String.class, Throwable.class);
            methodInfoWithThrowable = c.getDeclaredMethod("i", String.class, String.class, Throwable.class);
            methodVerboseWithThrowable = c.getDeclaredMethod("v", String.class, String.class, Throwable.class);
            methodWarnWithThrowable = c.getDeclaredMethod("w", String.class, String.class, Throwable.class);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            exception(e);
        }
        if (c == null) {
            try {
                c = LogUtils.class;
                methodDebug = methodError = methodInfo = methodVerbose = methodWarn = methodDebugWithThrowable = methodErrorWithThrowable
                        = methodInfoWithThrowable = methodVerboseWithThrowable = methodWarnWithThrowable =
                        c.getDeclaredMethod("systemLog", int.class, String.class, String.class);
            } catch (NoSuchMethodException e) {
                systemLog(INFO, "e", e.getMessage());
            }
        }
    }

    public static void d(String tag, String info) {
        logInvoke(DEBUG, methodDebug, tag, info, null);
    }

    public static void e(String tag, String info) {
        logInvoke(ERROR, methodError, tag, info, null);
    }

    public static void i(String tag, String info) {
        logInvoke(INFO, methodInfo, tag, info, null);
    }

    public static void v(String tag, String info) {
        logInvoke(VERBOSE, methodVerbose, tag, info, null);
    }

    public static void w(String tag, String info) {
        logInvoke(WARN, methodWarn, tag, info, null);
    }

    public static void d(String tag, String info, Throwable e) {
        logInvoke(DEBUG, methodDebugWithThrowable, tag, info, e);
    }

    public static void e(String tag, String info, Throwable e) {
        logInvoke(ERROR, methodErrorWithThrowable, tag, info, e);
    }

    public static void i(String tag, String info, Throwable e) {
        logInvoke(INFO, methodInfoWithThrowable, tag, info, e);
    }

    public static void v(String tag, String info, Throwable e) {
        logInvoke(VERBOSE, methodVerboseWithThrowable, tag, info, e);
    }

    public static void w(String tag, String info, Throwable e) {
        logInvoke(WARN, methodWarnWithThrowable, tag, info, e);
    }

    public static void thread() {
        d("[Thread]: ", Thread.currentThread() + "");
    }

    public static void exception(Exception e) {
        if (Builder.logException) {
            e.printStackTrace();
        }
    }

    private static boolean canLog() {
        return Builder.logEnable;
    }

    private static void logInvoke(int level, Method method, String tag, String info, Throwable throwable) {
        if (!canLog()) {
            return;
        }
        printInvokeStack();
        log(level, method, tag, info, throwable);
    }

    private static void systemLog(int level, String tag, String info) {
        String levelTag;
        switch (level) {
            case DEBUG:
                levelTag = "[DEBUG]: ";
                break;
            case INFO:
                levelTag = "[INFO]: ";
                break;
            case VERBOSE:
                levelTag = "[VERBOSE]: ";
                break;
            case ERROR:
                levelTag = "[ERROR]: ";
                break;
            case WARN:
                levelTag = "[WARN]: ";
                break;
            default:
                levelTag = "  ";
                break;
        }
        System.out.println(levelTag + "  [" + tag + "]  " + info);
    }

    private static void log(int level, Method method, String tag, String info, Throwable throwable) {
        if (info == null) {
            return;
        }
        if (!Builder.logSystem) {
            try {
                if (method == methodDebugWithThrowable || method == methodInfoWithThrowable || method == methodErrorWithThrowable || method == methodWarnWithThrowable || method == methodVerboseWithThrowable) {
                    method.invoke(c, tag, info, throwable);
                } else {
                    method.invoke(c, tag, info + (throwable == null ? "" : "\n" + getStackTraceString(throwable)));
                }
            } catch (Exception e) {
                exception(e);
            }
            return;
        }
        systemLog(level, tag, info + (throwable == null ? "" : "\n" + getStackTraceString(throwable)));
    }

    private static void printInvokeStack() {
        if (!Builder.logInvokeStack) {
            return;
        }
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        StringBuilder stringBuilder = new StringBuilder();
        StackTraceElement stackTraceElement;
        boolean start = false;
        for (int index = 0; index < stackTraceElements.length; index++) {
            if (!start && index < stackTraceElements.length - 1) {
                if (stackTraceElements[index].getClassName().equals(LogUtils.class.getName()) &&
                        !stackTraceElements[index + 1].getClassName().equals(LogUtils.class.getName())) {
                    start = true;
                }
            }
            if (start) {
                stackTraceElement = stackTraceElements[index];
                stringBuilder.append("   ")
                        .append(stackTraceElement.getClassName())
                        .append(".")
                        .append(stackTraceElement.getMethodName())
                        .append("(")
                        .append(stackTraceElement.getFileName())
                        .append(":")
                        .append(stackTraceElement.getLineNumber())
                        .append(")")
                        .append("\n");
            }
        }
        log(INFO, methodInfo, "stack", stringBuilder.toString(), null);
    }

    private static String getStackTraceString(Throwable e) {
        if (e == null) {
            return "";
        }
        // This is to reduce the amount of log spew that apps do in the non-error condition of the network being unavailable.
        Throwable throwable = e;
        while (throwable != null) {
            if (throwable instanceof UnknownHostException) {
                return "";
            }
            throwable = throwable.getCause();
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static class Builder {
        private static boolean logEnable = false;
        private static boolean logInvokeStack = false;
        private static boolean logException = false;
        private static boolean logSystem = false;

        public static void initConfiguration(boolean logEnable, boolean logInvokeStack, boolean logException, boolean logSystem) {
            Builder.logEnable = logEnable;
            Builder.logInvokeStack = logInvokeStack;
            Builder.logException = logException;
            Builder.logSystem = logSystem;
        }
    }
}
