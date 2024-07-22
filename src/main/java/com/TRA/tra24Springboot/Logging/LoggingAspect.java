package com.TRA.tra24Springboot.Logging;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactoryFriend;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    public static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut(value = "execution(* com.TRA.tra24Springboot.Controllers.*(..)")
    public void pointCutDefinitionInventory(){}



}
