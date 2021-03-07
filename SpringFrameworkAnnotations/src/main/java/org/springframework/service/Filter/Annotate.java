package org.springframework.service.Filter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.service.customQualifier.AnnotateCustom;

@Configuration
@ComponentScan(basePackages = {"org.springframework."},includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = AnnotateCustom.class))
public class Annotate {

}
