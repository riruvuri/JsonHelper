package org.example;

import org.json.*;

import java.io.InputStream;

public class SimpleJsonRead {
    public JSONObject read(String fileName) {
        InputStream inputStream = SimpleJsonRead.class.getResourceAsStream("sample.json");
        JSONTokener tokener = new JSONTokener(inputStream);

        JSONObject jsonObject = new JSONObject(tokener);

        String firstName = jsonObject.getString("firstName");
        String lastName = jsonObject.getString("firstName");

        JSONObject address = jsonObject.getJSONObject("address");
        String address1 = address.getString("address1");

        JSONArray jsonArray = jsonObject.getJSONArray("phoneNumbers");
        for (int i=0; i < jsonArray.length(); i++) {
            JSONObject arrayObj = (JSONObject) jsonArray.get(i);
            String phoneType = arrayObj.getString("type");
            String phoneNumber = arrayObj.getString("number");
        }

        JSONArray alternateNames = jsonObject.getJSONArray("alternateNames");
        for (int i=0; i < alternateNames.length(); i++) {
            String alternateName = alternateNames.getString(i);
        }
        return jsonObject;
    }
}
