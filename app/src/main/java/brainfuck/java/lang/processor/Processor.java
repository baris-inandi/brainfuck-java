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

    public Context eval(String code, Context context) {
        Context ctx = context;
        int depth = 0;
        StringBuilder loopExprBuilder = new StringBuilder();
        for (char c : code.toCharArray()) {
            if (depth > 0) {
                loopExprBuilder.append(c);
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
                case '[':
                    depth++;
                    break;
                case ']':
                    depth--;
                    if (depth == 0) {
                        String expr = loopExprBuilder.toString();
                        System.out.println(expr);
                        loopExprBuilder = new StringBuilder();
                        while (ctx.continueLoop()) {
                            ctx = eval(expr, ctx);
                        }
                    }
                    break;
                default:
                    continue;
            }
            System.out.println(depth);
        }
        // if (depth > 0) {
        // System.out.println("Syntax error: Unmatched '['");
        // System.exit(1);
        // } else if (depth < 0) {
        // System.out.println("Syntax error: Unmatched ']'");
        // System.exit(1);
        // }
        return ctx;
    }

}
