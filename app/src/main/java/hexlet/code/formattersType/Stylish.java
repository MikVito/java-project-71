package hexlet.code.formattersType;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String formatStylish(List<Map<String, Object>> inputList) {
        StringBuilder resultStylish = new StringBuilder("{\n");

        for (var diffList : inputList) {
            var key = String.valueOf(diffList.get("key"));
            var value = diffList.get("value");

            switch (String.valueOf(diffList.get("type"))) {
                case ("not changed"):
                    resultStylish.append(formatStylish(" ", key, value));
                    break;

                case ("changed"):
                    var value1 = diffList.get("value1");
                    var value2 = diffList.get("value2");
                    resultStylish.append(formatStylish("-", key, value1));
                    resultStylish.append(formatStylish("+", key, value2));
                    break;

                case ("deleted"):
                    resultStylish.append(formatStylish("-", key, value));
                    break;

                case ("added"):
                    resultStylish.append(formatStylish("+", key, value));
                    break;

                default:
                    break;
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
