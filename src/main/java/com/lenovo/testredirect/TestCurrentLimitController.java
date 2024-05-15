package com.lenovo.testredirect;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @Author wenjun4
 * @Date 2023/11/2
 * @Description
 */
@RestController
@RequestMapping(value = "/limit")
public class TestCurrentLimitController {

    @GetMapping("/sleep")
    public String sleep(
            Integer num
    ) {
        Integer second = 1;
        if (Objects.nonNull(num)) {
            second = num;
        }
        try {
            System.out.println("Release after sleeping for " + second + " seconds");
            Thread.sleep(second * 1000); // sleep for num second
            System.out.println("end sleep");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "sleep " + second + " second";
    }

}
