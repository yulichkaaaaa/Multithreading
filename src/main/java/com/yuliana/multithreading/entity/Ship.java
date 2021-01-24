package com.yuliana.multithreading.entity;

import com.yuliana.multithreading.util.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ship extends Thread{

    private static final Logger logger = LogManager.getLogger();
    public static final int CAPACITY = 10;
    private long shipId;
    private int containersCount;
    private ShipState shipState;
    private Pier pier;

    public Ship(int containersCount){
        shipId = IdGenerator.generateId();
        this.containersCount = containersCount;
    }

    public long getShipId() {
        return shipId;
    }

    public int getContainersCount() {
        return containersCount;
    }

    public ShipState getShipState() {
        return shipState;
    }

    public void setContainersCount(int containersCount) {
        this.containersCount = containersCount;
    }

    public void setShipState(ShipState shipState) {
        this.shipState = shipState;
    }

    public Pier getPier() {
        return pier;
    }

    public void setPier(Pier pier) {
        this.pier = pier;
    }

    @Override
    public void run() {
        logger.debug("connect " + shipId);
        shipState.connect(this);
        logger.debug("load " + shipId);
        shipState.loadShip(this);
        logger.debug("unload " + shipId);
        shipState.unloadShip(this);
        logger.debug("disconnect " + shipId);
        shipState.disconnect(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return shipId == ship.shipId &&
                containersCount == ship.containersCount &&
                shipState.equals(ship.shipState);
    }

    @Override
    public int hashCode() {
        int result = (int)shipId;
        result = 31 * result * containersCount;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ship{");
        sb.append("id=").append(shipId);
        sb.append(", containersCount=").append(containersCount);
        sb.append(", shipState=").append(shipState);
        sb.append('}');
        return sb.toString();
    }
}
