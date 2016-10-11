package com.supets.pet.supetsrouter.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class NavigationUriData implements Serializable {
    private OnUriDataListener mListener;

    public String functionName;
    public String functionData;

    public NavigationUriData(String functionName, String functionData) {
        this.functionName = functionName;
        this.functionData = functionData;
    }

    public void setOnUriDataListener(OnUriDataListener mListener) {
        this.mListener = mListener;
    }

    public NavigationUriData(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            functionName = jsonObject.getString("functionName");
            functionData = jsonObject.getString("functionData");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void execate() {
        if (mListener != null) {
            mListener.onUriData(this);
        }
    }

    public String toString() {
        try {
            return new JSONObject().put("functionName", functionName).put("functionData", functionData).toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "{}";
    }
}
