package brainfuck.java.lang.compiler.intermediate_generator;

import brainfuck.java.lang.code.Code;
import brainfuck.java.lang.compiler.intermediate_generator.intermediate_builder.IntermediateBuilder;

public class IntermediateGenerator {
    private static final String INTERMEDIATE_BOILERPLATE = """
            #include <stdio.h>
            int main()
            {
                int t[30000] = {0};
                int *p = t;
                // ir %s
                return 0;
            }""";

    public String generateIntermediate(Code sourceCode) {
        String code = sourceCode.inner;
        int depth = 0;
        int repSymbolCount = 1;
        char prevC = ' ';
        IntermediateBuilder ib = new IntermediateBuilder();
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            if (prevC == c
                    && (prevC == '+' ||
                            prevC == '-' ||
                            c == '<' ||
                            c == '>')) {
                repSymbolCount++;
                continue;
            }
            switch (c) {
                case '+':
                    ib.appendf("*p+=%d;", repSymbolCount);
                    break;
                case '-':
                    ib.appendf("*p-=%d;", repSymbolCount);
                    break;
                case '<':
                    ib.appendf("p+=%d;", repSymbolCount);
                    break;
                case '>':
                    ib.appendf("p-=%d;", repSymbolCount);
                    break;
                case '.':
                    ib.append("putc(*p, stdout);");
                    break;
                case ',':
                    ib.append("*p=getchar();");
                    break;
                case '[':
                    ib.append("while(*p){");
                    depth++;
                    break;
                case ']':
                    ib.append("}");
                    depth--;
                    break;
                default:
                    break;
            }
            repSymbolCount = 1;
            prevC = c;
        }
        if (depth > 0) {
            System.err.println("Syntax error: Unmatched [");
            System.exit(1);
        } else if (depth < 0) {
            System.err.println("Syntax error: Unmatched ]");
            System.exit(1);
        }
        return String.format(INTERMEDIATE_BOILERPLATE, ib.toString());
    }

}