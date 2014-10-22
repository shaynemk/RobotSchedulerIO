package com.keller23.java.robotschedulerio.utils.log;

import com.keller23.java.robotschedulerio.lib.Refs;
import com.keller23.java.robotschedulerio.window.NormalPop;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {
    // Borrowing Taylor Tomlin's Log

    private static Logger logger = Logger.getLogger(Refs.APPNAME);
    private static Handler handler = new LogHandler();

    public static void init() {
        logger.setUseParentHandlers(false);
        logger.addHandler(handler);
        if (Refs.DEBUG) {
            log(Level.WARNING, Refs.DEVELOP_WARN);
            /*Collection.develop = true;*/
        }

    }

    private static void log(Level logLevel, Object object) {
        logger.log(logLevel, object.toString());

        if (logLevel == Level.SEVERE) {
        }
    }

    public static void severe(Object object) {
        log(Level.SEVERE, object.toString());
        if (Refs.ERROR) {
            NormalPop.appear("ERROR: SEVERE", object.toString());
        }
    }

    public static void debug(Object object) {

        if (Refs.DEBUG) {
            log(Level.INFO, "[DEBUG] " + object.toString());
        }
    }

    public static void warning(Object object) {

        log(Level.WARNING, object.toString());
        if (Refs.ERROR) {
            NormalPop.appear("ERROR: WARNING", object.toString());
        }
    }

    public static void info(Object object) {

        log(Level.INFO, object.toString());
    }

    public static void config(Object object) {

        log(Level.CONFIG, object.toString());
    }

    public static void fine(Object object) {

        log(Level.FINE, object.toString());
    }

    public static void finer(Object object) {

        log(Level.FINER, object.toString());
    }

    public static void finest(Object object) {

        log(Level.FINEST, object.toString());
    }

    public static void io(Object object) {

        log(Level.INFO, "[IO] " + object.toString());
    }
    public static void ioDebug(Object object, boolean _debug) {

        if (Refs.DEBUG) log(Level.INFO, "[DEBUG][IO] " + object.toString());
    }

    public static void popup(Object object) {

        log(Level.INFO, object.toString());
        if (Refs.ERROR) {
            NormalPop.appear("INFO", object.toString());
        }
    }

    public static void db(Object object) {
        if (Refs.DEBUG) {
            log(Level.INFO, "[DEBUG][DB] " + object.toString());
        }
    }

    public static void argument(Object object) {

        log(Level.INFO, "[DEBUG][ARGS]Argument: '" + object.toString() + "'");
    }

    public static void initialize(Object object) {

        if (Refs.DEBUG) log(Level.INFO, "[DEBUG][INIT] " + object.toString());
    }

    public static void test(Object object) {

        if (Refs.DEBUG) log(Level.INFO, "[DEBUG][TEST] " + object.toString());
    }
}
