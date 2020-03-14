# java-shift-cipher-cli
A Caesar and Vigenere cipher CLI tool for personal use. Built w/ [Picocli](https://picocli.info/).

Current version 0.1.0.
## Requirements
* Java 8
* Maven 3
* Picocli
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
```
Shift Cipher CLI
Usage: Cipher (-e | -d) (-s=<shift> | -k=<key>) <text>
      <text>            Text to cipher.
  -d, --decode          Decode text.
  -e, --encode          Encode text.
  -k, --key=<key>       String value to apply multiple character shifts.
  -s, --shift=<shift>   Integer value to shift character values.
```

The [Caesar cipher](https://en.wikipedia.org/wiki/Caesar_cipher) uses the -s integer value that shifts the alphabetical characters of the text. For example, a shift value of 1 turns 'A' into 'B'. 

The [Vigenère cipher](https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher) uses the -k string value that transforms the key's characters into an integer array with their appropriate shift value. For example, "shh" becomes [18, 7, 7]. Only alphabetical characters are converted to shift values. All others return 0, which is equivalent to 'A'.

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