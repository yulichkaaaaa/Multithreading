package com.yuliana.multithreading.entity;

public interface PierState {

    void connect(Ship ship);
    void loadShip(Ship ship);
    void unloadShop(Ship ship);
    void disconnect(Ship ship);
}
