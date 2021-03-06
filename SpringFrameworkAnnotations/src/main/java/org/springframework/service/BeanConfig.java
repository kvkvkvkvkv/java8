package org.springframework.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.models.Coach;
import org.springframework.models.Fortune;

@Configuration
//@ComponentScan("org.springframework.") now will pick manually defined beans rather than componnet scan
@PropertySource("classpath:sport.properties")
public class BeanConfig {

    @Bean
    public Fortune happyFortune(){
        return new HappyFortuneService();
    }

    @Bean
    public Coach coach(){
        return new SwimCoach(happyFortune());
    }
}
