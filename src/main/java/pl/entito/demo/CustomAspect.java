package pl.entito.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CustomAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Pointcut("execution(* pl.entito.demo.GreeterService.greet(..))")
	public void greetPointcut() {
	}

	@Around("greetPointcut()")
	public void around(ProceedingJoinPoint jointPoint) {
		try {
			logger.info("Aspect before: " + jointPoint.getSignature().toShortString());
			jointPoint.proceed();
			logger.info("Aspect after: " + jointPoint.getSignature().toShortString());
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
