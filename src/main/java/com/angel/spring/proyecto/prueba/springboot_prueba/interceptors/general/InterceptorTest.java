package com.angel.spring.proyecto.prueba.springboot_prueba.interceptors.general;


import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//Clase para interceptar el endpoint(https://app.com//app/test)
@Component("InterceptorTest")
public class InterceptorTest implements HandlerInterceptor {

    //Creacion de log del componente
    private final Logger logger = LoggerFactory.getLogger(InterceptorTest.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HandlerMethod controlador = (HandlerMethod) handler;

        logger.info("Probando tiempos de espera del controlador: " + controlador.getMethod().getName());
        var timeStart = System.currentTimeMillis();

        request.setAttribute("start", timeStart);

        Random random = new Random();
        Long timeResearch = random.nextLong(500);
        Thread.sleep(timeResearch);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

        var timeFinal = System.currentTimeMillis();
         
        var timeStart = (Long)request.getAttribute("start");
    
        Long timeTotal = timeFinal - timeStart;

        logger.info("El tiempo de espera para la solicitud del endpoint fue de: "+timeTotal);

    }

}
