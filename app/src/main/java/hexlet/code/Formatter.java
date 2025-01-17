package hexlet.code;

import hexlet.code.formattersType.JsonFormatter;
import hexlet.code.formattersType.PlainFormatter;
import hexlet.code.formattersType.StylishFormatter;

import java.util.Map;


public class Formatter {
    public static String formatDifference(Map<String, Map<String, Object>> inputMap, String format) throws Exception {
        return switch (format) {
            case "stylish" -> StylishFormatter.formatStylish(inputMap);
            case "json" -> JsonFormatter.formatJson(inputMap);
            case "plain" -> PlainFormatter.formatPlain(inputMap);
            default -> throw new IllegalArgumentException("Unknown format: " + format);
        };
    }
}

