package com.keller23.java.robotschedulerio.lib;

import com.keller23.java.robotschedulerio.Main;
import com.keller23.java.robotschedulerio.utils.Debug;
import org.json.simple.JSONObject;

import java.io.File;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.util.jar.JarFile;

public class Refs {

    public static final boolean DEBUG = false;

    public static final String APPNAME = "Robot Scheduler IO";
    public static final String VERSION = "v1.0";
    public static final String DEVELOPEDBY = "Developed by: ";
    public static final String DEVELOPER = "Shayne Keller";
    public static final String PURPOSE = "The purpose of this IO library is to interface with Brian Haddad's\n" +
                                         "Robot Scheduler v2 JavaScript webapp to allow for File IO handling\n" +
                                         "of automagically writing the schedules to disk.";
    public static final String DEBUG_PREFIX = "DEBUG: ";
    public static final String ABOUTVERSION = APPNAME + ", " + VERSION + "\n" + PURPOSE;

    public static final String OPTIONABOUT = "About";
    public static final String OPTIONABOUTCMD = "--about";
    public static final String OPTIONREAD = "Read";
    public static final String OPTIONREADCMD = "--read";
    public static final String OPTIONWRITE = "Write";
    public static final String OPTIONWRITECMD = "--write";
    public static final String OPTIONTEST = "Test";
    public static final String OPTIONTESTCMD = "--test";
    public static final String OPTIONOPTIONS = "Options";
    public static final String OPTIONOPTIONSCMD = "--options";

    public static JSONObject OPTIONS = new JSONObject();

    //Location Code
    public static String findMe(){
        JarFile myJar;
        CodeSource codeSource = Main.class.getProtectionDomain().getCodeSource();
        File jarFile = null;
        try {
            jarFile = new File(codeSource.getLocation().toURI().getPath());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            /*LogHelper.severe(e.getMessage());*/
        }
        return jarFile.getParentFile().getPath();
    }

    public static void showOptions() {
        Debug.console("\n" + OPTIONS);
    }
}
