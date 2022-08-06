package brainfuck.java.lang.context.utils.io;

public class LoopContext {

    int depth = 0;
    String buffer = "";

    public void start() {
        depth++;
    }

    public String getBuffer() {
        return buffer;
    }

    public int getDepth() {
        return depth;
    }

    public void append(char c) {
        buffer += c;
    }

    public boolean isFlat() {
        return depth == 0;
    }

    public String getStrippedBuffer() {
        return buffer.substring(1, buffer.length() - 1);
    }

    public String end() {
        depth--;
        String out = null;
        if (isFlat()) {
            out = getStrippedBuffer();
            clear();
        }
        return out;
    }

    public void clear() {
        buffer = "";
        depth = 0;
    }

    LoopContext() {
    }
}
