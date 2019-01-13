package com.vincent.security.example.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author: vincent
 * Date: 2019-01-13 20:50:00
 * Comment:
 */

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class SecuritySmsLoginApplicationTests {

    @Test
    public void contextLoads() {
        log.info("content load success");
    }

}
