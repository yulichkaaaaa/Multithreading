package com.yuliana.multithreading.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Port {

    private static final Logger logger = LogManager.getLogger();
    private static final Port port = new Port();
    private static final int STORE_CAPACITY = 100;
    private static final int PIERS_COUNT = 6;

    private ArrayDeque<Pier> piers = new ArrayDeque<>(PIERS_COUNT);
    private int freeContainers = STORE_CAPACITY;
    private ReentrantLock locker = new ReentrantLock();
    private Condition condition = locker.newCondition();

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
            while (piers.isEmpty()){
                condition.await();
            }
            Pier pier = piers.pop();
            ship.setPier(pier);
            logger.log(Level.DEBUG, "ship {} connected", ship.getShipId());
            System.out.println("connect" + ship.getShipId());
        } catch (InterruptedException e) {
            e.printStackTrace();
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
            if(ship.getPier() != null){
                piers.add(ship.getPier());
                condition.signal();
            }
            ship.setPier(null);
            logger.log(Level.DEBUG, "ship {} disconnected", ship.getShipId());
        } finally {
            locker.unlock();
        }
    }
}
