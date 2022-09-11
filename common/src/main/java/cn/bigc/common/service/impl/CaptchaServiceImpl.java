package cn.bigc.common.service.impl;

import cn.bigc.common.dto.CaptchaDto;
import cn.bigc.common.service.CaptchaService;
import com.wf.captcha.SpecCaptcha;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author th1nk
 * {@code @date} 2022/9/10 下午12:45
 */
@Service("captchaServiceImpl")
public class CaptchaServiceImpl implements CaptchaService {
    @Resource(name = "stringRedisTemplate")
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public CaptchaDto generateCaptcha() {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        String verCode = specCaptcha.text().toLowerCase();
        String key = UUID.randomUUID().toString();
        CaptchaDto captchaDto = new CaptchaDto();
        captchaDto.setImage(specCaptcha.toBase64());
        captchaDto.setVerkey(key);
        stringRedisTemplate.opsForValue().set("captcha::" + key, verCode, 5, TimeUnit.MINUTES);

        return captchaDto;
    }

    @Override
    public Boolean verify(String key, String code) {
        if (key == null || key.equals("") || code == null || code.equals("")) return null;
        Boolean res = null;
        if (Boolean.TRUE.equals(stringRedisTemplate.hasKey("captcha::" + key))) {
            stringRedisTemplate.delete("captcha::" + key);
            res = code.equals(stringRedisTemplate.opsForValue().get("captcha::" + key));
        }
        return res;
    }
}
