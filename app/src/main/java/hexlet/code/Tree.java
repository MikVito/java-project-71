package hexlet.code;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class Tree {
    public static Map<String, Map<String, Object>> getDifferenceTree(Map<String, Object> inputFile1,
                                                                     Map<String, Object> inputFile2) {
        Set<String> keys = new TreeSet<>();
        keys.addAll(inputFile1.keySet());
        keys.addAll(inputFile2.keySet());

        Map<String, Map<String, Object>> resultMap = new TreeMap<>();

        for (var key : keys) {
            Map<String, Object> values = new TreeMap<>();
            Object oldValue = inputFile1.get(key);
            Object newValue = inputFile2.get(key);

            if (!inputFile1.containsKey(key)) {
                values.put("status", "added");
                values.put("value1", null);
                values.put("value2", newValue);
            } else if (!inputFile2.containsKey(key)) {
                values.put("status", "deleted");
                values.put("value1", oldValue);
                values.put("value2", null);
            } else if (compareValues(oldValue, newValue)) {
                values.put("status", "unchanged");
                values.put("value1", oldValue);
                values.put("value2", oldValue);
            } else {
                values.put("status", "changed");
                values.put("value1", oldValue);
                values.put("value2", newValue);
            }
            resultMap.put(key, values);
        }
        return resultMap;
    }

    public static boolean compareValues(Object value1, Object value2) {
        if (value1 == null || value2 == null) {
            return value1 == value2;
        }
        return value1.equals(value2);
    }
}
