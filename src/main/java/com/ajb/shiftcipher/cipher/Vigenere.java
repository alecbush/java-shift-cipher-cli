package com.ajb.shiftcipher.cipher;

public class Vigenere extends Caesar {

    private char[] key;
    private int keyPosition;

    public Vigenere(String key) {
        this.key = key.toCharArray();
    }

    @Override
    protected int getShiftValue() {
        char keyChar = this.key[this.keyPosition % this.key.length];
        this.keyPosition++;
        return Utils.getCharValue(keyChar);
    }

    @Override
    protected void reset() {
        this.keyPosition = 0;
        super.reset();
    }
}
