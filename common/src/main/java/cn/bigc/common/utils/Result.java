package cn.bigc.common.utils;

import cn.bigc.common.exception.ErrorCode;
import lombok.Data;

import java.io.Serializable;

/**
 * @author th1nk
 * {@code @date} 2022/9/10 上午11:43
 */
@Data
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 编码：0表示成功，其他值表示失败
     */
    private int code = 0;
    /**
     * 消息内容
     */
    private String msg = "success";
    /**
     * 响应数据
     */
    private Object data;

    public Result ok(Object data) {
        this.setData(data);
        return this;
    }

    public boolean success() {
        return code == 0;
    }

    public Result error() {
        this.code = ErrorCode.NORMAL_ERROR;
        this.msg = MessageUtil.getMessage(this.code);
        return this;

    }

    public Result error(int code) {
        this.code = code;
        this.msg = MessageUtil.getMessage(this.code);
        return this;
    }

    public Result error(int code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public Result error(String msg) {
        this.code = ErrorCode.INTERNAL_SERVER_ERROR;
        this.msg = msg;
        return this;
    }
}

