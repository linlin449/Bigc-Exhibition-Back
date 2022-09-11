package cn.bigc.common.utils;

import java.util.ResourceBundle;

/**
 * @author th1nk
 * {@code @date} 2022/8/26 下午1:49
 */
public class MessageUtil {
    private static final ResourceBundle resource;

    static {
        resource = ResourceBundle.getBundle("message");
    }


    public static String getMessage(int code) {
        String msg;
        try {
            msg = resource.getString(code + "");
            return msg;
        } catch (Exception e) {
            return "Error";
        }
    }

}
