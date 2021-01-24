package com.yuliana.multithreading.entity;

import com.yuliana.multithreading.util.IdGenerator;

public class Pier {

    private long pierId;

    public Pier(){
        pierId = IdGenerator.generateId();
    }

    public long getId() {
        return pierId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pier pier = (Pier) o;
        return pierId != pier.pierId;
    }

    @Override
    public int hashCode() {
        return (int)pierId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pier{");
        sb.append("id=").append(pierId);
        sb.append('}');
        return sb.toString();
    }
}
