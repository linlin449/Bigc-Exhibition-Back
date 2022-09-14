package cn.bigc.activity.controller;

import cn.bigc.activity.service.ActivityService;
import cn.bigc.common.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author th1nk
 * {@code @date} 2022/9/11 下午1:45
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Resource(name = "activityServiceImpl")
    private ActivityService activityService;

    @GetMapping("/{id}")
    public Result getActivity(@PathVariable Integer id) {
        return new Result().ok(activityService.getById(id));
    }
}
