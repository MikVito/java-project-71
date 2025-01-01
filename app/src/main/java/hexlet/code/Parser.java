package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String data, String type) throws JsonProcessingException {
        if (type.equals("json")) {
            return parseJson(data);
        } else if (type.equals("yaml") || type.equals("yml")) {
            return parseYaml(data);
        } else {
            throw new IllegalArgumentException("Unsupported file format: " + type);
        }
    }

    public static Map<String, Object> parseJson(String data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(data, new TypeReference<>() {
        });
    }

    public static Map<String, Object> parseYaml(String data) throws JsonProcessingException {
        YAMLMapper yamlMapper = new YAMLMapper();
        return yamlMapper.readValue(data, new TypeReference<>() {
        });
    }
}
