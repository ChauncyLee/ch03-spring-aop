package com.hz.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author Chuncy
 * @version V1.0
 * @Aspect: 是aspectj框架的注解，表示当前类是切面类
 * @Date: 2021/4/16 14:23
 **/
@Component(value = "myAspect")
@Aspect
public class MyAspect {

    /**
     * @Before: 前置通知
     *      属性：value 切入点表达式，表示切面执行的位置
     *      位置：方法的定义上面
     */
    @Before(value="execution(* com.hz.spring.aop.service.serviceimpl.SomeServiceImpl.doSome(..))")
    public void myBefore(){
        //就是切面代码的功能，例如日志的输出，事务的处理
        System.out.println("前置通知：在目标方法之前执行，例如输出日志");
    }

    /**
     * 通知方法：使用了通知注解修饰的方法
     * 通知方法可以有参数，但参数不能是任意
     * 1.JoinPoint：表示连接点方法
     *
     * @param jp
     */
    @Before(value = "execution(* *..SomeServiceImpl.do*(..))")
    public void myBefore2(JoinPoint jp){
        //JoinPoint能够获取到方法的定义，方法的参数等信息
        System.out.println("连接点的方法定义："+jp.getSignature());
        System.out.println("连接点方法的参数个数："+jp.getArgs().length);
        //方法参数的信息
        Object args[]=jp.getArgs();
        for(Object arg: args){
            System.out.println(arg);
        }
//        就是切面代码的功能，例如日志的输出，事务的处理
        System.out.println("前置通知：在目标方法之前执行，例如输出日志");
    }


    /**
     * @AfterReturning: 后置通知
     * @param result
     */
    @AfterReturning(value = "execution(* *..SomeServiceImpl.doOther(..))", returning = "result")
    public void myAfterReturning(Object result){
        //修改目标方法的执行结果
        if(result!=null){
            String s=(String)result;
            result=s.toUpperCase();
        }
        System.out.println("后置通知：在目标方法之后执行的功能增强，例如执行事务处理（切面）"+result);
    }


    /**
     * 环绕通知
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around(value = "execution(* *..SomeServiceImpl.doFirst(..))")
    public Object myAround(ProceedingJoinPoint pjp)throws Throwable{
        Object obj=null;
        //功能增强
        System.out.println("环绕通知：在目标方法之前执行的，例如输出日志");
        //执行目标方法的调用，等同于method.invoke(target,args)
        obj=pjp.proceed();
        System.out.println(obj.toString());
        //功能增强
        System.out.println("环绕通知：在目标方法之后执行的，例如处理事务");
        return obj;
    }

    /**
     * @AfterThrowing: 异常通知
     * @param ex
     */
    @AfterThrowing(value = "execution(* *..SomeServiceImpl.doSecond(..))",throwing = "ex")
    public void myAfterThrowing(Throwable ex){
        //把异常发生的时间，位置，原因记录到数据库，日志文件等
        //可以再发生异常时，把异常信息通过短信，邮件发送给开发人员
        System.out.println("异常通知：在目标方法抛出异常时执行的，异常原因："+ex.getMessage());
    }

    /**
     * @Afte: 最终通知
     */
//    @After(value = "execution(* *..SomeServiceImpl.doThird(..))")
    @After(value = "mypt()")
    public void myAfter(){
        System.out.println("最终通知：总是会被执行的方法");
    }

    /**
     * @Pointcut: 用来定义和管理切面点。简化切入点的定义。
     */
    @Pointcut(value = "execution(* *..SomeServiceImpl.doThird(..))")
    public void mypt(){
        //无需代码
    }
}
