package com.yuliana.multithreading.entity.impl;

import com.yuliana.multithreading.entity.PierState;
import com.yuliana.multithreading.entity.Port;
import com.yuliana.multithreading.entity.Ship;

public class UnloadState implements PierState {

    private static final UnloadState INSTANCE = new UnloadState();

    private static final Port shipPort = Port.getInstance();

    public static UnloadState getInstance() {
        return INSTANCE;
    }

    private UnloadState() {}

    public void connect(Ship ship) {

    }

    public void loadShip(Ship ship) {

    }

    public void unloadShop(Ship ship) {

    }

    public void disconnect(Ship ship) {

    }
}
