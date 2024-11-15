package hexlet.code.schemas;

import org.apache.commons.lang3.StringUtils;
import java.util.Objects;

public class StringSchema extends BaseSchema {

    public StringSchema() {
        checks.add(o -> Objects.isNull(o) || o instanceof String);
    }

    @Override
    public StringSchema required() {
        checks.add(o -> !StringUtils.isEmpty((String) o));
        return this;
    }

    public StringSchema minLength(int a) {
        checks.add(o -> Objects.isNull(o) || ((String) o).length() >= a);
        return this;
    }

    public StringSchema contains(String str) {
        checks.add(o -> Objects.isNull(o) || ((String) o).contains(str));
        return this;
    }

}
