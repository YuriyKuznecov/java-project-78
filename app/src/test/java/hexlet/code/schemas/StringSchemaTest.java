package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class StringSchemaTest {
    private final String text = "what does the fox say";
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
    }

    @Test
    void testRequired() {
        schema.required();

        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));
    }

    @Test
    void testMinLength() {
        int number = 3;
        schema.minLength(number);

        assertTrue(schema.isValid(text));
        assertTrue(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid("hx"));
    }

    @Test
    void testContains() {
        schema.contains("the").required();

        assertTrue(schema.isValid(text));
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid("hex"));
    }
}
