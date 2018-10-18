package com.example.hibernatevalidatortest.com.validation.config;

import com.example.hibernatevalidatortest.com.validation.util.ValidateUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.validation.Validator;
import java.util.Arrays;

/**
 * @author: tiankuokuo
 * @description: 参数校验切面
 * @date: 2018/10/18 15:17
 * @version: V1.0
 */
@Aspect
@Component
public class ValidatorAspect {

    @Qualifier("getValidatorFactory")
    @Autowired
    private Validator validator;

    /**
     * @author: tiankuokuo
     * @description: 校验service方法
     * @date: 2018/10/18 15:29
     * @return:
     * @throws:
     */
    @Pointcut("execution(* com..service..*(..))")
      public void pointcut() {
      }

    @Around("pointcut()")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        Arrays.stream(joinPoint.getArgs()).forEach(obj-> {ValidateUtil
                .constraintViolationsResolve(validator.validate(obj)); });
        return joinPoint.proceed();
    }
}