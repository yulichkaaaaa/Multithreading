package com.yuliana.multithreading.parser;

import com.yuliana.multithreading.validator.DataValidator;

public class DataParser {

    public int parseShipData(String data){
        int shipData = 0;
        if(DataValidator.isCorrectShip(data)){
            shipData = Integer.parseInt(data);
        }
        return shipData;
    }
}
