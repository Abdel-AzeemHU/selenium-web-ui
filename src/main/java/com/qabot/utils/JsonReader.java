package com.qabot.utils;

import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JsonReader {
    /**
     * Data iterator for json file
     * @param file json file path
     * @param expression GPath inside the json file
     * @return iterator of Map of json objects
     */
    public static Iterator<Map> dataIterator(String file, String expression) {
        InputStream inputStream = null;
        inputStream = ClassLoader.getSystemResourceAsStream(file);

        List<Map> data = null;
        try {
            String jsonFile = new String(inputStream.readAllBytes());
            data = JsonPath.read(jsonFile, expression);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.iterator();
    }
}
