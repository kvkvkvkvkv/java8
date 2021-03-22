//package org.springframework.service.servletconfig;
//
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.support.XmlWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;
//
//public class AbstractConfigDispatcherServletInit extends AbstractDispatcherServletInitializer {
//
//    @Override
//    protected WebApplicationContext createServletApplicationContext() {
//        XmlWebApplicationContext context = new XmlWebApplicationContext();
//        context.setConfigLocation("/WEB-INF/app-context.xml");
//        return context;
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[] {"/"};
//    }
//
//    @Override
//    protected WebApplicationContext createRootApplicationContext() {
//        return null;
//    }
//}
