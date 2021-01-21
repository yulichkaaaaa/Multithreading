package com.yuliana.multithreading.entity.impl;

import com.yuliana.multithreading.entity.PierState;
import com.yuliana.multithreading.entity.Port;
import com.yuliana.multithreading.entity.Ship;

public class DisconnectState implements PierState {

    private static final DisconnectState INSTANCE = new DisconnectState();

    private static final Port port = Port.getInstance();

    public static DisconnectState getInstance() {
        return INSTANCE;
    }

    private DisconnectState() {}

    public void connect(Ship ship) {

    }

    public void loadShip(Ship ship) {

    }

    public void unloadShop(Ship ship) {

    }

    public void disconnect(Ship ship) {

    }
}
