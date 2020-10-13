# Calculator

Calculator is a simple calculator that ignores mathematical precedence.

### Running
The project uses gradle as the build/dependency tool.

Use the gradle wrapper that is included with the project to build and run it:
```bash
$ ./gradlew run --args='/path/to/the/instructions_file.txt'
```

### Testing
There are unit tests written using the `kotlin.test` package, using JUnit as the
implementation of it.

Usage:
```bash
$ ./gradlew test'
```

### Example instructions
This project comes with a `example-instructions.txt` file with some example instructions!