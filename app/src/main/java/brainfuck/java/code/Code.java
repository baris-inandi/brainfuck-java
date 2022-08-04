package brainfuck.java.code;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;

public class Code {
    static final String VALID_CHARS = "[<+,.->]";

    public String inner;

    private String removeComments(String s) {
        return s
                .codePoints()
                .map(i -> VALID_CHARS.contains(String.valueOf((char) i)) ? i : 0)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }

    public Code(String filepath) {
        try {
            Path pathToFile = FileSystems.getDefault().getPath(filepath);
            String content = Files.readString(pathToFile, StandardCharsets.UTF_8);
            inner = removeComments(content);
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
