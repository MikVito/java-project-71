package hexlet.code;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import java.util.TreeMap;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        return "";
    }

    public static List<Map<String, Object>> generateDifferenceTree(Map<String, Object> inputFile1,
                                                                   Map<String, Object> inputFile2) {

        TreeMap<String, Object> inputData = new TreeMap<>();
        inputData.putAll(inputFile1);
        inputData.putAll(inputFile2);

        List<Map<String, Object>> result = new LinkedList<>();

        inputData.forEach((key, value) -> {

            var checkList = new HashMap<String, Object>();
            checkList.put("key", key);

            if (inputFile1.containsKey(key) && inputFile2.containsKey(key)) {
                if (inputFile1.get(key).equals(inputFile2.get(key))) {
                    checkList.put("status", "not changed");
                    checkList.put("value1", inputFile1.get(key));
                } else {
                    checkList.put("status", "changed");
                    checkList.put("value1", inputFile1.get(key));
                    checkList.put("value2", inputFile2.get(key));
                }
            } else if (inputFile1.containsKey(key)) {
                checkList.put("status", "deleted");
                checkList.put("value1", inputFile1.get(key));
            } else {
                checkList.put("status", "added");
                checkList.put("value2", inputFile2.get(key));
            }
            result.add(checkList);
        });
        return result;
    }
}

