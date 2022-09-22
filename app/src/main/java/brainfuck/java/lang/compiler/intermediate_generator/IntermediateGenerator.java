package brainfuck.java.lang.compiler.intermediate_generator;

import brainfuck.java.lang.code.Code;
import brainfuck.java.lang.compiler.intermediate_generator.intermediate_builder.IntermediateBuilder;

public class IntermediateGenerator {
    public final Code sourceCode;

    public String generate() {
        String code = sourceCode.inner;
        int depth = 0;
        IntermediateBuilder ib = new IntermediateBuilder();
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            switch (c) {
                case '+':
                    ib.append("++*p;");
                    break;
                case '-':
                    ib.append("--*p;");
                    break;
                case '<':
                    ib.append("--p;");
                    break;
                case '>':
                    ib.append("++p;");
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
        }
        if (depth > 0) {
            System.err.println("Syntax error: Unmatched [");
            System.exit(1);
        } else if (depth < 0) {
            System.err.println("Syntax error: Unmatched ]");
            System.exit(1);
        }
        return ib.toString();
    }

    public IntermediateGenerator(Code code) {
        sourceCode = code;
    }
}