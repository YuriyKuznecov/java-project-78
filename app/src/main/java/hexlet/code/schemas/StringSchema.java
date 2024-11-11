package hexlet.code.schemas;

import org.apache.commons.lang3.StringUtils;
import java.util.Objects;

public class StringSchema extends BaseSchema {

    public StringSchema() {
        checks.add(o -> Objects.isNull(o) || o instanceof String);
    }

    @Override
    public void required() {
        checks.add(o -> !StringUtils.isEmpty((String) o));
    }

    public void minLength(int a) {
        checks.add(o -> Objects.isNull(o) || ((String) o).length() >= a);
    }

    public void contains(String str) {
        checks.add(o -> Objects.isNull(o) || ((String) o).contains(str));
    }

}
