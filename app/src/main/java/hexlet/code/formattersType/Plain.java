package hexlet.code.formattersType;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String formatPlain(List<Map<String, Object>> inputList) {
        StringBuilder resultString = new StringBuilder();

        inputList.forEach(diff -> {
            var key = (String) diff.get("key");
            var status = (String) diff.get("status");
            var value1 = diff.get("value1");
            var value2 = diff.get("value2");

            switch (status) {
                case "not change" -> {

                }
                case "changed" -> resultString.append("Property'")
                        .append(key)
                        .append("' was updated. From ")
                        .append(stringify(value1))
                        .append(" to ")
                        .append(stringify(value2))
                        .append("\n");

                case "deleted" -> resultString.append("Property'")
                        .append(key)
                        .append("' was removed")
                        .append("\n");

                case "added" -> resultString.append("Property'")
                        .append(key)
                        .append("'was added with value: ")
                        .append(stringify(value2))
                        .append("\n");

                default -> throw new IllegalArgumentException("Unknown status: " + status);
            }
        });
        return resultString.toString().trim();
    }

    public static Object stringify(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof String) {
            return "'" + value + "'";
        }
        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        }
        return value.toString();
    }
}
