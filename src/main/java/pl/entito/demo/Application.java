package pl.entito.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		GreeterService greeter = (GreeterService) context.getBean(GreeterService.class);

		// Custom around aspect will be invoke here
		greeter.greet();

		context.close();
	}

}
