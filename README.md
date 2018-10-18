# hibernate-validator-test
三种方式校验：controller中校验，service中校验，任意类校验

本项目基于springboot
项目结构：
controller包 用于测试 里面三个例子。
 @GetMapping("test1")
    public Object test(@Valid Car car, BindingResult bindingResult){
        ValidateUtil.ErrorsResolve(bindingResult);
        return car;
    }
@GetMapping("test2")
    public Object test2(Car car){
        ValidateUtil.validate(car);
        return car;
    }
@GetMapping("test3")
    public Object test3(Car car){
        return IService.test3(car);
    }    
config包校验器配置和切面配置：
ValidatorAspect切面（@Pointcut("execution(* com..service..*(..))")）用于校验service实现类的参数。
ValidatorConfiguration 配置validator。
exception包非法参数异常处理类，处理hibernate-validtor抛出的异常，返回json异常信息。
IllegalArgumentExceptionHandler：封装异常信息；
util包：从容器获取bean工具类和执行校验工具类
SpringContextHolder：从容器获取检验器对象。
ValidateUtil：执行家宴工具类。

resources包下：自定义参数提示信息，覆盖默认异常信息。
ValidationMessages_zh_CN.properties
javax.validation.constraints.Digits.message          = 数字的值超出了允许范围(只允许在{integer}位整数和{fraction}位小数范围内)
javax.validation.constraints.Email.message           = 不合法的电子邮件地址 
参考hibernate-validator-6.0.13.Final.jar!/org/hibernate/validator/ValidationMessages_zh_CN.properties文件。

下个版本增加：spring-boot启动器。
