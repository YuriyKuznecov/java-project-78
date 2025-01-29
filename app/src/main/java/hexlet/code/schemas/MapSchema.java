package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema<Map<?, ?>> {

    public final MapSchema sizeof(int a) {
        Predicate<Map<?, ?>> sizeOf = s -> Objects.isNull(s) || s.size() == a;
        addCheck("sizeOf", sizeOf);
        return this;
    }

    public final MapSchema shape(Map<String, ? extends BaseSchema> schemas) {
        Predicate<Map<?, ?>> shape = map ->
            schemas.entrySet()
                    .stream()
                    .allMatch(e -> e.getValue().isValid(map.get(e.getKey())));
        addCheck("shape", shape);
        return this;
    }


    @Override
    public BaseSchema<Map<?, ?>> required() {
        Predicate<Map<?, ?>> required = Objects::nonNull;
        addCheck("required", required);
            return this;
    }
}
