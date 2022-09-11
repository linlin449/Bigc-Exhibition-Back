package cn.bigc.common.service;

import cn.bigc.common.entity.Admin;
import cn.bigc.common.entity.AdminToken;

import java.util.concurrent.TimeUnit;

/**
 * @author th1nk
 * {@code @date} 2022/9/9 下午2:37
 */
public interface AdminTokenService {
    /**
     * 通过Admin实体类生成token
     * @param admin Admin实体类
     * @return AdminToken, 拥有默认过期时间
     */
    AdminToken generate(Admin admin);

    /**
     * 通过Admin实体类生成token
     * @param admin Admin实体类
     * @param timeout 过期时间
     * @param unit 时间单位
     * @return AdminToken
     */
    AdminToken generate(Admin admin, long timeout, TimeUnit unit);

    /**
     * 通过token字符串获取AdminToken
     * @param token token字符串
     * @return AdminToken实体类  获取失败返回null
     */
    AdminToken getByToken(String token);

    /**
     * 更新token过期时间
     * @param token token字符串
     * @param timeout 时间
     * @param unit 时间单位
     * @return 更新成功返回真, 失败返回假
     */
    boolean updateExpireTime(String token, long timeout, TimeUnit unit);
}
