package org.springframework.service.JSR330;


import org.springframework.models.Medalist;
import org.springframework.service.customQualifier.Medal;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

@Component
public class InjectAnno {

    @Inject //autowire on const/setter/method/field
    @Named("silver") //quallifier
    Medalist medal;

//    Provider<Medalist> medal1; //intercept point
//
//    @Inject
//    public void setMedal1( Provider<Medalist> medal1) {
//        this.medal1 = medal1;
//    }

    //let's you play with injection point
    public String getMedal1() {
        return this.medal.medal();
    }


}
