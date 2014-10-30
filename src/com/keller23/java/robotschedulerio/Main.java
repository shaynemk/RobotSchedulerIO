package com.keller23.java.robotschedulerio;

import com.keller23.java.robotschedulerio.lib.Refs;
import com.keller23.java.robotschedulerio.utils.IO;
import com.keller23.java.robotschedulerio.utils.log.Log;
import com.keller23.java.robotschedulerio.window.Console;
import org.json.simple.JSONObject;


public class Main {

    public static void main(String[] args){
        init();
        JSONObject obj = new JSONObject();
        if (args.length > 0) {
            checkArgs(args);
        }
        if (Refs.DEBUG) Refs.calledWith(args);
    }

    private static void init() {
        /*Console.init();
        Log.init();*/

        initOptions();
        Log.info(Refs.APPNAME + ": " + Refs.VERSION);
    }

    private static void initOptions() {
        Refs.OPTIONS.put(Refs.OPTIONABOUT,Refs.OPTIONABOUTCMD);
        Refs.OPTIONS.put(Refs.OPTIONREAD,Refs.OPTIONREADCMD);
        Refs.OPTIONS.put(Refs.OPTIONWRITE,Refs.OPTIONWRITECMD);
        Refs.OPTIONS.put(Refs.OPTIONTEST,Refs.OPTIONTESTCMD);
        Refs.OPTIONS.put(Refs.OPTIONOPTIONS,Refs.OPTIONABOUTCMD);
        Refs.OPTIONS.put(Refs.OPTIONCONSOLE,Refs.OPTIONCONSOLECMD);
        Log.initialize("Refs.OPTIONS initialized.");
    }

    private static void checkArgs(String[] _args) {
        System.out.println();
        /*int numArgs = _args.length;*/

        /*for (int i = 0; i < numArgs; i++) {*/ // TODO fix this to support multiple command line arguments, such as appending DEBUG/console modes
        if (_args[0].equals(Refs.OPTIONABOUTCMD)) {
            Log.argument("ABOUT");
            System.out.println("\n" + Refs.ABOUTVERSION + "\n");
        }
        else if (_args[0].equals(Refs.OPTIONTESTCMD)) {
            Log.argument("TEST");
            if (test()) Log.test("Woohoo! Good job, test().");
            else Log.severe("test() is false.");
            /*if (test()) com.keller23.java.robotschedulerio.utils.Log.console("Woohoo! Good job, test().");
            else com.keller23.java.robotschedulerio.utils.Log.console("Bad test(), bad!");*/
        }
        else if (_args[0].equals(Refs.OPTIONREADCMD)) {
            Log.argument("WRITE - (DIR) " + _args[1] + " - (FILE) " + _args[2]);
            IORead(_args[1], _args[2]);
        }
        else if (_args[0].equals(Refs.OPTIONWRITECMD)) {
            Log.argument("WRITE - (DIR) " + _args[1] + " - (FILE) " + _args[2]);
            IORead(_args[1], _args[2]);
        }
        else if (_args[0].equals(Refs.OPTIONOPTIONSCMD)) {
            Log.argument("OPTIONS");
            Refs.showOptions();
        }
        else if (_args[0].equals(Refs.OPTIONCONSOLECMD)) {
            // enable console window
            /*if (Refs.DEBUG) Console.getFrame().setVisible(true);
            else Log.console("Debugging not enabled.");*/
        }
        else {
            Refs.showOptions();
                /*break;*/
        }
        /*}*/
    }

    public static boolean IOWrite(String _dir, String _file, JSONObject _json) {
        Log.ioDebug("IOWrite has been called with (DIR):" + _dir + " / (FILE):" + _file + " & (JSON):" + _json, Refs.DEBUG);
        return IO.write(_dir, _file, _json);
    }

    public static boolean IORead(String _dir, String _file) {
        Log.ioDebug("IORead has been called with (DIR):" + _dir + " / (FILE):" + _file, Refs.DEBUG);
        return IO.read(_dir, _file);
    }

    public static boolean test() {
        /*Log.test("test() has been called.");*/
        return true;
    }
}

