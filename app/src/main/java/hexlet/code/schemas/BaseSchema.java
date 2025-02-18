package hexlet.code.schemas;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();

    protected final void addCheck(String name, Predicate<T> check) {
        checks.put(name, check);
    }

    public final boolean isValid(T o) {
        return checks.values().stream()
                .allMatch(i -> i.test(o));
    }


    public abstract BaseSchema<T> required();
}
