package telran.string;

public class Strings {

    public static String[] keywords = {
            "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue",
            "default", "do", "double", "else", "enum", "extends", "false", "final", "finally", "float", "for", "goto",
            "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "null", "package",
            "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized",
            "this", "throw", "throws", "transient", "true", "try", "void", "volatile", "while", "enum", "goto", "const"
    };


    public static String javaVariable() {
        return String.format(
            "^(?!(%s)$)(?!_$)[A-Za-z$_][0-9A-Za-z$_]*$", String.join("|", keywords)
        );
    }
}
