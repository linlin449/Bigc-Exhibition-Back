package cn.bigc.admin.mapper;

import cn.bigc.common.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author th1nk
 * {@code @date} 2022/9/9 上午11:21
 */
public interface AdminMapper extends BaseMapper<Admin> {
    /**
     * 通过用户名获取管理员实体类
     * @param username 用户名
     * @return Admin 实体类
     */
    Admin queryByUsername(String username);
}
