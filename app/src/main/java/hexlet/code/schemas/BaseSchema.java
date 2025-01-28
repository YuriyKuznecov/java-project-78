package hexlet.code.schemas;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class BaseSchema<T> {
    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();

    protected final void addCheck(String name, Predicate<T> check) {
        checks.put(name, check);
    }

    protected boolean isValid(T o) {
        return checks.values().stream()
                .allMatch(i -> i.test(o));
    }

    protected BaseSchema<T> required() {
        Predicate<T> required = Objects::nonNull;
        addCheck("required", required);
        return this;
    }
}
