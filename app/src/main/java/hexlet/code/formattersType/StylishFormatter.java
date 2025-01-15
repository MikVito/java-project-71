package hexlet.code.formattersType;

import java.util.List;
import java.util.Map;

public class StylishFormatter {
    public static String formatLine(List<Map<String, Object>> inputList) {
        StringBuilder resultStylish = new StringBuilder("{\n");

        for (Map<String, Object> diffEntry : inputList) {
            var key = (String) diffEntry.get("key");
            var value = diffEntry.get("value");
            var oldValue = diffEntry.get("value1");
            var newValue = diffEntry.get("value2");
            var status = (String) diffEntry.get("status");


            switch (status) {
                case "unchanged":
                    if (value != null) {
                        resultStylish.append(formatLine("  ", key, value));
                    }
                    break;

                case "changed":
                    if (oldValue != null) {
                        resultStylish.append(formatLine("- ", key, oldValue));
                    }
                    if (newValue != null) {
                        resultStylish.append(formatLine("+ ", key, newValue));
                    }
                    break;

                case "removed":
                    if (value != null) {
                        resultStylish.append(formatLine("- ", key, value));
                    }
                    break;

                case "added":
                    if (value != null) {
                        resultStylish.append(formatLine("+ ", key, value));
                    }
                    break;

                default:
                    throw new IllegalArgumentException("Unknown status: " + status);
            }
        }
        resultStylish.append("}");
        return resultStylish.toString();
    }

    private static String stringify(Object value) {
        if (value == null) {
            return "null";
        }
        if (value instanceof String) {
            return value.toString();
        }
        if (value instanceof List || value instanceof Map) {
            return value.toString().replace("=", ": ").replace(",", ", ");
        }
        return value.toString();
    }

    public static String formatLine(String sign, String key, Object value) {
        return "  "
                + sign
                + key
                + ": "
                + stringify(value)
                + "\n";
    }
}
