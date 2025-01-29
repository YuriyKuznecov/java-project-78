package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public class NumberSchema extends BaseSchema<Integer> {

    public final NumberSchema positive() {
        Predicate<Integer> positive = s -> s == null || s > 0;
        addCheck("positive", positive);
        return this;
    }

    public final NumberSchema range(int a, int b) {
        Predicate<Integer> range = s -> s  == null || s >= a && s <= b;
        addCheck("range", range);
        return this;
    }

    @Override
    public final BaseSchema<Integer> required() {
        Predicate<Integer> required = Objects::nonNull;
        addCheck("required", required);
        return this;
    }
}
