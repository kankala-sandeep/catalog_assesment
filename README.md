# Shamir Secret Sharing - Java Implementation

This project provides a Java implementation for solving the constant term (`c`) of a polynomial using Lagrange Interpolation based on the Shamir Secret Sharing algorithm.

## Prerequisites

Before running the code, make sure you have the following setup:

- Java Development Kit (JDK) 8 or later installed.
- The `org.json` library for JSON parsing.
- A `testcase.json` file with the required input format.

## Steps to Run

1. **Download Dependencies**:
   - Ensure that you have the `org.json` library for JSON parsing. You can add the `.jar` file to your project or use a build tool like Maven or Gradle.
   - If you are manually adding the JAR file, make sure it's in your project's classpath.

2. **Clone or Download the Repository**:
   - Clone or download this repository to your local machine.

3. **Place the `testcase.json` File**:
   - Place the `testcase.json` file in the root directory of your project (or specify the correct file path in the code).

4. **Compile the Code**:
   - Open a terminal and navigate to your project directory.
   - Compile the Java file using:
     ```bash
     javac -cp "path_to_json_jar/json-20230227.jar" ShamirSecretSharing.java
     ```

5. **Run the Program**:
   - After compiling, run the program:
     ```bash
     java -cp ".;path_to_json_jar/json-20230227.jar" ShamirSecretSharing
     ```

6. **Expected Output**:
   - The program will output the decoded points and the constant term of the polynomial.

## Example JSON File (`testcase.json`)

```json
{
  "keys": {
    "n": 5,
    "k": 3
  },
  "1": {
    "base": "10",
    "value": "15"
  },
  "2": {
    "base": "10",
    "value": "32"
  },
  "3": {
    "base": "10",
    "value": "52"
  }
}
