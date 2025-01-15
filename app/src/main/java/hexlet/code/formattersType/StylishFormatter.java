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
                    resultStylish.append(formatLine("  ", key, value));
                    break;

                case "changed":
                    // Гарантируем, что оба значения выводятся
                    resultStylish.append(formatLine("- ", key, oldValue));
                    resultStylish.append(formatLine("+ ", key, newValue));
                    break;

                case "removed":
                    resultStylish.append(formatLine("- ", key, value));
                    break;

                case "added":
                    resultStylish.append(formatLine("+ ", key, value));
                    break;

                default:
                    throw new IllegalArgumentException("Unknown status: " + status);
            }
        }

        resultStylish.append("}");
        return resultStylish.toString();
    }

    public static String formatLine(String sign, String key, Object value) {
        return "  "
                + sign
                + key
                + ": "
                + (value == null ? "null" : value)
                + "\n";
    }
}