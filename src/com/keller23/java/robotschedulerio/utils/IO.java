package com.keller23.java.robotschedulerio.utils;

import org.json.simple.JSONObject;

import java.io.File;

public class IO {

    public static boolean read(String _dir, String _file){
        File dir = new File(_dir);
        File file = new File(_file);

        if(!dir.exists()) {
            Log.console("Directory does not exist.");
            return false;
        }
        if(!file.exists()) {
            Log.console("File does not exist.");
            return false;
        }
        Log.d("Yay, file and directory exists!");
        return true;
    }

    public static boolean write(String _dir, String _file, JSONObject _json){
        return true;
    }

    /*public static void checkFile() {
        File dir = new File(Config.CONFIG_PATH);

        if (!dir.exists()) {
            try {
                IOUtils.createUserDir(Refs.AUTHOR);
            } catch (IOException e) {
                e.printStackTrace();
                Log.warning("Unable to create root directory");
            }
            Log.DEBUG("Root directory created");
        } else {
            Log.DEBUG("Root directory exists");
        }
        if (file.exists()) {
            load();
        } else if (!file.exists()) {
            Log
                    .warning("Config not found: creating default config (This is normal on a first start)");
            createDefaults();
        }
        Log.DEBUG("Config handler initilized");
    }*/
}
