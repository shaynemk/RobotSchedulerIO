package com.keller23.java.robotschedulerio.config;

import com.keller23.java.robotschedulerio.lib.Refs;

import java.io.File;

public class Config {

    // Standard Configuration File Settings
    public static final String CONFIG_USER = "shayne.adm";
    public static final String CONFIG_DIR = "\\AppData\\Local\\RobotSchedulerIO";
    /*public static final File CONFIG_USERPATH = new File(System.getProperty("user.home") + "\\AppData\\Local");*/
    public static final String CONFIG_PATH = System.getProperty("user.home").concat("\\" /*+ CONFIG_USER */+ CONFIG_DIR + "\\");
    public static final String CONFIG_FILE = "app.settings";
    public static final String CONFIG_PATHFILE = CONFIG_PATH + CONFIG_FILE;
    public static boolean debug = Refs.DEBUG;

    public static final String[] CONFIG_OPTS = {"S_cfg_path_file", "S_cfg_path_filename", "b_dbg"};
}