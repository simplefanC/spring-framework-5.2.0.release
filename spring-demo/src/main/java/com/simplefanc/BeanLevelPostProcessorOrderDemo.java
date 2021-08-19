package com.simplefanc;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.lang.Nullable;

import java.lang.reflect.Constructor;

@Configuration
public class BeanLevelPostProcessorOrderDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanLevelPostProcessorOrderDemo.class);
		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(DemoBean.class);
		rootBeanDefinition.setLazyInit(true);
		context.registerBeanDefinition("demoBean", rootBeanDefinition);
		context.getBean("demoBean");
		context.start();
		context.close();
	}

	public static class DemoBean {

	}

//	@Bean
//	public BeanPostProcessor fullBeanPostProcessor(){
//		return new FullBeanPostProcessor();
//	}
//
//	@Order
//	public class FullBeanPostProcessor implements BeanPostProcessor,
//			InstantiationAwareBeanPostProcessor,
//			SmartInstantiationAwareBeanPostProcessor,
//			MergedBeanDefinitionPostProcessor,
//			DestructionAwareBeanPostProcessor {
//
//		@Override
//		public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//			return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
//		}
//
//		@Override
//		public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//			return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
//		}
//
//		@Override
//		public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
//
//		}
//
//		@Override
//		public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
//			return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
//		}
//
//		@Override
//		public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
//			return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
//		}
//
//		@Override
//		public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
//			return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
//		}
//
//		@Override
//		public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
//			return SmartInstantiationAwareBeanPostProcessor.super.determineCandidateConstructors(beanClass, beanName);
//		}
//
//		@Override
//		public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
//
//		}
//	}
}

