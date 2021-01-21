package com.yuliana.multithreading.entity;

import java.util.ArrayList;
import java.util.List;

public class Port {

    private static final Port port = new Port();
    private List<Pier> piers = new ArrayList<Pier>();

    public static Port getInstance() {
        return port;
    }


}
