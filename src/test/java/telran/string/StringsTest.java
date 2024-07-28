package telran.string;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringsTest {

    @Test
    void testValidVariableNames() {
        assertTrue("variable".matches(Strings.javaVariable()));
        assertTrue("_variable".matches(Strings.javaVariable()));
        assertTrue("$variable".matches(Strings.javaVariable()));
        assertTrue("variable1".matches(Strings.javaVariable()));
        assertTrue("_variable1".matches(Strings.javaVariable()));
        assertTrue("$variable1".matches(Strings.javaVariable()));
        assertTrue("v".matches(Strings.javaVariable()));
        assertTrue("v1".matches(Strings.javaVariable()));
        assertTrue("v1$".matches(Strings.javaVariable()));
    }

    @Test
    void testInvalidVariableNames() {
        assertFalse("1variable".matches(Strings.javaVariable())); 
        assertFalse("variable-name".matches(Strings.javaVariable())); 
        assertFalse("variable name".matches(Strings.javaVariable())); 
        assertFalse("variable.name".matches(Strings.javaVariable())); 
        assertFalse("variableName!".matches(Strings.javaVariable()));
        assertFalse("int".matches(Strings.javaVariable())); 
        assertFalse("float".matches(Strings.javaVariable())); 
        assertFalse("for".matches(Strings.javaVariable())); 
        assertFalse("goto".matches(Strings.javaVariable())); 
        assertFalse("const".matches(Strings.javaVariable())); 
        assertFalse("".matches(Strings.javaVariable())); 
        assertFalse("_".matches(Strings.javaVariable())); 
    }
}
