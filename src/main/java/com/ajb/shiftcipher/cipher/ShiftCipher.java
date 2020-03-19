package com.ajb.shiftcipher.cipher;

public abstract class ShiftCipher {

    protected int[] key;
    private int keyPosition;

    public String encode(String text) {
        return cipherText(text, false);
    }

    public String decode(String text) {
        return cipherText(text, true);
    }

    private String cipherText(String text, boolean negateShift) {
        this.keyPosition = 0;
        return text.codePoints().mapToObj(cp -> cipherCodePoint(cp, negateShift))
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }

    private int cipherCodePoint(int cp, boolean negateShift) {
        if (!Character.isAlphabetic(cp)) {
            return cp;
        }
        int offset = Character.isUpperCase(cp) ? 'A' : 'a';
        int value = cp - offset;
        int shiftValue = this.key[this.keyPosition % this.key.length];
        this.keyPosition++;
        if (negateShift) {
            shiftValue = -shiftValue;
        }
        return (Math.floorMod(value + shiftValue, 26) + offset);
    }
}
