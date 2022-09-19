package brainfuck.java.lang.compiler.intermediate_generator.intermediate_builder;

public class IntermediateBuilder {
    StringBuilder inner;

    private static final String BOILERPLATE = """
            #include <stdio.h>
            int main()
            {
                int t[30000] = {0};
                int *p = t;
                // ir %s
                return 0;
            }""";

    public String toString() {
        return String.format(BOILERPLATE, "\n" + inner.toString());
    }

    public void append(String str) {
        inner.append(str);
    }

    public void appendf(String str, Object... args) {
        inner.append(String.format(str, args));
    }

    public IntermediateBuilder() {
        inner = new StringBuilder();
    }
}