package ru.alefilas;

import ru.alefilas.unpacker.StringUnpacker;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Error! No string to unpack");
        } else {
            System.out.println(StringUnpacker.unpack(args[0]));
        }
    }
}
