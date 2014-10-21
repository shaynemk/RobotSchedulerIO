package com.keller23.java.robotschedulerio.utils;

import com.keller23.java.robotschedulerio.config.Config;
import com.keller23.java.robotschedulerio.lib.Refs;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;

public class IO {

    public static boolean read(String _dir, String _file){
        File dir = new File(_dir);
        File file = new File(_file);

        if(!dir.exists()) {
            Debug.output("Directory does not exist.");
            return false;
        }
        if(!file.exists()) {
            Debug.output("File does not exist.");
            return false;
        }
        Debug.d("Yay, file and directory exists!");
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
                LogHelper.warning("Unable to create root directory");
            }
            LogHelper.debug("Root directory created");
        } else {
            LogHelper.debug("Root directory exists");
        }
        if (file.exists()) {
            load();
        } else if (!file.exists()) {
            LogHelper
                    .warning("Config not found: creating default config (This is normal on a first start)");
            createDefaults();
        }
        LogHelper.debug("Config handler initilized");
    }*/
}
