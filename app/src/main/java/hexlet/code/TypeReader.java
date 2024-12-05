package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class TypeReader {
    public static HashMap<String, Object> getJasonFile(Path data) throws IOException {
        String content = Files.readString(data);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(content, new TypeReference<>() {
        });
    }

    public static HashMap<String, Object> getYmlFile(Path data) throws Exception {
        String content = Files.readString(data);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(content, new TypeReference<>() {
        });
    }
}
