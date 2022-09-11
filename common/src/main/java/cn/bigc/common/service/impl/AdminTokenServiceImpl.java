package cn.bigc.common.service.impl;

import cn.bigc.common.entity.Admin;
import cn.bigc.common.entity.AdminToken;
import cn.bigc.common.redis.RedisUtils;
import cn.bigc.common.service.AdminTokenService;
import org.springframework.data.redis.core.TimeoutUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author th1nk
 * {@code @date} 2022/9/9 下午2:37
 */
@Service("adminTokenServiceImpl")
public class AdminTokenServiceImpl implements AdminTokenService {
    @Resource(name = "redisUtils")
    private RedisUtils redisUtils;
    private final String PREFIX = "adminToken::";

    public final static long DEFAULT_TIMEOUT = 3L;
    public final static TimeUnit DEFAULT_TIMEUNIT = TimeUnit.DAYS;

    @Override
    public AdminToken generate(Admin admin) {
        return generate(admin, DEFAULT_TIMEOUT, DEFAULT_TIMEUNIT);
    }

    @Override
    public AdminToken generate(Admin admin, long timeout, TimeUnit unit) {
        AdminToken adminToken = new AdminToken();
        String token = PREFIX + UUID.randomUUID();
        adminToken.setAdmin(admin);
        adminToken.setToken(token);
        Date expireTime = new Date();
        expireTime.setTime(new Date().getTime() + TimeoutUtils.toMillis(timeout, unit));
        redisUtils.set(token, admin, timeout, unit);
        adminToken.setExpireTime(expireTime);
        return adminToken;
    }

    @Override
    public AdminToken getByToken(String token) {
        AdminToken adminToken = new AdminToken();
        Admin admin = (Admin) redisUtils.get(PREFIX + token);
        if (admin == null) return null;
        adminToken.setAdmin(admin);
        adminToken.setToken(token);
        Date expireTime = new Date();
        expireTime.setTime(new Date().getTime() + redisUtils.getExpire(PREFIX + token));
        adminToken.setExpireTime(expireTime);
        return adminToken;
    }

    @Override
    public boolean updateExpireTime(String token, long timeout, TimeUnit unit) {
        return redisUtils.getAndExpire(PREFIX + token, timeout, unit) != null;
    }
}
