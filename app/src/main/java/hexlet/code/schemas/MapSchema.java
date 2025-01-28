package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema sizeof(int a) {
        Predicate<Map<?, ?>> sizeOf = s -> Objects.isNull(s) || s.size() == a;
        addCheck("sizeOf", sizeOf);
        return this;
    }

    public MapSchema shape(Map<String, ? extends BaseSchema> schemas) {
        Predicate<Map<?, ?>> shape = map ->
            schemas.entrySet()
                    .stream()
                    .allMatch(e -> e.getValue().isValid(map.get(e.getKey())));
        addCheck("shape", shape);
        return this;
    }


}
