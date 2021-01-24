package com.yuliana.multithreading.reader;

import com.yuliana.multithreading.validator.FileValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomFileReader {

    private static final Logger logger = LogManager.getLogger();
    private static final String DEFAULT_FILE_NAME = "data/default.txt";

    public List<String> readData(String fileName){
        List<String> lines = new ArrayList<>();
        Path path;
        if(FileValidator.isFileValid(fileName)) {
            path = Paths.get(fileName);
        }else {
            path = Paths.get(DEFAULT_FILE_NAME);
        }
        try(Stream<String> lineStream = Files.lines(path)) {
            lines = lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            logger.error(Level.ERROR, e);
        }
        return lines;
    }

}
