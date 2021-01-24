package com.yuliana.multithreading.entity.impl;

import com.yuliana.multithreading.entity.ShipState;
import com.yuliana.multithreading.entity.Port;
import com.yuliana.multithreading.entity.Ship;

public class ConnectState implements ShipState {

    private static final ConnectState INSTANCE = new ConnectState();
    private Port port = Port.getInstance();

    public static ConnectState getInstance() {
        return INSTANCE;
    }

    private ConnectState() {}

    public void connect(Ship ship) {
        port.connectShip(ship);
        ship.setShipState(UnloadState.getInstance());
    }

    public void loadShip(Ship ship) {

    }

    public void unloadShip(Ship ship) {

    }

    public void disconnect(Ship ship) {

    }
}
