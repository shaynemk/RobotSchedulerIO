package com.keller23.java.robotschedulerio.config;

import com.keller23.java.robotschedulerio.lib.Refs;
import com.keller23.java.robotschedulerio.utils.Debug;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigHandler {

    private static File configFile = new File(Config.CONFIG_PATHFILE);

    public static void init() {
        Debug.output("Initializing Config File.");
        File configDir = new File(Config.CONFIG_PATH);
        if(!configDir.exists()) {
            try {
                createConfigDir();
            } catch (IOException e) {
                Debug.output("Unable to create config directory.");
                e.printStackTrace();
            }
            Debug.output("Config Directory created.");
        } else Debug.output("Config Directory exists.");
        if(configFile.exists()) {
            load();
        }
        else if (!configFile.exists()) {
            Debug.output("Config File does not exist.");
            createConfigFile();
        }
    }

    private static boolean createConfigDir() throws IOException {
        final File configDir = new File(Config.CONFIG_PATH);
        if (!configDir.exists() && !configDir.mkdirs()) {
            throw new IOException("Unable to create " + configDir.getAbsolutePath());
        }
        return true;
    }

    private static void load() {
        // loading config file
        Debug.output("Loading Config File.");

    }

    private static void save() {
        // saving config file
        Properties props = new Properties();
        OutputStream os = null;

        try {
            os = new FileOutputStream(configFile);

            props.setProperty(Config.CONFIG_OPTS[0], Config.CONFIG_PATH);
            props.setProperty(Config.CONFIG_OPTS[1], Config.CONFIG_FILE);
            props.setProperty(Config.CONFIG_OPTS[2], Config.debug);

            /*props.setProperty(Config.CONFIG_NAMES[0], Config.chfPath);
            props.setProperty(Config.CONFIG_NAMES[1], Config.chfTest);
            props.setProperty(Config.CONFIG_NAMES[2], String.valueOf(Config.useChf));
            props.setProperty(Config.CONFIG_NAMES[3], String.valueOf(Config.autoSelection));
            props.setProperty(Config.CONFIG_NAMES[4], String.valueOf(Config.debug));
            props.setProperty(Config.CONFIG_NAMES[5], String.valueOf(Config.error));
            props.setProperty(Config.CONFIG_NAMES[6], Config.dbPath);
            props.setProperty(Config.CONFIG_NAMES[7], String.valueOf(Config.autoCopy));*/

            props.store(os, Refs.APPNAME);

            os.close();
            load();

        } catch (IOException e) {
            e.printStackTrace();
            Debug.output(e.getMessage());
        }
    }
    private static void createConfigFile() {
        // creating config file
        Debug.output("Creating Config File.");


    }
}
