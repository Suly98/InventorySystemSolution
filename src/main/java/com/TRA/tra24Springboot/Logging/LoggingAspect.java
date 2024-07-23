package com.TRA.tra24Springboot.Logging;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.Date;

@Aspect
@Component
public class LoggingAspect {
    public static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    public static Long time;


    @Pointcut(value = "execution(* com.TRA.tra24Springboot.Controllers.InventoryController.*(..))")
    public void pointCutDefinitionInventory(){}

    @Before(value = "pointCutDefinitionInventory()")
    public void logBefore(JoinPoint pjp){
        time = System.nanoTime();
        System.out.println("Before method: " + pjp.getSignature().getName());
    }

    @AfterReturning(value = "pointCutDefinitionInventory()", returning = "result")
    public void logAfterReturning(JoinPoint pjp, Object result){
        System.out.println("After method: " + pjp.getSignature().getName() + ", Result: " + result);

    }

    @Around(value = "pointCutDefinitionInventory()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();

        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        Object[] array = pjp.getArgs();

        logger.info("\n***** Before function execution ****"+"\nThis class is running: " + className + "\nThis function is running " + methodName + "() " + "\nFunction arguments : "
                + mapper.writeValueAsString(array));

        Object object = pjp.proceed();
        Long duration = System.nanoTime() - time;
        Float timeExecuted = duration/(1000000000.0f);

        logger.info("\n**** After function execution ****"+ "\nTime Execution: " + timeExecuted + "sec"+
                "\nThis class is running: " + className + "\nThis function is running " + methodName + "()" + "\nResponse : "
                + mapper.writeValueAsString(object));
        return object;
    }

}
