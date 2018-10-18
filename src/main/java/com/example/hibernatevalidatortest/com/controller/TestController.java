package com.example.hibernatevalidatortest.com.controller;

import com.example.hibernatevalidatortest.com.entity.Car;
import com.example.hibernatevalidatortest.com.service.IService;
import com.example.hibernatevalidatortest.com.validation.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author: tiankuokuo
 * @description: hibernate validator 校验测试类
 * @date: 2018/10/18 13:48
 * @version: V1.0
 */
@RestController
public class TestController {

    @Autowired
    private IService IService;

    /**
     * @author: tiankuokuo
     * @description: controller 上的校验
     * @date: 2018/10/18 13:49
     * @return:
     * @throws:
     */
    @GetMapping("test1")
    public Object test(@Valid Car car, BindingResult bindingResult){
        ValidateUtil.ErrorsResolve(bindingResult);
        return car;
    }

    /**
     * @author: tiankuokuo
     * @description: 任何上的校验
     * @date: 2018/10/18 13:49
     * @return:
     * @throws:
     */
    @GetMapping("test2")
    public Object test2(Car car){
        ValidateUtil.validate(car);
        return car;
    }

    /**
     * @author: tiankuokuo
     * @description: 服务实现类上的校验
     * @date: 2018/10/18 13:51
     * @return:
     * @throws:
     */
    @GetMapping("test3")
    public Object test3(Car car){
        return IService.test3(car);
    }
}
