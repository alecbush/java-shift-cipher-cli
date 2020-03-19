package com.ajb.shiftcipher.cipher;

import java.util.stream.IntStream;

public class Vigenere extends ShiftCipher {

    public Vigenere(String key) {
        this.key = key.toUpperCase().codePoints()
                .flatMap(cp -> IntStream.of(Character.isAlphabetic(cp) ? cp - 'A' : 0))
                .toArray();
    }
}
