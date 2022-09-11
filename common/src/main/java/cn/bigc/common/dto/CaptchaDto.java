package cn.bigc.common.dto;

import lombok.Data;

/**
 * @author th1nk
 * {@code @date} 2022/9/10 下午12:43
 */
@Data
public class CaptchaDto {
    private String image;
    private String verkey;
}
