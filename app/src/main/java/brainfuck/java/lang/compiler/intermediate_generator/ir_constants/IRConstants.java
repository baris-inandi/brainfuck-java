package brainfuck.java.lang.compiler.intermediate_generator.ir_constants;

public class IRConstants {
    public static final "[":               "while(*p){",
	public static final "]":               "};",
	public static final "<":               "--p;",
	public static final ">":               "++p;",
	public static final "+":               "++*p;",
	public static final "-":               "--*p;",
	public static final ".":               "putc(*p, stdout);",
	public static final ",":               "*p=getchar();",
	public static final "LEFT_ANGLE_REP":  "p-=%d;",
	public static final "RIGHT_ANGLE_REP": "p+=%d;",
	public static final "PLUS_REP":        "*p+=%d;",
	public static final "MINUS_REP":       "*p-=%d;",
}