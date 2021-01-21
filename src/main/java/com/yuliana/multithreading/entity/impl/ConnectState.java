package com.yuliana.multithreading.entity.impl;

import com.yuliana.multithreading.entity.PierState;
import com.yuliana.multithreading.entity.Port;
import com.yuliana.multithreading.entity.Ship;

public class ConnectState implements PierState {

    private static final ConnectState INSTANCE = new ConnectState();

    private Port shipPort = Port.getInstance();

    public static ConnectState getInstance() {
        return INSTANCE;
    }

    private ConnectState() {}

    public void connect(Ship ship) {

    }

    public void loadShip(Ship ship) {

    }

    public void unloadShop(Ship ship) {

    }

    public void disconnect(Ship ship) {

    }
}
