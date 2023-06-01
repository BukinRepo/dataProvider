package utils;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import models.ManModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvReader {
    public static <T> List<T> getListAgesFromCsv(String PATH, Class<? extends T> type){
        try {
            BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(PATH));
            CsvToBean<T> csvObjects = new CsvToBeanBuilder<T>(bufferedReader).withType(type).build();
            return csvObjects.parse();
        }catch (IOException exception){
            throw new RuntimeException("This file is not exist by path = " + PATH + exception);
        }
    }
}
