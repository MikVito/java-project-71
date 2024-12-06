package hexlet.code;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;

public class Parser {
    public static HashMap<String, Object> getFileData(String data, String format) throws Exception {
        HashMap<String, Object> resultMap = new HashMap<>();

        if (format.equals("json")) {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(data, new TypeReference<>() {
            });
        } else if (format.equals("yaml") || format.equals("yml")) {
            ObjectMapper yamlMapper = new ObjectMapper();
            return yamlMapper.readValue(data, new TypeReference<>() {
            });
        }
        return resultMap;
    }
}
