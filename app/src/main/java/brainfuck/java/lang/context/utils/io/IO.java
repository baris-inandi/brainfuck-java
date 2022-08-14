package brainfuck.java.lang.context.utils.io;

import brainfuck.java.lang.context.Context;

public class IO {
    Context ctx;
    public final LoopContext looper = new LoopContext();

    public String getASCII(Integer index) {
        return Character.toString(
                (char) ((int) ctx.getMem(index)));
    }

    public String getCurrentASCII() {
        return getASCII(ctx.getPtr());
    }

    public String printCurrentASCII() {
        String x = getCurrentASCII();
        System.out.print(x);
        return x;
    }

    public void readPutToCurrent() {
        System.out.println("get input here");
    }

    public IO(Context ctx) {
        this.ctx = ctx;
    }
}
