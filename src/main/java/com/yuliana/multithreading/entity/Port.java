package com.yuliana.multithreading.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.concurrent.locks.ReentrantLock;

public class Port {

    private static final Logger logger = LogManager.getLogger();
    private static final Port port = new Port();
    private static final int STORE_CAPACITY = 100;
    private static final int PIERS_COUNT = 8;

    private ArrayDeque<Pier> piers = new ArrayDeque<>(PIERS_COUNT);
    private int freeContainers = STORE_CAPACITY;
    private ReentrantLock locker = new ReentrantLock();

    public static Port getInstance() {
        return port;
    }

    private Port() {
        for (int i = 0; i < PIERS_COUNT; i++) {
            piers.add(new Pier());
        }
    }


    public void connectShip(Ship ship){
        try {
            locker.lock();
            if (!piers.isEmpty()) {
                Pier pier = piers.pop();
                ship.setPier(pier);
                logger.debug("ship {} connected", ship.getShipId());
            } else {
                logger.debug("No available pier");
            }
        } finally {
            locker.unlock();
        }
    }

    public void unloadShip(Ship ship) {
        try {
            locker.lock();
            int count = ship.getContainersCount();
            for (int i = 0; i < count; i++){
                freeContainers--;
            }
        } finally {
            locker.unlock();
        }
    }

    public void loadShip(Ship ship) {
        try {
            locker.lock();
            int count = ship.CAPACITY;
            for (int i = 0; i < count; i++){
                freeContainers++;
            }
        } finally {
            locker.unlock();
        }
    }

    public void disconnectShip(Ship ship){
        try {
            locker.lock();
            piers.add(ship.getPier());
            ship.setPier(null);
        } finally {
            locker.unlock();
        }
    }
}
