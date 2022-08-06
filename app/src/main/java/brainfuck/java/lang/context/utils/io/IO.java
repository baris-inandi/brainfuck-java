package brainfuck.java.lang.context.utils.io;

import java.nio.charset.StandardCharsets;

import brainfuck.java.lang.context.Context;

public class IO {
    Context ctx;
    public final LoopContext looper = new LoopContext();

    public String getASCII(Integer index) {
        byte b = ctx.getMem(index);
        byte[] ba = new byte[1];
        ba[0] = b;
        String asStr;
        try {
            asStr = new String(ba, StandardCharsets.US_ASCII);
        } catch (Exception e) {
            asStr = "";
        }
        return asStr;
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
