package com.yuliana.multithreading.entity;

import com.yuliana.multithreading.util.IdGenerator;

public class Pier {

    private long id = IdGenerator.generateId();
    private Ship ship;

    public long getId() {
        return id;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pier pier = (Pier) o;

        if (id != pier.id) return false;
        return ship != null ? ship.equals(pier.ship) : pier.ship == null;
    }

    @Override
    public int hashCode() {
        int result = (int)id;
        result = 31 * result + (ship != null ? ship.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pier{");
        sb.append("id=").append(id);
        sb.append(", ship=").append(ship);
        sb.append('}');
        return sb.toString();
    }
}
