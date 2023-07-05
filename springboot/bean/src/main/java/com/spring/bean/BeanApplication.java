package com.spring.bean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeanApplication {

	// TODO
	// https://reflectoring.io/spring-bean-lifecycle/


	/**
	 *	- Bean Creation Phases
	 *	1.Instantiation: This is where everything starts for a bean. Spring instantiates bean objects
	 *					 just like we would manually create a Java object instance.
	 *
	 *	2.Populating Properties: After Instantiating objects, Spring scans the beans that implements
	 *							 Aware interfaces and starts setting relevant properties.
	 *
	 *	3.Pre-Initialization: Spring’s BeanPostProcessors get into action in this phase.
	 *						  The postProcessBeforeInitialization() methods do their job. Also,
	 *						  @PostConstruct annotated methods run right after them.
	 *
	 *	4.AfterPropertiesSet: Spring executes the afterPropertiesSet() methods of
	 *						  the beans which implement InitializingBean.
	 *
	 * 	5.Custom Initialization: Spring triggers the initialization methods that we defined in
	 * 							 the initMethod attribute of our @Bean annotations.
	 *
	 *	6.Post-Initialization: Spring’s BeanPostProcessors are in action for the second time.
	 *						   This phase triggers the postProcessAfterInitialization() methods.
	 */

	/**
	 * 	- Bean Destruction Phases
	 *	1. Pre-Destroy: Spring triggers@PreDestroy annotated methods in this phase.
	 *
	 *	2. Destroy: Spring executes the destroy() methods of DisposableBean implementations.
	 *
	 *	3. Custom Destruction: We can define custom destruction hooks with the destroyMethod attribute in the
	 *						  @Bean annotation and Spring runs them in the last phase.
	 *
	 */

	public static void main(String[] args) {
		SpringApplication.run(BeanApplication.class, args);
	}




}
