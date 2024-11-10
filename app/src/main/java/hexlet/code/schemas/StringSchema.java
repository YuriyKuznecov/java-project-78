package hexlet.code.schemas;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class StringSchema {
    List<Predicate<Object>> checks = new ArrayList<>();
    public StringSchema required() {
        checks.add(item -> !StringUtils.isEmpty((String) item));
        return this;
    }

    public StringSchema minLength(int a) {
        checks.add(o -> Objects.isNull(o) || ((String)o).length() >= a);
        return this;
    }

    public StringSchema contains(String str) {
        checks.add(o -> Objects.isNull(o) || ((String)o).contains(str));
        return this;
    }


    public  boolean isValid(Object o) {
        return checks.stream()
                .allMatch(i -> i.test(o));
    }

}
