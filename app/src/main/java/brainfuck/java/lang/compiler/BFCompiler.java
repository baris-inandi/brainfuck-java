package brainfuck.java.lang.compiler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import brainfuck.java.lang.code.Code;
import brainfuck.java.lang.compiler.intermediate_generator.IntermediateGenerator;

public class BFCompiler {

    public void compile(Code sourceCode) {
        IntermediateGenerator ig = new IntermediateGenerator(sourceCode);
        String ir = ig.generate();
        try {
            Path tempFile = Files.createTempFile("baris-inandi__brainfuck-java__ir-", ".c");
            Files.write(tempFile, ir.getBytes());
            Path currentRelativePath = Paths.get("");
            Path wd = Paths.get(currentRelativePath.toAbsolutePath().toString(), "a.out");
            String wdStr = wd.toString();
            String cmd = String.format("gcc -Ofast -o %s %s", wdStr, tempFile);
            System.out.println(cmd);
            Runtime.getRuntime().exec(cmd);
        } catch (IOException c) {
            System.out.println("Compilation failed: " + c.getMessage());
        }
    }

}
