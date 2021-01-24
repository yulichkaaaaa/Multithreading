package com.yuliana.multithreading.main;

import com.yuliana.multithreading.creator.ShipCreator;
import com.yuliana.multithreading.entity.Ship;
import com.yuliana.multithreading.reader.CustomFileReader;

import java.util.List;

public class Main {
    public static void main(String[] args){
        CustomFileReader reader = new CustomFileReader();
        List<String> lines = reader.readData("file.txt");
        ShipCreator creator = new ShipCreator();
        List<Ship> ships = creator.create(lines);
        for (Ship ship : ships){
            ship.start();
        }
    }
}
