package com.example.gateway.controller;

import cn.bigc.common.service.CaptchaService;
import cn.bigc.common.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author th1nk
 * {@code @date} 2022/9/10 上午11:41
 */
@RestController
@RequestMapping("/captcha")
public class CaptchaController {
    @Resource(name = "captchaServiceImpl")
    private CaptchaService captchaService;

    @GetMapping("/get")
    public Result createCaptcha() {
        return new Result().ok(captchaService.generateCaptcha());
    }
}
