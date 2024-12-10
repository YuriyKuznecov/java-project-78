package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class BaseSchema<T> {
    List<Predicate<Object>> checks = new ArrayList<>();

    public boolean isValid(Object o) {
        return checks.stream()
                .allMatch(i -> i.test(o));
    }

    public BaseSchema<T> required() {
        checks.add(Objects::nonNull);
        return this;
    }
}
