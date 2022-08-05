package brainfuck.java;

import brainfuck.java.lang.Brainfuck;
import brainfuck.java.lang.Mode;
import brainfuck.java.lang.code.Code;

public class App {
    public static void main(String[] args) {
        Brainfuck bf = new Brainfuck(Mode.COMPILE);
        bf.processor.exec(new Code("code.bf"));
    }
}
