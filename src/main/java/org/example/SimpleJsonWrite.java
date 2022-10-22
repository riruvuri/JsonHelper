package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleJsonWrite {
    public void generateJson() {
        JSONObject jsonObject = new JSONObject();

        // Set the element at root level
        jsonObject.put("firstName", "rancho");
        jsonObject.put("lastName", "pancho");

        jsonObject.put("alternateNames", Arrays.asList("Mr.Hero", "D"));

        Map<String, String> addressMap = new LinkedHashMap<>();
        addressMap.put("address1", "1x2x Broadway");
        addressMap.put("address2", "");
        addressMap.put("city", "San Francisco");
        addressMap.put("state", "CA");

        jsonObject.put("address", addressMap);

        JSONArray jsonArray = new JSONArray();
        Map<String, String> m = new LinkedHashMap(2);
        m.put("type", "home");
        m.put("number", "212 555-1234");

        jsonArray.put(m);

        m = new LinkedHashMap(2);
        m.put("type", "fax");
        m.put("number", "212 555-1234");
        jsonArray.put(m);

        jsonObject.put("phoneNumbers", jsonArray);

        PrintWriter pw = null;
        try {
            File newFile = new File(SimpleJsonWrite.class.getResource(".").getFile() + "/sample.json");
            pw = new PrintWriter(newFile);
            pw.write(jsonObject.toString());
        } catch (Exception e) {

        } finally {
            pw.flush();
            pw.close();
        }
    }
}
