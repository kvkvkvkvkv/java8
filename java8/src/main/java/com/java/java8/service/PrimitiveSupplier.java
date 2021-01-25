package com.java.java8.service;

import org.springframework.stereotype.Service;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

@Service
public class PrimitiveSupplier {

    //IntSupplier/Double/Long
    //getAsInt/Long/Double
    //applied on o/p

    public IntSupplier supplyOTP = () -> (int) (Math.random()*9000);
}
