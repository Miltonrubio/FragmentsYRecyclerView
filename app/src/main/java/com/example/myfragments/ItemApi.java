package com.example.myfragments;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItemApi {


    private String name;
    private String url;

    public ItemApi(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static List<ItemApi> parseJsonResponse(JSONArray jsonArray) {
        List<ItemApi> itemList = new ArrayList<>();

        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject itemObject = jsonArray.getJSONObject(i);

                String name = itemObject.getString("name");
                String url = itemObject.getString("url");
                ItemApi itemApi = new ItemApi(name, url);
                itemList.add(itemApi);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return itemList;
    }

}
