package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public class MapSchema extends BaseSchema {

    public MapSchema() {
        checks.add(o -> Objects.isNull(o) || o instanceof Map<?, ?>);
    }

    public void sizeof(int a) {
        checks.add(item -> Objects.isNull(item) || ((Map<?, ?>) item).size() == a);
    }

}
