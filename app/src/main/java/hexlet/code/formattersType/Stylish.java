package hexlet.code.formattersType;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String formatStylish(List<Map<String, Object>> inputList) {
        StringBuilder resultString = new StringBuilder("{\n");

        inputList.forEach(diff -> {
            var key = (String) diff.get("key");
            var status = (String) diff.get("status");
            var value1 = diff.get("value1");
            var value2 = diff.get("value2");

            switch (status) {
                case "not changed" -> resultString.append("    ")
                        .append(": ")
                        .append(value1)
                        .append("\n");

                case "changed" -> {
                    resultString.append("  - ")
                            .append(key)
                            .append(": ")
                            .append(value1)
                            .append("\n");

                    resultString.append("  + ")
                            .append(key)
                            .append(": ")
                            .append(value2)
                            .append("\n");
                }

                case "deleted" -> resultString.append("  - ")
                        .append(key)
                        .append(": ")
                        .append(value1)
                        .append("\n");

                case "added" -> resultString.append("  + ")
                        .append(key)
                        .append(": ")
                        .append(value2)
                        .append("\n");

                default -> throw new IllegalArgumentException("Error: " + status);
            }
        });
        resultString.append("}");
        return resultString.toString();
    }
}
