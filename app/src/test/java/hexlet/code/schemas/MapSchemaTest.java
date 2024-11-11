package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MapSchemaTest {

    private MapSchema schema;
    private static final int MAP_SIZE = 2;
    private static final Map<String, Object> MAP_1 = Map.of(
            "key1", "value1"
    );
    private static final Map<String, Object> MAP_2 = Map.of(
            "key1", "value1",
            "key2", "value2"
    );

    @BeforeEach
    public void beforeEach() {
        schema = new Validator().map();
    }

    @Test
    void testIsValid() {
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(MAP_1));
        assertTrue(schema.isValid(new HashMap<>()));
        assertFalse(schema.isValid(MAP_SIZE));
    }

    @Test
    void testRequired() {
        schema.required();
        assertFalse(schema.isValid(null));
    }

    @Test
    void testSizeof() {
        schema.sizeof(2);

        assertTrue(schema.isValid(MAP_2));
        assertFalse(schema.isValid(MAP_1));
        assertTrue(schema.isValid(null));
    }
}
