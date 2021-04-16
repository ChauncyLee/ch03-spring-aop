package com.hz.spring.aop.service.serviceimpl;

import com.hz.spring.aop.service.SomeService;
import org.springframework.stereotype.Component;

/**
 * @author Chuncy
 * @version V1.0
 * @Date: 2021/4/16 14:22
 **/
@Component(value = "someServiceTarget")
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, int age) {
        System.out.println("执行了业务方法doSome()");
    }

    @Override
    public String doOther(String name, int age) {
        System.out.println("执行了业务方法doOther()");
        return "abcd";
    }

    @Override
    public String doFirst(String name, int age) {
        System.out.println("执行了业务方法doFirst()");
        return "doFirst";
    }

    @Override
    public void doSecond() {
        System.out.println("执行了业务方法doSecond()"+(10/0));
    }

    @Override
    public void doThird() {
        System.out.println("执行了业务方法doThird()"+(10/0));
    }
}
