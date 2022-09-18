package brainfuck.java;

import brainfuck.java.lang.Brainfuck;
import brainfuck.java.lang.code.Code;

public class App {
    public static void main(String[] args) {
        Brainfuck bf = new Brainfuck();
        Code code = new Code("./examples/hello.bf");
        bf.compiler.compile(code);
    }
}
