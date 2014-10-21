package com.keller23.java.robotschedulerio;

import com.keller23.java.robotschedulerio.lib.Refs;
import com.keller23.java.robotschedulerio.utils.Debug;
import com.keller23.java.robotschedulerio.utils.IO;
import org.json.simple.JSONObject;

import java.applet.Applet;

public class Main extends Applet{

    public static void main(String[] args){
        initOptions();
        JSONObject obj = new JSONObject();
        if (args.length > 0) {
            System.out.println();
            if (args[0].equals(Refs.OPTIONABOUTCMD)) {
                System.out.println("\n" + Refs.ABOUTVERSION + "\n");
            }
            else if (args[0].equals(Refs.OPTIONTESTCMD)) {
                Debug.d("Arguments = OPTIONTESTCMD");
                if (test()) Debug.output("Woohoo! Good job, test().");
                else Debug.output("Bad test(), bad!");
            }
            else if (args[0].equals(Refs.OPTIONREADCMD)) {
                Debug.d("Arguments = OPTIONREADCMD");
                IORead(args[1],args[2]);
            }
            else if (args[0].equals(Refs.OPTIONWRITECMD)) {
                Debug.d("Arguments = OPTIONWRITECMD");
                IORead(args[1],args[2]);
            }
            else if (args[0].equals(Refs.OPTIONOPTIONSCMD)) {
                Refs.showOptions();
            }
            else {
                Refs.showOptions();
            }
        }
        if (Refs.DEBUG) Debug.calledWith(args);
    }

    public static boolean IOWrite(String _dir, String _file, JSONObject _json) {
        return IO.write(_dir, _file, _json);
    }

    public static boolean IORead(String _dir, String _file) {
        return IO.read(_dir, _file);
    }

    public static boolean test() {
        return true;
    }

    private static void initOptions() {
        Refs.OPTIONS.put(Refs.OPTIONABOUT,Refs.OPTIONABOUTCMD);
        Refs.OPTIONS.put(Refs.OPTIONREAD,Refs.OPTIONREADCMD);
        Refs.OPTIONS.put(Refs.OPTIONWRITE,Refs.OPTIONWRITECMD);
        Refs.OPTIONS.put(Refs.OPTIONTEST,Refs.OPTIONTESTCMD);
        Refs.OPTIONS.put(Refs.OPTIONOPTIONS,Refs.OPTIONABOUTCMD);
    }
}

