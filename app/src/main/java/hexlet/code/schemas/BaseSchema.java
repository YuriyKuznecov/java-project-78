package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class BaseSchema {
    List<Predicate<Object>> checks = new ArrayList<>();

    protected  boolean isValid(Object o) {
        return checks.stream()
                .allMatch(i -> i.test(o));
    }

    protected BaseSchema required() {
        checks.add(Objects::nonNull);
        return this;
    }
}
