package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema<String> {

    @Override
    public StringSchema required() {
        Predicate<String> required = s -> (s != null) && !s.isEmpty();
        addCheck("required", required);
        return this;
    }

    public StringSchema minLength(int a) {
        Predicate<String> minLength = s -> s == null || s.length() >= a;
        addCheck("minLength", minLength);
        return this;
    }

    public StringSchema contains(String str) {
        Predicate<String> contains = s -> s == null || s.contains(str);
        addCheck("contains", contains);
        return this;
    }

}
