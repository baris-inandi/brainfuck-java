package brainfuck.java.lang.compiler;

import brainfuck.java.lang.code.Code;
import brainfuck.java.lang.compiler.intermediate_generator.IntermediateGenerator;

public class BFCompiler {

    public void compile(Code sourceCode) {
        IntermediateGenerator ig = new IntermediateGenerator();
        System.out.println(ig.generateIntermediate(sourceCode));
    }

}
