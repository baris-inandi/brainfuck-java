package brainfuck.java;

import brainfuck.java.lang.Brainfuck;
import brainfuck.java.lang.code.Code;
import brainfuck.java.lang.context.Context;

public class App {
    public static void main(String[] args) {
        Brainfuck bf = new Brainfuck();
        Context x = bf.processor.exec(new Code(args[0]));
        System.out.println(x);
    }
}
