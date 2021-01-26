package com.java.java8.service.customfunctionalinterface;

@FunctionalInterface
public interface ConstructorWithPAram<T,U> {

    T constructor(U param);
}
