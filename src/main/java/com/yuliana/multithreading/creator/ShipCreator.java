package com.yuliana.multithreading.creator;

import com.yuliana.multithreading.entity.Ship;
import com.yuliana.multithreading.parser.DataParser;

import java.util.ArrayList;
import java.util.List;

public class ShipCreator {

    public List<Ship> create(List<String> lines){
        DataParser parser = new DataParser();
        List<Ship> ships = new ArrayList<>();
        for (String line : lines){
            int containers = parser.parseShipData(line);
            if (containers > 0){
                ships.add(new Ship(containers));
            }
        }
        return ships;
    }
}
