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
    private Validator v;
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
        v = new Validator();
        schema = v.map();
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
        schema.sizeof(2).required();

        assertTrue(schema.isValid(MAP_2));
        assertFalse(schema.isValid(MAP_1));
        assertFalse(schema.isValid(null));
    }

    @Test
    void testShape() {
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().minLength(2).required());
        Map<String, Object> map1 = new HashMap<>();
        map1.put("firstName", "John");
        map1.put("lastName", "Smith");
        Map<String, Object> map2 = new HashMap<>();
        map2.put("userName", "John");
        map2.put("lastName", null);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("firstName", "Anna");
        map3.put("lastName", "B");

        schema.shape(schemas);
        assertTrue(schema.isValid(map1));
        assertFalse(schema.isValid(map2));
        assertFalse(schema.isValid(map3));
    }
}
