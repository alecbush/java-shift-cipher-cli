# java-shift-cipher-cli
A Caesar and Vigenere cipher CLI tool for personal use. Built w/ [Picocli](https://picocli.info/).

Current version 0.1.0.
## Install
Use maven to clean the project.
```
mvn clean
```
Maven install will build a .jar file titled shiftcipher-0.1.0.jar in the target directory.
```
mvn install
```
## Usage
### Caesar - Encrypt
```
$ java -jar shiftcipher-0.1.0.jar "Hello, World!" -e -s 7
Olssv, Dvysk!
```
### Caesar - Decrypt
```
$ java -jar shiftcipher-0.1.0.jar "Olssv, Dvysk!" -d -s 7
Hello, World!
```
### Vigenere - Encrypt
```
$ java -jar shiftcipher-0.1.0.jar "Hello, World!" -e -k "secret"
Zincs, Pgvnu!
```
### Vigenere - Decrypt
```
$ java -jar shiftcipher-0.1.0.jar "Zincs, Pgvnu!" -d -k "secret"
Hello, World!
```