package com.example.learnSpring.examples.e1;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class NormalClass{
	
}

@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class ProtoTypeClass{
	
}

@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class)){
		
			//Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			//Hash Code will be same on each class.
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));
			
			//Hash Code will be different on each class.
			System.out.println(context.getBean(ProtoTypeClass.class));
			System.out.println(context.getBean(ProtoTypeClass.class));
			System.out.println(context.getBean(ProtoTypeClass.class));
		}
		

	}

}
