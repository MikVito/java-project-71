package hexlet.code;

import java.util.List;
import java.util.Map;

public class Format {
    public static String formatDifference(List<Map<String, Object>> inputList) {
        StringBuilder result = new StringBuilder("{\n");

        inputList.forEach(diff -> {
            var key = (String) diff.get("key");
            var status = (String) diff.get("status");
            var value1 = diff.get("value1");
            var value2 = diff.get("value2");

            switch (status) {
                case "not changed" -> result.append("    ")
                        .append(key)
                        .append(": ")
                        .append(value1)
                        .append("\n");

                case "changed" -> {
                    result.append("  - ")
                            .append(key).append(": ")
                            .append(value1)
                            .append("\n");

                    result.append("  + ")
                            .append(key).append(": ")
                            .append(value1)
                            .append("\n");
                }

                case "deleted" -> result.append("  - ")
                        .append(key)
                        .append(": ")
                        .append(value1)
                        .append("\n");

                case "added" -> result.append("  + ")
                        .append(key)
                        .append(": ")
                        .append(value2)
                        .append("\n");

                default -> throw new IllegalArgumentException("Error: " + status);
            }
        });

        result.append("}");
        return result.toString();
    }
}

