package org.springframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.service.CoachTypes.SwimCoach;
import org.springframework.service.Configs.BeanConfig;
import org.springframework.service.JSR330.InjectAnno;

import java.util.logging.Logger;

public class SpringFrameworkJSR
{
    static final Logger LOG = Logger.getLogger(SpringFrameworkJSR.class.getName());

    public static void main( String[] args ) {
        jsr();
    }

    private static void jsr() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("org.springframework.");
        context.refresh();
        InjectAnno injectAnno = context.getBean("injectAnno",InjectAnno.class);
        LOG.info("@inject anno="+injectAnno.getMedal1());

    }
}
