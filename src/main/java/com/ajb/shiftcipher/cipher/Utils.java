package com.ajb.shiftcipher.cipher;

class Utils {

    static int getCharValue(char chr) {
        if (!Character.isAlphabetic(chr)) {
            return 0;
        }
        return chr - getDecimalOffset(chr);
    }

    static int getDecimalOffset(char chr) {
        return Character.isUpperCase(chr) ? 'A' : 'a';
    }
}
