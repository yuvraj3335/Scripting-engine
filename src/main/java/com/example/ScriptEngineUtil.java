package com.example;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.PolyglotException;
import org.graalvm.polyglot.Value;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScriptEngineUtil {

    /**
     * Executes a script in the specified language and returns the result as a Java object.
     *
     * @param language the language of the script ("js" for JavaScript, "python" for Python)
     * @param script   the raw script content as a string
     * @return the result of the script execution as a Java object
     * @throws PolyglotException if there is an error executing the script
     * @throws IllegalArgumentException if the language is not supported
     */
    public static Object runScript(String language, String script) throws PolyglotException {
        if (!language.equals("js") && !language.equals("python")) {
            throw new IllegalArgumentException("Unsupported language: " + language + ". Use 'js' or 'python'.");
        }
        try (Context context = Context.newBuilder(language).allowAllAccess(true).build()) {
            Value result = context.eval(language, script);
            return result.as(Object.class);
        }
    }

    /**
     * Executes a script from a file in the specified language and returns the result as a Java object.
     *
     * @param language the language of the script ("js" for JavaScript, "python" for Python)
     * @param filePath the path to the script file
     * @return the result of the script execution as a Java object
     * @throws PolyglotException if there is an error executing the script
     * @throws IOException if there is an error reading the file
     * @throws IllegalArgumentException if the language is not supported
     */
    public static Object runScriptFromFile(String language, String filePath) throws PolyglotException, IOException {
        String script = new String(Files.readAllBytes(Paths.get(filePath)));
        return runScript(language, script);
    }
}