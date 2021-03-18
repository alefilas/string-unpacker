package ru.alefilas.unpacker;

import java.util.Stack;

public class StringUnpacker {

    public static String unpack(String arg) {
        if (!checkString(arg)) {
            return "Not valid!";
        }

        char[] symbols = arg.toCharArray();

        Stack<Integer> numbersOfRepeats = new Stack<>();
        Stack<StringBuilder> builders = new Stack<>();
        builders.push(new StringBuilder());

        for (int i = 0; i < symbols.length; i++) {

            char symbol = symbols[i];

            if (Character.isDigit(symbol)) {
                //находим число челиком и добавляем в стек
                //переводим i в позицию за открывающей скобкой после найденного числа
                int endOfNumber = findEndOfNumber(symbols, i);
                numbersOfRepeats.push(Integer.parseInt(arg.substring(i, endOfNumber)));

                i += endOfNumber - i;

                builders.add(new StringBuilder());

            } else if (symbol == ']') {
                repeatString(builders, numbersOfRepeats.pop());
            } else {
                builders.peek().append(symbol);
            }
        }

        return builders.pop().toString();
    }

    private static int findEndOfNumber(char[] symbols, int i) {

        while (Character.isDigit(symbols[i])) {
            i++;
        }

        return i;
    }


    private static boolean checkString(String arg) {

        int count = 0;
        char[] symbols = arg.toCharArray();

        for (int i = 0; i < symbols.length; i++) {

            if (Character.isDigit(symbols[i])) {

                //если цифра стоит в конце - строка не валидна
                if (i == symbols.length - 1) {
                    return false;
                }

                if (Character.isDigit(symbols[i + 1])) {
                    //переходим к последней цифре числа
                    int endOfNumber = findEndOfNumber(symbols, i);
                    i += endOfNumber - i - 1;
                } else if (symbols[i + 1] != '[') {
                    return false;
                }

            } else if (symbols[i] == '[') {
                //если перед открывающей скобкой нет цифры
                if (i == 0 || !Character.isDigit(symbols[i - 1])) {
                    return false;
                }
                count++;

            } else if (symbols[i] == ']') {
                count--;
            }
        }

        //если число открывающих и закрывающих скобок не равно
        if (count != 0) {
            return false;
        }

        return arg.matches("[a-zA-Z\\d\\[\\]]*");
    }

    private static void repeatString(Stack<StringBuilder> builders, Integer numberOfRepeats) {
        String repeat = builders.pop()
                .toString()
                .repeat(numberOfRepeats);

        builders.peek().append(repeat);
    }
}
