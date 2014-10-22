package com.keller23.java.robotschedulerio.utils;

import com.keller23.java.robotschedulerio.lib.Refs;
import org.json.simple.JSONObject;

public class Log {

    public static void console(String _msg) {
        System.out.println(_msg);
    }

    public static void console(JSONObject _json){
        System.out.println(_json);
    }

    public static void console(String _msg,JSONObject _json){
        System.out.println(_msg + "\n" + _json);
    }

    public static void d(String s) {
        if (Refs.DEBUG) console(Refs.DEBUG_PREFIX + s);
    }
}
