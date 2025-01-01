package hexlet.code.formattersType;

import java.util.List;
import java.util.Map;

public class StylishFormatter {
    public static String formatStylish(List<Map<String, Object>> inputList) {
        StringBuilder resultStylish = new StringBuilder("{\n");

        for (var diffEntry : inputList) {
            var key = (String) diffEntry.get("key");
            var value = (String) diffEntry.get("value");
            var value1 = (String) diffEntry.get("value1");
            var value2 = (String) diffEntry.get("value2");
            var status = (String) diffEntry.get("status");


            switch (status) {
                case ("unchanged"):
                    resultStylish.append(formatStylish("    ", key, value));
                    break;

                case ("changed"):
                    resultStylish.append(formatStylish("- ", key, value1));
                    resultStylish.append(formatStylish("+ ", key, value2));
                    break;

                case ("removed"):
                    resultStylish.append(formatStylish("- ", key, value));
                    break;

                case ("added"):
                    resultStylish.append(formatStylish("+ ", key, value));
                    break;

                default:
                    throw new IllegalArgumentException("Unknown status: " + status);
            }
        }
        resultStylish.append("}");
        return resultStylish.toString();
    }

    public static String formatStylish(String sign, String key, Object value) {
        return "  "
                + sign
                + " "
                + key
                + ": "
                + value
                + "\n";
    }
}
