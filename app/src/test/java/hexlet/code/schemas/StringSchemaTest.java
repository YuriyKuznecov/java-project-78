package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringSchemaTest {
    private final String text = "what does the fox say";

    @Test
    void testIsValid() {
        StringSchema schema1 = new Validator().string();

        assertTrue(schema1.isValid(text));
        assertTrue(schema1.isValid(""));
        assertTrue(schema1.isValid(null));
    }

    @Test
    void testRequired() {
        StringSchema schema2 = new Validator().string().required();

        assertFalse(schema2.isValid(""));
        assertFalse(schema2.isValid(null));
    }

    @Test
    void testMinLength() {
        int minLength = 3;
        StringSchema schema3 = new Validator().string().minLength(minLength);

        assertTrue(schema3.isValid(text));
        assertTrue(schema3.isValid(null));
        assertFalse(schema3.isValid(""));
        assertFalse(schema3.isValid("hx"));
    }

    @Test
    void testContains() {
        StringSchema schema4 = new Validator().string().contains("the");

        assertTrue(schema4.isValid(text));
        assertTrue(schema4.isValid(null));
        assertFalse(schema4.isValid(""));
        assertFalse(schema4.isValid("hex"));
    }

}