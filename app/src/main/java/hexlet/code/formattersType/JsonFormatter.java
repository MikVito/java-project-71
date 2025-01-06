package hexlet.code.formattersType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class JsonFormatter {
    public static String formatJson(List<Map<String, Object>> inputList) throws JsonProcessingException {
        Map<String, Map<String, Object>> resultMap = new TreeMap<>();

        for (Map<String, Object> item : inputList) {
            String key = (String) item.get("key");
            String status = (String) item.get("status");

            Map<String, Object> values = new TreeMap<>();
            if (status.equals("removed")) {
                values.put("status", "deleted");
            } else {
                values.put("status", status);
            }

            values.put("value1", null);
            values.put("value2", null);

            switch (status) {
                case "changed" -> {
                    values.put("value1", item.getOrDefault("value1", null));
                    values.put("value2", item.getOrDefault("value2", null));
                }
                case "unchanged" -> {
                    values.put("value1", item.get("value"));
                    values.put("value2", item.get("value"));
                }
                case "added" -> values.put("value2", item.get("value"));
                case "removed" -> values.put("value1", item.get("value"));

                default -> throw new IllegalArgumentException("Unknown status " + status);
            }

            resultMap.put(key, values);
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter()
                .withObjectIndenter(new DefaultIndenter("  ", "\n"))
                .withArrayIndenter(new DefaultIndenter("  ", "\n"));

        return mapper.writer(printer).writeValueAsString(resultMap);
    }
}
