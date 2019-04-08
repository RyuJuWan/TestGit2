package kr.or.ddit.aop;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;


// 스프링 프레임웍은 설정파일 내에 선언된 빈 선언 또는
// Component-scan 설정에 따라 @Controller, @Service,
// @Repository, @Component가 선언된 클래스들을 빈으로
// 등록하기 위해 DefaultBeanPostProcessor(implements BeanPostProcessor)를 활용.
@Component
public class LoggerInjector implements BeanPostProcessor {
	
	// 파라미터1 : 금번 빈으로 등록완료된 빈 객체 DI.
	// 파라미터2 : 금번 빈으로 등록 완료된 빈의 이름 DI.
	@Override
	public Object postProcessAfterInitialization(Object beanClazz, String beanName)
			throws BeansException {
		// 빈 등록이 완료되면 콜백
		return beanClazz;
	}
	
	// 파라미터1 : 금번 빈으로 등록 착수시 빈 객체 DI.
	// 파라미터2 : 금번 빈으로 등록 착수시 빈의 이름 DI.
	@Override
	public Object postProcessBeforeInitialization(final Object beanClazz, String beanName)
			throws BeansException {
		// 1. 빈 등록 대상의 클래스를 빈 등록 전에  postProcessBeforeInitialization() 콜백
		// 2. 빈 등록 대상 클래스 내 선언된 모든 전역변수에 반복적으로 접근하기 위해 ReflectionUtils 활용
		ReflectionUtils.doWithFields(beanClazz.getClass(), new FieldCallback() {
			@Override
			public void doWith(Field field) throws IllegalArgumentException,
					IllegalAccessException {
				// 해당 전역변수의 접근 지정자가 private이어도 접근될 수 있는 환경 제공
				ReflectionUtils.makeAccessible(field);
				if(field.getAnnotation(Loggable.class) != null){
					Logger logger = LoggerFactory.getLogger(beanClazz.getClass());
					field.set(beanClazz, logger);
				}
			}
		});
		return beanClazz;
	}

}
