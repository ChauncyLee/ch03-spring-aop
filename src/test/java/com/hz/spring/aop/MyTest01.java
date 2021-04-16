package com.hz.spring.aop;

import com.hz.spring.aop.service.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Chuncy
 * @version V1.0
 * @Date: 2021/4/16 14:37
 **/
public class MyTest01 {

    @Test
    public void test01(){
        String config="applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);

        //从spring容器中获取目标对象，目标就是经过aspectj修改后的代理对象
        SomeService proxy=(SomeService) ac.getBean("someServiceTarget");
        //com.sun.proxy.$Proxy14:目标对象有接口使用jdk动态代理
        System.out.println("proxy:"+proxy.getClass().getName());
        //通过代理方法，实现功能增强
        proxy.doSome("前置",20);
    }
    @Test
    public void test02(){
        String config="applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);

        //从spring容器中获取目标对象，目标就是经过aspectj修改后的代理对象
        SomeService proxy=(SomeService) ac.getBean("someServiceTarget");
        //com.sun.proxy.$Proxy14:目标对象有接口使用jdk动态代理
        System.out.println("proxy:"+proxy.getClass().getName());
        //通过代理方法，实现功能增强
        proxy.doOther("后置",21);
    }
    @Test
    public void test03(){
        String config="applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);

        //从spring容器中获取目标对象，目标就是经过aspectj修改后的代理对象
        SomeService proxy=(SomeService) ac.getBean("someServiceTarget");
        //com.sun.proxy.$Proxy14:目标对象有接口使用jdk动态代理
        System.out.println("proxy:"+proxy.getClass().getName());
        //通过代理方法，实现功能增强
        proxy.doFirst("环绕",22);
    }
    @Test
    public void test04(){
        String config="applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);

        //从spring容器中获取目标对象，目标就是经过aspectj修改后的代理对象
        SomeService proxy=(SomeService) ac.getBean("someServiceTarget");
        //com.sun.proxy.$Proxy14:目标对象有接口使用jdk动态代理
        System.out.println("proxy:"+proxy.getClass().getName());
        //通过代理方法，实现功能增强
        proxy.doSecond();
    }
    @Test
    public void test05(){
        String config="applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);

        //从spring容器中获取目标对象，目标就是经过aspectj修改后的代理对象
        SomeService proxy=(SomeService) ac.getBean("someServiceTarget");
        //com.sun.proxy.$Proxy14:目标对象有接口使用jdk动态代理
        System.out.println("proxy:"+proxy.getClass().getName());
        //通过代理方法，实现功能增强
        proxy.doThird();
    }
}
