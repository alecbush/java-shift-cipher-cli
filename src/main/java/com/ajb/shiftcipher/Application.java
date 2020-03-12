package com.ajb.shiftcipher;

import picocli.CommandLine;

public class Application {

    public static void main(String[] args) {
        CommandLine cmd = new CommandLine(new CipherCommand());
        cmd.execute(args);
    }
}
