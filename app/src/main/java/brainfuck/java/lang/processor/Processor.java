package brainfuck.java.lang.processor;

import brainfuck.java.lang.code.Code;
import brainfuck.java.lang.context.Context;
import brainfuck.java.lang.Mode;

public class Processor {

    Mode mode;

    public Processor(Mode mode) {
        this.mode = mode;
    }

    public Context exec(Code code) {
        Context out = eval(code.inner, new Context(mode));
        System.out.println();
        return out;
    }

    public Context eval(String code, Context ctx) {
        boolean looping = false;
        for (char c : code.toCharArray()) {
            if (c == '[') {
                ctx.io.looper.start();
                looping = true;
            }
            if (looping) {
                System.out.print(c);
                ctx.io.looper.append(c);
            }
            if (c == ']') {
                if (looping) {
                    String expr = ctx.io.looper.end();
                    if (expr == null) {
                        continue;
                    }
                    while (ctx.current() != 0) {
                        eval(expr, ctx);
                    }
                    looping = false;
                    System.out.println();
                } else {
                    System.out.println("Syntax error: Unmatched ']'");
                    System.exit(1);
                }
            }
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
                case ',':
                    ctx.io.readPutToCurrent();
                    break;
                default:
                    continue;
            }
        }
        if (!ctx.io.looper.isFlat()) {
            System.out.println("Syntax error: Unmatched '['");
            System.exit(1);
        }
        return ctx;
    }

}
