package com.keller23.java.robotschedulerio.utils;

import com.keller23.java.robotschedulerio.config.Config;
import com.keller23.java.robotschedulerio.lib.Refs;
import org.json.simple.JSONObject;

public class Debug {

    public static void output (String _msg) {
        console(_msg);
    }

    public static void output (JSONObject _json) {
        console(_json);
    }

    public static void output (String _msg,JSONObject _json) {
        console(_msg,_json);
    }

    public static void console(String _msg) {
        System.out.println(_msg);
    }

    public static void console(JSONObject _json){
        System.out.println(_json);
    }

    public static void console(String _msg,JSONObject _json){
        System.out.println(_msg + "\n" + _json);
    }

    public static void calledWith(String[] _args) {
        JSONObject json = new JSONObject();
        if (_args.length > 0) {
            Debug.d("_args > 0");
            for (int i = 0; i > _args.length; i++) {
                Debug.d("calledWith(): i = " + i);
                json.put("arg[" + i + "]", _args[i]);
            }
            output("\n" + "Parameters called with:",json);
        }
        else output("\n" + "No parameters found.");
    }

    public static void d(String s) {
        if (Refs.DEBUG) output(Refs.DEBUG_PREFIX + s);
    }
}
