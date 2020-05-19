package br.pucpr.apppaises;

import android.util.JsonReader;

import org.json.JSONException;
import org.json.JSONObject;

public class PaisData {
    private String url;

    @Override
    public String toString() {
        return "PaisData{" +
                "url='" + url + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
