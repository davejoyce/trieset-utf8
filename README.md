# UTF-8 TrieSET

TrieSET implementation for UTF-8 subset of Unicode characters.

This library provides an adaptation of the data structure described in
[Algorithms, 4th Edition](https://algs4.cs.princeton.edu/home/), by Robert
Sedgewick and Kevin Wayne.

## Requirements

This library requires [Java 8+](https://jdk.java.net/8/).

## How to use

This library is published to the [Maven Central Repository](
https://search.maven.org/). To use it in your project, do one of the following:

### Maven

Add this as a dependency to your `pom.xml` file

```xml
<dependency>
    <groupId>${project.groupId}</groupId>
    <artifactId>${project.artifactId}</artifactId>
    <version>${project.version}</version>
</dependency>
```

### Gradle

Add this as a dependency to your `build.gradle` file

```gradle
compile '${project.groupId}:${project.artifactId}:${project.version}'
```

## License

Use of this library is governed by a BSD-style license that can be found in the
LICENSE file or at [https://opensource.org/licenses/BSD-2-Clause](
https://opensource.org/licenses/BSD-2-Clause).
