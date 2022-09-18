package brainfuck.java.lang.compiler;

import brainfuck.java.lang.code.Code;

public class BFCompiler {
    public void compile(Code sourceCode) {
        String code = sourceCode.inner;
        // loop over all chars in "code"
        int depth = 0;
        StringBuilder intermediateBuilder = new StringBuilder();
        for (char c : code.toCharArray()) {
            switch (c) {
                case '+':
                    break;
                case '-':
                    break;
                
                default:
                    break;
            }
        }
    }
}
