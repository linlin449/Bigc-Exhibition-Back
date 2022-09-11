package cn.bigc.admin;

import cn.bigc.admin.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdminApplicationTests {


    @Test
    void contextLoads() {

    }

    @Autowired
    AdminService adminService;

    @Test
    void queryByUsernameTest() {
        System.out.println(adminService.queryByUsername("laoda"));
    }
}
