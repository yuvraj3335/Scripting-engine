package com.example;

import org.graalvm.polyglot.PolyglotException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // JavaScript examples
            System.out.println("Running JavaScript examples...");
            Object jsResult = ScriptEngineUtil.runScript("js", "1 + 2");
            System.out.println("JavaScript: 1 + 2 = " + jsResult); // Expected: 3

            Object jsMath = ScriptEngineUtil.runScript("js", "Math.sqrt(16)");
            System.out.println("JavaScript: sqrt(16) = " + jsMath); // Expected: 4.0

            // JavaScript from file
            Object jsFileResult = ScriptEngineUtil.runScriptFromFile("js", "src/main/java/com/example/scripts/example.js");
            System.out.println("JavaScript from file: " + jsFileResult); // Expected: 25

            // Python examples
            System.out.println("\nRunning Python examples...");
            Object pyResult = ScriptEngineUtil.runScript("python", "1 + 2");
            System.out.println("Python: 1 + 2 = " + pyResult); // Expected: 3

            Object pyMath = ScriptEngineUtil.runScript("python", "import math\nmath.sqrt(16)");
            System.out.println("Python: sqrt(16) = " + pyMath); // Expected: 4.0

            // Python from file
            Object pyFileResult = ScriptEngineUtil.runScriptFromFile("python", "src/main/java/com/example/scripts/example.py");
            System.out.println("Python from file: " + pyFileResult); // Expected: 25
        } catch (PolyglotException e) {
            System.err.println("Script execution failed: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("File reading failed: " + e.getMessage());
        }
    }
}