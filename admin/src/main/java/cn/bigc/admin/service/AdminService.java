package cn.bigc.admin.service;

import cn.bigc.common.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author th1nk
 * {@code @date} 2022/9/9 上午11:20
 */
public interface AdminService extends IService<Admin> {
    /**
     * 通过用户名获取管理员实体类
     * @param username 用户名
     * @return Admin 实体类,若不存在返回null
     */
    Admin queryByUsername(String username);
}
