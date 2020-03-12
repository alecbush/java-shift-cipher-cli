package com.ajb.shiftcipher;

import com.ajb.shiftcipher.cipher.Caesar;
import com.ajb.shiftcipher.cipher.Vigenere;
import picocli.CommandLine.ArgGroup;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "Cipher", header = "Shift Cipher CLI")
public class CipherCommand implements Runnable {

    @Parameters(description = "Text to cipher.")
    private String text;

    @ArgGroup(exclusive = true, multiplicity = "1")
    private OperationOptions operation;

    private static class OperationOptions {
        @Option(names = {"-e", "--encode"}, description = "Encode text.")
        boolean encode;
        @Option(names = {"-d", "--decode"}, description = "Decode text.")
        boolean decode;
    }

    @ArgGroup(exclusive = true, multiplicity = "1")
    private KeyOptions keyOptions;

    private static class KeyOptions {
        @Option(names = {"-s", "--shift"}, description = "Shift text value.")
        Integer shift;
        @Option(names = {"-k", "--key"}, description = "Key value to apply to text.")
        String key;
    }

    public void run() {
        if (this.keyOptions.key != null) {
            Vigenere vigenere = new Vigenere(this.keyOptions.key);
            if (this.operation.encode) {
                System.out.println(vigenere.encode(this.text));
            }
            else if (this.operation.decode) {
                System.out.println(vigenere.decode(this.text));
            }
        }
        else if (this.keyOptions.shift != null) {
            Caesar caesar = new Caesar(this.keyOptions.shift);
            if (this.operation.encode) {
                System.out.println(caesar.encode(this.text));
            }
            else if (this.operation.decode) {
                System.out.println(caesar.decode(this.text));
            }
        }
    }
}
