package com.ajb.shiftcipher.cipher;

public class Caesar extends ShiftCipher {

    public Caesar(int shift) {
        this.key = new int[]{shift};
    }
}
