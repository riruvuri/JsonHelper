package org.example;

import org.json.JSONObject;
import org.junit.Test;

public class SimpleJsonTest {
    @Test
    public void generate_json() {
        SimpleJsonWrite jsonWrite = new SimpleJsonWrite();
        jsonWrite.generateJson();
    }

    @Test
    public void read_json() {
        SimpleJsonRead jsonRead = new SimpleJsonRead();
        JSONObject jsonObject = jsonRead.read("sample.json");
        System.out.println(jsonObject.toString());
    }
}
