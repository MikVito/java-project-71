package hexlet.code;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;

public class Tree {
    public static List<Map<String, Object>> generateDifferenceTree(Map<String, Object> inputFile1,
                                                                   Map<String, Object> inputFile2) {

        TreeMap<String, Object> inputData = new TreeMap<>();
        inputData.putAll(inputFile1);
        inputData.putAll(inputFile2);

        List<Map<String, Object>> result = new LinkedList<>();

        inputData.forEach((key, value) -> {

            var checkList = new HashMap<String, Object>();
            checkList.put("key", key);

            Object value1 = inputFile1.get(key);
            Object value2 = inputFile2.get(key);

            if (inputFile1.containsKey(key) && inputFile2.containsKey(key)) {

                if (value1 == null || value2 == null) {
                    checkList.put("status", "not changed");
                    checkList.put("value1", value1);
                } else {
                    checkList.put("status", "changed");
                    checkList.put("value1", value1);
                    checkList.put("value2", value2);
                }
            } else if (inputFile1.containsKey(key)) {
                checkList.put("status", "deleted");
                checkList.put("value1", value1);
            } else if (inputFile2.containsKey(key)) {
                checkList.put("status", "added");
                checkList.put("value2", value2);
            }
            result.add(checkList);
        });
        return result;
    }
}
