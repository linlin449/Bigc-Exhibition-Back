package cn.bigc.common.exception;

/**
 * @author th1nk
 * {@code @date} 2022/9/10 上午11:45
 */
public interface ErrorCode {
    //  一般错误
    int NORMAL_ERROR = 100;
    //    服务器内部错误
    int INTERNAL_SERVER_ERROR = 500;
    //  未授权错误
    int UNAUTHORIZED = 401;

    int NOT_NULL = 10001;

    //  未输入验证码
    int CAPTCHA_NEED = 10001;

    int DB_RECORD_EXISTS = 10002;
    int PARAMS_GET_ERROR = 10003;
    int ACCOUNT_PASSWORD_ERROR = 10004;
    int ACCOUNT_LOCKED = 10005;

    //  验证码错误
    int CAPTCHA_ERROR = 10006;
}
