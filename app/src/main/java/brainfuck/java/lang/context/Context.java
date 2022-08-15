package brainfuck.java.lang.context;

import java.util.HashMap;
import java.text.MessageFormat;
import brainfuck.java.lang.Mode;
import brainfuck.java.lang.context.utils.io.IO;
import brainfuck.java.lang.context.utils.manipulator.ContextManipulator;

public class Context {

    private HashMap<Integer, Integer> mem;
    public final ContextManipulator manipulator;
    public final IO io;
    public final Mode mode;
    private Integer ptr;

    public boolean isCompiled() {
        return mode == Mode.COMPILE;
    }

    public boolean isInterpreted() {
        return mode == Mode.INTERPRET;
    }

    public boolean continueLoop() {
        return current() != 0;
    }

    public Integer current() {
        return getMem(ptr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CONTEXT:\n");
        sb.append("  pointer: " + ptr + "\n");
        sb.append("  tape:\n");
        sb.append("    ╷ index    bytes   ascii\n");
        sb.append("    ├───────────────────────\n");
        for (int i = 0; i < mem.size(); i++) {
            Integer b = getMem(i);
            String asStr = io.getASCII(i);
            sb.append(MessageFormat.format("    │ [{0}]  ->  {1}  ->  ({2})\n", i, b, asStr));
        }
        return sb.toString();
    }

    public Integer getMem(Integer address) {
        Integer out = mem.get(address);
        return out != null ? out : 0;
    }

    public void setMem(Integer address, Integer value) {
        int v = value;
        if (v > 255) {
            v -= 256;
        } else if (v < 0) {
            v += 256;
        }
        mem.put(address, v);
    }

    public Integer getPtr() {
        return ptr;
    }

    public void setPtr(Integer ptr) {
        this.ptr = ptr;
    }

    public Context(Mode mode) {
        this.mode = mode;
        mem = new HashMap<>();
        ptr = 0;
        manipulator = new ContextManipulator(this);
        io = new IO(this);
    }

}
