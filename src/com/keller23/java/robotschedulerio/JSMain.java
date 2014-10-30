package com.keller23.java.robotschedulerio;

import sun.org.mozilla.javascript.internal.*;

import java.lang.reflect.Member;
import java.lang.reflect.Method;

public class JSMain extends ScriptableObject {
    @Override
    public String getClassName() {
        return getClass().getName();
    }

    /**
     * JSMain.class.main() - An attempt at borrowing some code from StackOverflow that makes specific
     *                       Java methods available from Javascript. This is to be directly called
     *                       from Javascript.
     *
     * @param _args - [0]: name of the function you want to access from Javascript.
     * @throws Exception
     *
     * Original code was borrowed from the accepted answer by Jawad to question at:
     * http://stackoverflow.com/questions/3441947/how-do-i-call-a-method-of-a-java-instance-from-javascript
     */
    public static void main(String _args[]) throws Exception {
        /*String _functionName = _args[0];*/
        String _functionName = "JSTest";

        Context.enter();
        try {
            //-- Create a top-level scope in which we will execute a simple test script to test if things are working or not.
            Scriptable scriptExecutionScope = new ImporterTopLevel(Context.getCurrentContext());

            //-- Create an instance of the class whose instance method is to be made available in javascript as a global function.
            Scriptable myScriptable = new JSMain();

            //-- This is not strictly required but it is a good practice to set the parent of all scriptable objects
            //-- except in case of a top-level scriptable.
            myScriptable.setParentScope(scriptExecutionScope);

            //-- Get a reference to the instance method this is to be made available in javascript as a global function.
            Method scriptableInstanceMethod = JSMain.class.getMethod("JSTest");

            //-- Choose a name to be used for invoking the above instance method from within javascript.
            /*String javascriptFunctionName = "JSTest";*/
            /*String javascriptFunctionName = _functionName;*/

            //-- Create the FunctionObject that binds the above function name to the instance method.
            FunctionObject scriptableInstanceMethodBoundJavascriptFunction = new MyFunctionObject("JSTest", scriptableInstanceMethod, myScriptable);

            //-- Make it accessible within the scriptExecutionScope.
            scriptExecutionScope.put(_functionName, scriptExecutionScope, scriptableInstanceMethodBoundJavascriptFunction);

            /**
             * The rest of this try{} block contains sample javascript code that runs the above code.
             * It will output the results using System.out.
             */
            //-- Define a simple test script to test if things are working or not.
            /*String testScript = "function simpleJavascriptFunction() {" +
                    "  try {" +
                    "    result = JSTest();" +
                    "    java.lang.System.out.println(result);" +
                    "  }" +
                    "  catch(e) {" +
                    "    throw e;" +
                    "  }" +
                    "}" +
                    "simpleJavascriptFunction();";*/

            //-- Compile the test script.
            /*Script compiledScript = Context.getCurrentContext().compileString(testScript, "My Test Script", 1, null);*/

            //-- Execute the test script.
            /*compiledScript.exec(Context.getCurrentContext(), scriptExecutionScope);*/
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Context.exit();
        }
    }

    /**
     * JSTest() - Simple testing method to return a boolean.
     * @return test boolean
     */
    public static boolean JSTest() {
        return true;
    }
}

class MyFunctionObject extends FunctionObject {

    public MyFunctionObject(String name, Member methodOrConstructor, Scriptable parentScope) {
        super(name, methodOrConstructor, parentScope);
    }

    @Override
    public Object call(Context cx, Scriptable scope, Scriptable thisObj, Object[] args) {
        return super.call(cx, scope, getParentScope(), args);
        /*return super.call(cx, scope, thisObj, args);*/
    }
}
