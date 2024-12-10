package hexlet.code.schemas;

import java.util.Objects;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema() {
        checks.add(o -> Objects.isNull(o) || o instanceof Integer);
    }

    public NumberSchema positive() {
        checks.add(o -> Objects.isNull(o) || (Integer) o > 0);
        return this;
    }

    public NumberSchema range(int a, int b) {
        checks.add(o -> Objects.isNull(o) || (Integer) o >= a && (Integer) o <= b);
        return this;
    }

}
