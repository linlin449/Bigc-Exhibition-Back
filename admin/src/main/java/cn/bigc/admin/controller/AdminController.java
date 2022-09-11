package cn.bigc.admin.controller;

import cn.bigc.admin.dto.LoginDto;
import cn.bigc.admin.service.AdminService;
import cn.bigc.common.entity.Admin;
import cn.bigc.common.exception.ErrorCode;
import cn.bigc.common.service.AdminTokenService;
import cn.bigc.common.service.CaptchaService;
import cn.bigc.common.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author th1nk
 * {@code @date} 2022/9/9 下午12:25
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource(name = "captchaServiceImpl")
    private CaptchaService captchaService;

    @Resource(name = "adminServiceImpl")
    private AdminService adminService;

    @Resource(name = "adminTokenServiceImpl")
    private AdminTokenService adminTokenService;

    @PostMapping("/login")
    public Result userLogin(@RequestBody LoginDto loginDto) {
        if (!loginDto.isNotNull()) return new Result().error(ErrorCode.PARAMS_GET_ERROR);
        if (!Boolean.TRUE.equals(captchaService.verify(loginDto.getVerkey(), loginDto.getVercode())))
            return new Result().error(ErrorCode.CAPTCHA_ERROR);
        Admin admin = adminService.queryByUsername(loginDto.getUsername());
        if (admin == null || admin.getPassword().equals(loginDto.getPassword()))
            return new Result().error(ErrorCode.ACCOUNT_PASSWORD_ERROR);
        return new Result().ok(adminTokenService.generate(admin).getToken());
    }
}
