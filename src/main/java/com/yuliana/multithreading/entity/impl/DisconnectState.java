package com.yuliana.multithreading.entity.impl;

import com.yuliana.multithreading.entity.ShipState;
import com.yuliana.multithreading.entity.Port;
import com.yuliana.multithreading.entity.Ship;

public class DisconnectState implements ShipState {

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

    public void unloadShip(Ship ship) {

    }

    public void disconnect(Ship ship) {

    }
}
