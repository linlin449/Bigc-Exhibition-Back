package cn.bigc.admin.config;

import cn.bigc.common.redis.RedisUtils;
import cn.bigc.common.service.AdminTokenService;
import cn.bigc.common.service.CaptchaService;
import cn.bigc.common.service.impl.AdminTokenServiceImpl;
import cn.bigc.common.service.impl.CaptchaServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author th1nk
 * {@code @date} 2022/9/10 下午1:00
 */
@Component
public class BeanRegister {
    @Bean(name = "redisUtils")
    public RedisUtils redisUtils() {
        return new RedisUtils();
    }

    @Bean(name = "adminTokenServiceImpl")
    public AdminTokenService adminTokenService() {
        return new AdminTokenServiceImpl();
    }

    @Bean(name = "captchaServiceImpl")
    public CaptchaService captchaService() {
        return new CaptchaServiceImpl();
    }
}
