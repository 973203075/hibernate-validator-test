package com.example.hibernatevalidatortest.com.test;

import com.example.hibernatevalidatortest.com.entity.Car;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        System.out.println("================================================");
        Car car = new Car();
        car.addPart( "Wheel" );
        car.addPart( null );
        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
        System.out.println("size: ===" + constraintViolations.size());
        constraintViolations.forEach(carConstraintViolation -> {
            System.out.println("getConstraintDescriptor" + carConstraintViolation.getConstraintDescriptor());
            System.out.println("getExecutableParameters" + carConstraintViolation.getExecutableParameters());
            System.out.println("getInvalidValue" + carConstraintViolation.getInvalidValue());
            System.out.println("getLeafBean" + carConstraintViolation.getLeafBean());
            System.out.println("getMessage" + carConstraintViolation.getMessage());
            System.out.println("getMessageTemplate" + carConstraintViolation.getMessageTemplate());
            System.out.println("getRootBean" + carConstraintViolation.getRootBean());
            System.out.println("getRootBeanClass" + carConstraintViolation.getRootBeanClass());
        });
    }
}
