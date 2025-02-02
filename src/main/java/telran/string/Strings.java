package telran.string;

public class Strings {
    static final String keyWords[] = { "abstract", "assert", "boolean",
                "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "enum", "extends", "false",
                "final", "finally", "float", "for", "goto", "if", "implements",
                "import", "instanceof", "int", "interface", "long", "native",
                "new", "null", "package", "private", "protected", "public",
                "return", "short", "static", "strictfp", "super", "switch",
                "synchronized", "this", "throw", "throws", "transient", "true",
                "try", "void", "volatile", "while" };
    public static String firstName() {
        // regex for strings startin with
        // capital letter and rest as a
        // lower case letters
        // minimal length is 5 letters
        return "[A-Z][a-z]{4,}";
    }

    public static String javaVariable() {
        // regular expression for testing synthax
        // of Java variable names
        return "((?!_$)[a-zA-Z$_][\\w$]*)";
    }
    public static String number0_300() {
       
        return "[1-9]\\d?|[1-2]\\d\\d|300|0";
    }
    public static String ipV4Octet(){
        
        return "([0-1]?\\d{1,2}|2([0-4]\\d|5[0-5]))";
    }
    public static String ipV4Address(){
        String octetExpr = ipV4Octet();
        return String.format("%s(\\.%s){3}", octetExpr, octetExpr);
    }
    public static String stringWithJavaNames(String names) {
       String [] tokens = names.split("\\s+");
       int i = getJavaNameIndex(tokens, -1);
       String res = "";
       if (i >= 0) {
         res = tokens[i];
       }
       while((i = getJavaNameIndex(tokens, i)) > 0) {
            res += " " + tokens[i];
       }
       
        return res;
    }

    private static int getJavaNameIndex(String[] tokens, int i) {
        i++;
        while(i < tokens.length && !isJavaName(tokens[i])) {
            i++;
        }
        return i < tokens.length ? i : -1;
    }

    private static boolean isJavaName(String string) {
        return string.matches(javaVariable()) && java.util.Arrays.binarySearch(keyWords, string) < 0;
    }


    public static boolean isArithmeticExpression(String expr) {
        return isArithmeticSymbol(expr) && isBrakeOpen(expr) && isValidSymbol(expr);
    }

    public static boolean isArithmeticSymbol(String symbol) {
        String pattern = "[\\d()+*/-]+$";
        return symbol.matches(pattern);
    }

    public static boolean isBrakeOpen(String symbol) {
        String [] parts = symbol.split("");
        int i = 0;
        int counter = 0;
        while (i < parts.length ) {
            if (parts[i].equals("(")) {
                counter ++; 
            } else if (parts[i].equals(")")) {
                counter --;
            }
            i++;
        }
        return  counter == 0 ? true : false;
    }


    public static boolean isValidSymbol(String symbol) {
        String pattern = "^(?!.*[+\\-*/]{2}).*$";
        return symbol.matches(pattern);
    }
}
