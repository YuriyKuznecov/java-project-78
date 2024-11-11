package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class StringSchemaTest {
    private final String text = "what does the fox say";
    private final int number = 3;
    private StringSchema schema;

    @BeforeEach
    public void beforeEach() {
        schema = new Validator().string();
    }


    @Test
    void testIsValid() {

        assertTrue(schema.isValid(text));
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));
        assertFalse(schema.isValid(number));
    }

    @Test
    void testRequired() {
        schema.required();

        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));
    }

    @Test
    void testMinLength() {
        schema.minLength(number);

        assertTrue(schema.isValid(text));
        assertTrue(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid("hx"));
    }

    @Test
    void testContains() {
        schema.contains("the");

        assertTrue(schema.isValid(text));
        assertTrue(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid("hex"));
    }
}
