package hexlet.code.formattersType;

import java.util.List;
import java.util.Map;

public class PlainFormatter {
    public static String formatPlain(List<Map<String, Object>> inputList) {
        StringBuilder resultString = new StringBuilder();

        for (Map<String, Object> diffEntry : inputList) {
            var key = String.valueOf(diffEntry.get("key"));
            var value = diffEntry.get("value");
            var oldValue = diffEntry.get("value1");
            var newValue = diffEntry.get("value2");
            var status = String.valueOf(diffEntry.get("status"));

            switch (status) {
                case "unchanged":

                    break;

                case "changed":
                    resultString.append("Property '")
                            .append(key)
                            .append("' was updated. From ")
                            .append(stringify(oldValue))
                            .append(" to ")
                            .append(stringify(newValue))
                            .append("\n");
                    break;

                case "removed":
                    resultString.append("Property '")
                            .append(key)
                            .append("' was removed")
                            .append("\n");
                    break;

                case "added":
                    resultString.append("Property '")
                            .append(key)
                            .append("' was added with value: ")
                            .append(stringify(value))
                            .append("\n");
                    break;

                default:
                    throw new IllegalArgumentException("Unknown status: " + status);
            }
        }
        return resultString.toString().trim();
    }

    public static Object stringify(Object valueObj) {
        if (valueObj == null || valueObj.equals("null")) {
            return "null";
        } else if (valueObj instanceof String) {
            return "'" + valueObj + "'";
        } else if (valueObj instanceof Map<?, ?> || valueObj instanceof List<?>) {
            return "[complex value]";
        }
        return valueObj.toString();
    }
}
