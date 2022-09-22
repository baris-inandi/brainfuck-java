package brainfuck.java;

import brainfuck.java.lang.Brainfuck;
import brainfuck.java.lang.code.Code;

public class App {
    public static void main(String[] args) {
        Brainfuck bf = new Brainfuck();
        try {
            String filepath = args[0];
            System.out.println(filepath);
            Code code = new Code(filepath);
            bf.compiler.compile(code);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
