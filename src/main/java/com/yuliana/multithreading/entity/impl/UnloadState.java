package com.yuliana.multithreading.entity.impl;

import com.yuliana.multithreading.entity.ShipState;
import com.yuliana.multithreading.entity.Port;
import com.yuliana.multithreading.entity.Ship;

public class UnloadState implements ShipState {

    private static final UnloadState INSTANCE = new UnloadState();

    public static UnloadState getInstance() {
        return INSTANCE;
    }

    private UnloadState() {}

    public void connect(Ship ship) {

    }

    public void loadShip(Ship ship) {

    }

    public void unloadShip(Ship ship) {
        Port.getInstance().unloadShip(ship);
        ship.setShipState(LoadState.getInstance());
    }

    public void disconnect(Ship ship) {

    }
}
