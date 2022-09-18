package brainfuck.java.lang;

import brainfuck.java.lang.context.Context;
import brainfuck.java.lang.compiler.BFCompiler;

public class Brainfuck {
    // TODO: the context will be useful when implementing an interpreter.
    // The compiler doesn't need a context.j
    public final Context ctx;
    public final BFCompiler compiler;

    public Brainfuck() {
        ctx = new Context();
        compiler = new BFCompiler();
    }
}
