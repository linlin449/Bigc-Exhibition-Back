package cn.bigc.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author th1nk
 * {@code @date} 2022/9/9 下午2:31
 */
@Data
public class AdminToken implements Serializable {
    private static final long serialVersionUID = 1L;
    private String token;
    private Admin admin;
    private Date expireTime;
}
