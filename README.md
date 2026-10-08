# Task Array — Java Core Project

## Structure

```
task-array/
├── pom.xml
├── src/main/java/com/task/
│   ├── entity/          — AbstractArray, IntegerArray
│   ├── exception/       — ArrayException
│   ├── factory/         — ArrayFactory, IntegerArrayFactory (Factory Method)
│   ├── builder/         — IntegerArrayBuilder (Builder)
│   ├── service/         — ArrayService, ArrayServiceImpl
│   ├── reader/          — DataReader, DataReaderImpl
│   ├── parser/          — ArrayParser, ArrayParserImpl
│   ├── validator/       — ArrayValidator, ArrayValidatorImpl
│   ├── creator/         — ArrayCreator, ArrayCreatorImpl
│   └── Runner.java      — Application entry point
├── src/main/resources/
│   ├── log4j2.xml       — Log4J2 configuration (console + file)
│   └── data/
│       └── array_data.txt — Input data (mix of valid and invalid lines)
└── src/test/java/com/task/
    ├── service/         — ArrayServiceImplTest
    ├── validator/       — ArrayValidatorImplTest
    ├── parser/          — ArrayParserImplTest
    ├── reader/          — DataReaderImplTest
    ├── factory/         — IntegerArrayFactoryTest
    ├── builder/         — IntegerArrayBuilderTest
    └── creator/         — ArrayCreatorImplTest
```

## Patterns

- **Factory Method**: `ArrayFactory` interface + `IntegerArrayFactory` implementation.
- **Builder**: `IntegerArrayBuilder` with fluent API (`data()`, `size()`, `fill()`, `build()`).

## Build & Run

```bash
mvn clean package
java -cp target/task-array-1.0-SNAPSHOT.jar com.task.Main``
