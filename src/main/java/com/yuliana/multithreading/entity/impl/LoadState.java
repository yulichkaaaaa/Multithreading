package com.yuliana.multithreading.entity.impl;

import com.yuliana.multithreading.entity.ShipState;
import com.yuliana.multithreading.entity.Port;
import com.yuliana.multithreading.entity.Ship;

public class LoadState implements ShipState {

    private static final LoadState INSTANCE = new LoadState();

    private static final Port port = Port.getInstance();

    public static LoadState getInstance() {
        return INSTANCE;
    }

    private LoadState() {}

    public void connect(Ship ship) {

    }

    public void loadShip(Ship ship) {

    }

    public void unloadShip(Ship ship) {

    }

    public void disconnect(Ship ship) {

    }
}
