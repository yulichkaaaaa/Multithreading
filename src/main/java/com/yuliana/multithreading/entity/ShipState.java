package com.yuliana.multithreading.entity;

public interface ShipState {

    void connect(Ship ship);
    void loadShip(Ship ship);
    void unloadShip(Ship ship);
    void disconnect(Ship ship);
}
