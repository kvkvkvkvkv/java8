package org.springframework.service.lazy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

@Lazy
@Configuration
@ComponentScan("org.springframework.")
public class LazyConfig {

    Logger log = Logger.getLogger("City");

   @Bean
   public City city(){
       return new City();
   }
}
