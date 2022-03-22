package com.ProyectoFinal;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectConfig {

	Logger milog = (Logger) LoggerFactory.getLogger(AspectConfig.class);

	@Before(value = "execution(* com.mistareas.controllers.*.*(..))")
	public void sentenciaLogBefore(JoinPoint punto) {

		milog.info("ejecutando {}", punto);

	}

	@After(value = "execution(* com.mistareas.controllers.*.*(..))")
	public void sentenciaLogAfter(JoinPoint punto) {

		milog.info("Completa ejecucion de {}", punto);

	}

}
