package hexlet.code.formattersType;

import java.util.Map;

public class StylishFormatter {
    public static String formatStylish(Map<String, Map<String, Object>> inputMap) {
        StringBuilder result = new StringBuilder("{\n");

        for (var entry : inputMap.entrySet()) {
            String key = entry.getKey();
            Map<String, Object> values = entry.getValue();
            String status = String.valueOf(values.get("status"));

            String oldValue = stringify(values.get("value1"));
            String newValue = stringify(values.get("value2"));

            switch (status) {
                case "unchanged" -> result.append("    ")
                        .append(key).append(": ")
                        .append(oldValue)
                        .append("\n");

                case "changed" -> {
                    result.append("  - ")
                            .append(key).append(": ")
                            .append(oldValue)
                            .append("\n");

                    result.append("  + ")
                            .append(key)
                            .append(": ")
                            .append(newValue)
                            .append("\n");
                }
                case "deleted" -> result.append("  - ")
                        .append(key).append(": ")
                        .append(oldValue)
                        .append("\n");

                case "added" -> result.append("  + ")
                        .append(key)
                        .append(": ")
                        .append(newValue)
                        .append("\n");

                default -> throw new IllegalArgumentException("Unknown status: " + status);
            }
        }

        result.append("}");
        return result.toString();
    }

    private static String stringify(Object objValue) {
        return objValue == null ? "null" : objValue.toString();
    }
}
