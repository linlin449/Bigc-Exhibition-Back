package cn.bigc.common.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 */
@Component
public class RedisUtils {
    @Resource(name = "redisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    /**  默认过期时长为24小时 */
    public final static long DEFAULT_TIMEOUT = 1L;
    public final static TimeUnit DEFAULT_TIMEUNIT = TimeUnit.DAYS;

    public void set(String key, Object value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    public void set(String key, Object value) {
        set(key, value, DEFAULT_TIMEOUT, DEFAULT_TIMEUNIT);
    }

    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public boolean hasKey(String key) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    public void expire(String key, long timeout, TimeUnit unit) {
        redisTemplate.expire(key, timeout, unit);
    }

    public void expire(String key) {
        expire(key, DEFAULT_TIMEOUT, DEFAULT_TIMEUNIT);
    }

    public long getExpire(String key) {
        Long expire = redisTemplate.getExpire(key);
        return expire == null ? 0 : expire;
    }

    public boolean delete(String key) {
        return Boolean.TRUE.equals(redisTemplate.delete(key));
    }

    public Object getAndExpire(String key, long timeout, TimeUnit unit) {
        return redisTemplate.opsForValue().getAndExpire(key, timeout, unit);
    }
}