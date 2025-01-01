package hexlet.code;

import java.util.*;

public class Tree {
    public static List<Map<String, Object>> getDifferenceTree(Map<String, Object> inputFile1,
                                                              Map<String, Object> inputFile2) {

        TreeMap<String, Object> sortedKeys = new TreeMap<>();
        sortedKeys.putAll(inputFile1);
        sortedKeys.putAll(inputFile2);

        List<Map<String, Object>> result = new ArrayList<>();

        sortedKeys.forEach((key, value) -> {

            Map<String, Object> changeEntry = new HashMap<>();
            changeEntry.put("key", key);

            Object value1 = inputFile1.get(key);
            Object value2 = inputFile2.get(key);

            boolean existsInFile1 = inputFile1.containsKey(key);
            boolean existsInFile2 = inputFile2.containsKey(key);

            if (!isEqual(value1, value2)) {
                changeEntry.put("status", "changed");
                changeEntry.put("value1", value1);
                changeEntry.put("value2", value2);
            } else if (existsInFile1 && !existsInFile2) {
                changeEntry.put("status", "removed");
                changeEntry.put("value", value2);
            } else if (!existsInFile1 && existsInFile2) {
                changeEntry.put("status", "added");
                changeEntry.put("value", value2);
            } else {
                changeEntry.put("status", "unchanged");
                changeEntry.put("value", value1);
            }

            result.add(changeEntry);
        });
        return result;
    }

    public static boolean isEqual(Object value1, Object value2) {
        if (value1 == null || value2 == null) {
            return value1 == value2;
        }
        return value1.equals(value2);
    }
}
