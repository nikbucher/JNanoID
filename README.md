# NanoId Java Implementation

This is a Java implementation of NanoID, a small, secure, URL-friendly, unique string ID generator.

## Introduction

NanoID is designed to generate unique and compact identifiers suitable for use in URLs, short links, and other contexts where a unique ID is required. This Java implementation provides a simple way to
generate NanoIDs.

## Usage

To generate a NanoID, you can use the `NanoId.random()` method:

```java
NanoId nanoId = NanoId.random();
System.out.println("Generated NanoID: " + nanoId.getIdString());
```

You can also specify a desired length for the NanoID:

```java
NanoId nanoId=NanoId.random(10); // Generates a NanoID of length 10
```

## Building and Running

To build the project, you can use Gradle:

```shell
./gradlew build
```

## Testing

This project includes unit tests for the NanoID generation. You can run the tests using:

```shell
./gradlew test
```

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
