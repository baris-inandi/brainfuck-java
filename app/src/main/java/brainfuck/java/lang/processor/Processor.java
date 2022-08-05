package brainfuck.java.lang.processor;

import brainfuck.java.lang.code.Code;
import brainfuck.java.lang.context.Context;

public class Processor {

    Context ctx;

    public Processor(Context ctx) {
        this.ctx = ctx;
    }

    public void exec(Code code) {
        System.out.println();
        if (code.inner.equals("")) {
            return;
        }
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
                case ',':
                    ctx.io.readPutToCurrent();
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
