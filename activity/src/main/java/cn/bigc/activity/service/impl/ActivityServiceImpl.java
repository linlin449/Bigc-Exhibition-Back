package cn.bigc.activity.service.impl;

import cn.bigc.activity.mapper.ActivityMapper;
import cn.bigc.activity.service.ActivityService;
import cn.bigc.common.entity.Activity;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author th1nk
 * {@code @date} 2022/9/11 上午10:34
 */
@Service("activityServiceImpl")
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {
}
