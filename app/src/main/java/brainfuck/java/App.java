package brainfuck.java;

import brainfuck.java.code.Code;
import brainfuck.java.interpreter.Interpreter;

public class App {
    public static void main(String[] args) {
        Code code = new Code("code.bf");
        Interpreter interpreter = new Interpreter();
        interpreter.exec(code);
    }
}
