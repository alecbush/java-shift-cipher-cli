package com.ajb.shiftcipher.cipher;

public class Caesar {

    private int shift;
    private boolean negateShift;

    Caesar() {}

    public Caesar(int shift) {
        this.shift = shift;
    }

    public String encode(String text) {
        return cipherText(text);
    }

    public String decode(String text) {
        this.negateShift = true;
        return cipherText(text);
    }

    private String cipherText(String text) {
        char[] textCharArray = text.toCharArray();
        for (int index=0; index < textCharArray.length; index++) {
            textCharArray[index] = cipherChar(textCharArray[index]);
        }
        reset();
        return new String(textCharArray);
    }

    private char cipherChar(char chr) {
        if (!Character.isAlphabetic(chr)) {
            return chr;
        }
        int value = Utils.getCharValue(chr);
        int offset = Utils.getDecimalOffset(chr);
        int shiftValue = calculateShift();
        return (char) (Math.floorMod(value + shiftValue, 26) + offset);
    }

    private int calculateShift() {
        int shiftValue = getShiftValue();
        return this.negateShift ? -shiftValue : shiftValue;
    }

    protected int getShiftValue() {
        return this.shift;
    }

    protected void reset() {
        this.negateShift = false;
    }
}
