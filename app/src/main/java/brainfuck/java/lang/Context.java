package brainfuck.java.lang;

import java.util.HashMap;
import java.text.MessageFormat;

public class Context {

    private HashMap<Integer, Byte> mem;
    public final ContextManipulator manipulator;
    public final IO io;
    private Integer ptr;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CONTEXT:\n");
        sb.append("  pointer: " + ptr + "\n");
        sb.append("  tape:\n");
        sb.append("    ╷ index    bytes   ascii\n");
        sb.append("    ├───────────────────────\n");
        for (int i = 0; i < mem.size(); i++) {
            byte b = getMem(i);
            String asStr = io.getASCII(i);
            sb.append(MessageFormat.format("    │ [{0}]  ->  {1}  ->  ({2})\n", i, b, asStr));
        }
        return sb.toString();
    }

    public Byte getMem(Integer address) {
        Byte out = mem.get(address);
        return out != null ? out : (byte) 0;
    }

    public void setMem(Integer address, Byte value) {
        mem.put(address, value);
    }

    public Integer getPtr() {
        return ptr;
    }

    public void setPtr(Integer ptr) {
        this.ptr = ptr;
    }

    public Context() {
        mem = new HashMap<>();
        ptr = 0;
        manipulator = new ContextManipulator(this);
        io = new IO(this);
    }

}
