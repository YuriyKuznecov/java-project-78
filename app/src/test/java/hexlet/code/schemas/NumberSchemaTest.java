package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class NumberSchemaTest {

    private NumberSchema schema;
    private final int positive = 10;
    private final int negative = -5;
    private final int zero = 0;

    @BeforeEach
    public void beforeEach() {
        schema = new Validator().number();
    }

    @Test
    void testIsValid() {
        assertTrue(schema.isValid(positive));
        assertTrue(schema.isValid(negative));
        assertTrue(schema.isValid(zero));
        assertTrue(schema.isValid(null));
        assertFalse(schema.isValid(""));
    }

    @Test
    void testRequired() {
        schema.required();

        assertFalse(schema.isValid(null));
    }

    @Test
    void positive() {
        schema.positive();

        assertTrue(schema.isValid(positive));
        assertFalse(schema.isValid(negative));
        assertFalse(schema.isValid(zero));
    }

    @Test
    void range() {
        int min = 5;
        int max = 10;
        schema.range(min, max);

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(positive));
        assertFalse(schema.isValid(zero));
    }
}
