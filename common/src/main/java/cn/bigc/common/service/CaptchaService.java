package cn.bigc.common.service;


import cn.bigc.common.dto.CaptchaDto;

/**
 * @author th1nk
 * {@code @date} 2022/9/10 下午12:43
 */
public interface CaptchaService {
    /**
     * 生成验证码
     * @return 返回验证码数据
     */
    CaptchaDto generateCaptcha();

    /**
     * 验证
     * @param key 验证码key
     * @param code 验证码值
     * @return 正确返回真, 错误返回假, 数据不存在返回null
     */
    Boolean verify(String key, String code);
}
