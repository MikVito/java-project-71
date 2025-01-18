### Hexlet tests and linter status:
[![Actions Status](https://github.com/MikVito/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/MikVito/java-project-71/actions)

### Maintainability Badge
[![Maintainability](https://api.codeclimate.com/v1/badges/43bd129f21f7d51adf83/maintainability)](https://codeclimate.com/github/MikVito/java-project-71/maintainability)

### Test Coverage Badge
[![Test Coverage](https://api.codeclimate.com/v1/badges/43bd129f21f7d51adf83/test_coverage)](https://codeclimate.com/github/MikVito/java-project-71/test_coverage)

# 📂 DIFFERENCE CALCULATOR

A console application for comparing three files in YAML, YML, or JSON format.
It detects the differences between files and generates an output highlighting those discrepancies.

### 📝 Features

**✔️ Supports JSON, YAML, and YML file formats**
**✔️ Detects changes between files and presents them in a structured format**
**✔️ Three output formats available:**
 - 📌 Stylish (default) – structured tree format
 - 📌 Plain – simple text format
 - 📌 JSON – formatted JSON output

### 🔧 Example Commands

Compare two JSON files using stylish format:
```sh
./build/install/app/bin/app src/main/resources/file1.json src/main/resources/file2.json
```

Compare two YML files using plain format:
```sh
./build/install/app/bin/app src/main/resources/file1.yml src/main/resources/file2.yml -f plain
```

Compare two files and output JSON:
```sh
./build/install/app/bin/app src/main/resources/file1.json src/main/resources/file2.json -f json
```

## 🎥 Demo: Program in Action

Click on a recording to view the functionality in action.

**📌 Displaying Help Information**

[![asciicast](https://asciinema.org/a/698202.svg)](https://asciinema.org/a/698202) 

**📌 Comparing Two JSON Files (Stylish Format)**  

[![asciicast](https://asciinema.org/a/698260.svg)](https://asciinema.org/a/698260)

**📌 Comparing Two JSON Files (Plain Format)** 

[![asciicast](https://asciinema.org/a/698261.svg)](https://asciinema.org/a/698261)

**📌 Comparing Two JSON Files (Plain Format)** 

[![asciicast](https://asciinema.org/a/698278.svg)](https://asciinema.org/a/698278)

**📌 Comparing Two YML Files (Plain Format)** 

[![asciicast](https://asciinema.org/a/698280.svg)](https://asciinema.org/a/698280)

**📌 Comparing Two JSON Files (Specifying Json Output)**

[![asciicast](https://asciinema.org/a/698857.svg)](https://asciinema.org/a/698857)

### 📌 Requirements
 - Java 17+
 - Gradle 8+
 - Make (for simplified execution)