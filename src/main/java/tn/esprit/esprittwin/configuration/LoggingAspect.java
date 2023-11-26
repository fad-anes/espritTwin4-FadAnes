package tn.esprit.esprittwin.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @Before("execution(* tn.esprit.esprittwin.Service.blocserviceimpl.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Avant l'exécution de la méthode : " + name + " : ");
    }
    @After("execution(* tn.esprit.esprittwin.Service.blocserviceimpl.*(..))")
    public void logMethodExit(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        log.info("Après l'exécution de la méthode : " + name + " : ");
    }

    @AfterReturning(pointcut = "execution(* tn.esprit.esprittwin.Service.blocserviceimpl.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("Après un retour de la méthode : " + joinPoint.getSignature().getName());
        log.info("Résultat : " + result);
    }

    @AfterThrowing(pointcut = "execution(* tn.esprit.esprittwin.Service.blocserviceimpl.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        log.info("Après une exception dans la méthode : " + joinPoint.getSignature().getName());
        log.info("Exception : " + exception.getMessage());
    }
}

