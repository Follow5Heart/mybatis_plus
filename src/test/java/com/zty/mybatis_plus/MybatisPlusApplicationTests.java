package com.zty.mybatis_plus;

import com.zty.mybatis_plus.entity.User;
import com.zty.mybatis_plus.mapper.UserMapper;
import com.zty.mybatis_plus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisPlusApplicationTests {



    @Autowired
    private UserMapper usermapper;

    @Test
    void contextLoads() {

        User user = usermapper.selectById("1");
        System.out.println(user);
    }

}
