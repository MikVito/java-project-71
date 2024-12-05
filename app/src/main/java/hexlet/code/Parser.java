package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class Parser {
    public static HashMap<String, Object> getJasonData(String data) throws Exception {
        String content = Files.readString(Path.of(data));
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(content, new TypeReference<>() {
        });
    }

    public static HashMap<String, Object> getYamlData(Path data) throws Exception {
        String content = Files.readString(data);
        ObjectMapper yamlMapper  = new ObjectMapper();
        return yamlMapper.readValue(content, new TypeReference<>() {
        });
    }
}
