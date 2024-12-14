package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.HashMap;

public class Parser {
    public static HashMap<String, Object> getFileParse(String data, String type) throws Exception {
        HashMap<String, Object> resultMap = new HashMap<>();

        if (type.equals("json")) {
            resultMap = parseJson(data);
        } else if (type.equals("yaml") || type.equals("yml")) {
            resultMap = parseYaml(data);
        }
        return resultMap;
    }
    public static HashMap<String, Object> parseJson(String data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(data, new TypeReference<>() { });
    }

    public static HashMap<String, Object> parseYaml(String data) throws JsonProcessingException {
        YAMLMapper yamlMapper = new YAMLMapper();
        return yamlMapper.readValue(data, new TypeReference<>() { });
    }
}
