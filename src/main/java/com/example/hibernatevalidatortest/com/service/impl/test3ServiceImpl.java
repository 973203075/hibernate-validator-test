package com.example.hibernatevalidatortest.com.service.impl;

import com.example.hibernatevalidatortest.com.entity.Car;
import com.example.hibernatevalidatortest.com.service.IService;
import org.springframework.stereotype.Service;

@Service
public class test3ServiceImpl implements IService {
    @Override
    public Object test3(Car car) {
        System.out.println(car);
        return car;
    }
}
