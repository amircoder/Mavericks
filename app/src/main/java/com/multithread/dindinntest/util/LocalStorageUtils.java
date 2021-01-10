package com.multithread.dindinntest.util;

import android.content.Context;

import java.io.InputStream;

public class LocalStorageUtils {
    public static String readJsonFromFileAssets(Context context, String jsonFile) {
        String json;
        try {
            InputStream is = context.getAssets().open(jsonFile);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
