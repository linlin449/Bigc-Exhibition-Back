package cn.bigc.admin.service.impl;

import cn.bigc.admin.mapper.AdminMapper;
import cn.bigc.admin.service.AdminService;
import cn.bigc.common.entity.Admin;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author th1nk
 * {@code @date} 2022/9/9 上午11:20
 */
@Service("adminServiceImpl")
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Cacheable(value = "adminInfoCache",key = "#username")
    @Override
    public Admin queryByUsername(String username) {
        if (username == null || username.equals("")) return null;
        return baseMapper.queryByUsername(username);
    }

}
