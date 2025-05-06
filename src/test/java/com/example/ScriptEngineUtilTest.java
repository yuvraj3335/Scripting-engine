package com.example;

import org.graalvm.polyglot.PolyglotException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScriptEngineUtilTest {

    @Test
    public void testJavaScriptSimpleAddition() {
        Object result = ScriptEngineUtil.runScript("js", "1 + 2");
        assertEquals(3, result);
    }

    @Test
    public void testPythonSimpleAddition() {
        Object result = ScriptEngineUtil.runScript("python", "1 + 2");
        assertEquals(3, result);
    }

    @Test
    public void testJavaScriptMathLibrary() {
        Object result = ScriptEngineUtil.runScript("js", "Math.sqrt(16)");
        assertEquals(4.0, result);
    }

    @Test
    public void testPythonMathLibrary() {
        Object result = ScriptEngineUtil.runScript("python", "import math\nmath.sqrt(16)");
        assertEquals(4.0, result);
    }

    @Test
    public void testUnsupportedLanguage() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ScriptEngineUtil.runScript("ruby", "1 + 2");
        });
        assertEquals("Unsupported language: ruby. Use 'js' or 'python'.", exception.getMessage());
    }
}