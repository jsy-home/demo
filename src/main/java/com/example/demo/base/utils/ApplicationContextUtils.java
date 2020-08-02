package com.example.demo.base.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//ApplicationContextAware
@Component
public class ApplicationContextUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextUtils.applicationContext=applicationContext;
    }

    /**
     * @Description 获取spring容器中的bean，通过bean名称获取
     * @param beanName bean的名称
     * @return Object 返回Object,需要做强类型转换
     */
    public static Object getBean(String beanName){
        return applicationContext.getBean(beanName);
    }
    /**
     * @Description 获取spring容器中的bean，通过bean类型获取
     * @param beanClass bean的类型
     * @return T 返回指定类型的实例
     */
    public static <T> T getBean(Class<T> beanClass ){
        return applicationContext.getBean(beanClass);
    }

    /**
     * @Description 获取spring容器中的bean，通过bean类型和名字精确获取
     * @param beanClass bean的类型
     * @param beanName bean的名称
     * @return T 返回指定类型的实例
     */
    public static <T> T getBean(Class<T> beanClass,String beanName){
        return applicationContext.getBean(beanName,beanClass);
    }
}
