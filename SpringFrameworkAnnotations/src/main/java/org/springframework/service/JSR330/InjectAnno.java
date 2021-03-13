package org.springframework.service.JSR330;


import org.springframework.lang.Nullable;
import org.springframework.models.Coach;
import org.springframework.models.Medalist;
import org.springframework.models.ParentInterface;
import org.springframework.service.customQualifier.Medal;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

@Named //@ManagedBean = @Component
public class InjectAnno {

    @Inject //autowire on const/setter/method/field
    @Named("silver") //quallifier
    Medalist medal;

    ParentInterface parentInterface;

//    @Inject
//    public InjectAnno(@Nullable ParentInterface parentInterface) {
//        this.parentInterface = parentInterface;
//    }
//
//    @Inject
//    public InjectAnno(@Named("childTwo") ParentInterface parentInterface,@Named("bronze") Medalist medal1) {
//        this.parentInterface = parentInterface;
//        this.medal1 = medal1;
//    }
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

    //optional/nullable



}
