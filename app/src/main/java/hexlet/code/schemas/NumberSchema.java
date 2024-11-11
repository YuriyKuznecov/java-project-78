package hexlet.code.schemas;

import java.util.Objects;

public class NumberSchema extends BaseSchema {

    public NumberSchema() {
        checks.add(o -> Objects.isNull(o) || o instanceof Integer);
    }

    public void positive() {
        checks.add(o -> Objects.isNull(o) || (Integer) o > 0);
    }

    public void range(int a, int b) {
        checks.add(o -> Objects.isNull(o) || (Integer) o >= a && (Integer) o <= b);
    }

}
