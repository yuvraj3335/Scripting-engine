# Scripting Engine Utility

## Overview

This Java project provides a utility (`ScriptEngineUtil`) for dynamically executing **JavaScript** and **Python** scripts within the JVM using **GraalVM's Polyglot API**. Scripts can be executed as raw strings or from files, and their results are returned as native Java objects.

It runs entirely within the JVM and **does not require external processes** like `ProcessBuilder`.

---

## ✅ What It Does

- **Dynamic Script Execution** – Runs JavaScript and Python scripts at runtime.
- **Library Support** – Supports standard libraries (e.g., `Math` in JavaScript, `math` in Python).
- **Return Values** – Converts results to native Java types (`Integer`, `Double`, etc.).
- **File Support** – Executes scripts from files.
- **Thread-Safety** – Each script uses an isolated context for safe concurrent execution.

---

## 📁 Project Structure

scripting-engine/
├── pom.xml
└── src/
├── main/
│ ├── java/
│ │ └── com/example/
│ │ ├── ScriptEngineUtil.java
│ │ ├── Main.java
│ │ └── scripts/
│ │ ├── example.js
│ │ └── example.py
└── test/
└── java/
└── com/example/
└── ScriptEngineUtilTest.java



---

## ⚙️ Logic Explanation

### GraalVM Polyglot API

- Uses `Context` to evaluate code in `js` or `python`.
- **Methods**:
  - `Object runScript(String language, String script)`
  - `Object runScriptFromFile(String language, String filePath)`
- Automatically maps result types using `result.as(Object.class)`.

---

## 🧵 Thread-Safety

Each script uses a **new context**, ensuring thread-safe execution.

---

## 📚 Library Support

- **JavaScript**: Supports `Math.sqrt(16)`
- **Python**: Supports `import math` and more (ensure `PYTHONPATH` is set)

---

## 🚀 Setup & Run Instructions

### Prerequisites

- **JDK 21** (GraalVM recommended)
- **Maven**
- **IDE/Text Editor**

### Setup Steps

1. **Clone or Create Project**  
   Set up folder structure as above.

2. **Install GraalVM JDK 21**
   - Download from: https://www.graalvm.org/downloads/
   - Set environment variables:

     ```cmd
     set JAVA_HOME=C:\path\to\graalvm-jdk-21
     set PATH=%JAVA_HOME%\bin;%PATH%
     ```

   - Verify:

     ```
     java -version
     ```

3. **Build the Project**

   ```bash
   cd scripting-engine
   mvn clean install
   
4. **RUN the Project**
   mvn exec:java -Dexec.mainClass="com.example.Main" or through IDE

5. **Running Tests**
   mvn test

### Usage 
// Simple JS expression
Object result = ScriptEngineUtil.runScript("js", "1 + 2");
System.out.println(result); // 3

// Using Math library
Object jsMath = ScriptEngineUtil.runScript("js", "Math.sqrt(16)");
Object pyMath = ScriptEngineUtil.runScript("python", "import math\nmath.sqrt(16)");

// From File
Object fileResult = ScriptEngineUtil.runScriptFromFile("js", "src/main/java/com/example/scripts/example.js");





