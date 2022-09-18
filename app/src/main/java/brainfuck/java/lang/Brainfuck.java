package brainfuck.java.lang;

import brainfuck.java.lang.context.Context;
import brainfuck.java.lang.processor.Processor;

public class Brainfuck {
    public final Context ctx;
    public final Processor processor;

    public Brainfuck() {
        ctx = new Context();
        processor = new Processor();
    }
}
