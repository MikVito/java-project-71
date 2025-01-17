package hexlet.code.formattersType;

import java.util.Map;


public class PlainFormatter {
    public static String formatPlain(Map<String, Map<String, Object>> inputMap) {
        StringBuilder result = new StringBuilder();

        for (var entry : inputMap.entrySet()) {
            String key = entry.getKey();
            Map<String, Object> diffEntry = entry.getValue();
            String status = diffEntry.get("status").toString();

            switch (status) {
                case "changed" -> result.append("Property '")
                        .append(key)
                        .append("' was updated. From ")
                        .append(stringify(diffEntry.get("value1")))
                        .append(" to ")
                        .append(stringify(diffEntry.get("value2")))
                        .append("\n");

                case "deleted" -> result.append("Property '")
                        .append(key)
                        .append("' was removed")
                        .append("\n");

                case "added" -> result.append("Property '")
                        .append(key)
                        .append("' was added with value: ")
                        .append(stringify(diffEntry.get("value2")))
                        .append("\n");

                default -> {
                }
            }
        }
        return result.toString().trim();
    }

    private static String stringify(Object value) {
        if (value == null) {
            return "null";
        }
        if (value instanceof String) {
            return "'" + value + "'";
        }

        if (value instanceof Map<?, ?> || value instanceof Iterable<?>) {
            return "[complex value]";
        }

        return value.toString();
    }
}
