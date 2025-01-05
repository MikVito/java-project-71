package hexlet.code;

import hexlet.code.formattersType.JsonFormatter;
import hexlet.code.formattersType.PlainFormatter;
import hexlet.code.formattersType.StylishFormatter;

import java.util.List;
import java.util.Map;


public class Formatter {
    public static String formatDifference(List<Map<String, Object>> inputList, String format) throws Exception {
        return switch (format) {
            case "stylish" -> StylishFormatter.formatLine(inputList);
            case "json" -> JsonFormatter.formatJson(inputList);
            case "plain" -> PlainFormatter.formatPlain(inputList);
            default -> throw new IllegalArgumentException("Unknown format: " + format);
        };
    }
}

