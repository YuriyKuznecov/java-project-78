package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema() {
        checks.add(o -> Objects.isNull(o) || o instanceof Map<?, ?>);
    }

    public MapSchema sizeof(int a) {
        checks.add(item -> Objects.isNull(item) || ((Map<?, ?>) item).size() == a);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<?>> schemas) {
        checks.add(mapItem -> Objects.isNull(mapItem)
                || schemas.entrySet().stream().allMatch(check -> {
                    Object value = ((Map<?, ?>) mapItem).get(check.getKey());
                    return check.getValue().isValid(value);
                }));
        return this;
    }

}
