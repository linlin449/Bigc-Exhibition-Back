package cn.bigc.auth;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthApplicationTests {
    @Value("${test.user.name}")
    String username;
    @Value("${test.user.age}")
    String age;

    @Test
    void contextLoads() {
        System.out.println(username + age);
    }
}
