package brainfuck.java.interpreter;

import brainfuck.java.code.Code;
import brainfuck.java.lang.Context;

public class Interpreter {

    Context ctx;

    public Interpreter() {
        ctx = new Context();
    }

    public void exec(Code code) {
        System.out.println();
        for (char c : code.inner.toCharArray()) {
            switch (c) {
                case '+':
                    ctx.manipulator.increment();
                    break;
                case '-':
                    ctx.manipulator.decrement();
                    break;
                case '<':
                    ctx.manipulator.moveLeft();
                    break;
                case '>':
                    ctx.manipulator.moveRight();
                    break;
                case '.':
                    ctx.io.printCurrentASCII();
                    break;
                default:
                    continue;
            }
        }
        System.out.println();
        System.out.println();
        System.out.println(ctx);
    }
}
