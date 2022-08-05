package brainfuck.java.lang.context;

import java.nio.charset.StandardCharsets;

public class IO {
    Context ctx;

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
        System.out.print(getCurrentASCII());
        return getCurrentASCII();
    }

    public void readPutToCurrent() {
        System.out.println("get input here");
    }

    public IO(Context ctx) {
        this.ctx = ctx;
    }
}
