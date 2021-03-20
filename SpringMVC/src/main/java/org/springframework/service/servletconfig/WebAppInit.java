//package org.springframework.service.servletconfig;
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.support.XmlWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//
//class WebAppInit implements WebApplicationInitializer {
//
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//
//        XmlWebApplicationContext context = new XmlWebApplicationContext();
//        context.setConfigLocation("/WEB-INF/app-context.xml");
//
//        ServletRegistration.Dynamic registration = servletContext.addServlet("app",new DispatcherServlet(context));
//        registration.setLoadOnStartup(1);
//        registration.addMapping("/");
//    }
//}
