package hexlet.code;

import hexlet.code.formattersType.Json;
import hexlet.code.formattersType.Plain;
import hexlet.code.formattersType.Stylish;

import java.util.List;
import java.util.Map;


public class Format {
    public static String formatDifference(List<Map<String, Object>> inputList, String format) throws Exception {
        return switch (format) {
            case "stylish" -> Stylish.formatStylish(inputList);
            case "json" -> Json.formatJson(inputList);
            case "plain" -> Plain.formatPlain(inputList);
            default -> throw new IllegalArgumentException("Unknown format: " + format);
        };
    }
}

