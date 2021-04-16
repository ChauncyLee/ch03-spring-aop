package com.hz.spring.aop.service;

/**
 * @author Chuncy
 * @version V1.0
 * @Date: 2021/4/16 14:21
 **/
public interface SomeService {
    void doSome(String name,int age);

    String doOther(String name,int age);

    String doFirst(String name,int age);

    void doSecond();

    void doThird();
}
