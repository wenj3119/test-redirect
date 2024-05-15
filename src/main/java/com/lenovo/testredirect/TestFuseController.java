package com.lenovo.testredirect;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Random;

/**
 * @Author wenjun4
 * @Date 2023/10/19
 * @Description
 */
@RestController
@RequestMapping(value = "/fuse")
public class TestFuseController {

    @GetMapping("/test")
    public Integer test(
            Integer num
    ) {
        Random random = new Random();
        int randomNumber = random.nextInt(3); // 生成0到3之间的随机数
        System.out.println(randomNumber);
        int denominator = randomNumber;
        if(Objects.nonNull(num)){
            denominator = num;
        }
        return 1/denominator;
    }


}
