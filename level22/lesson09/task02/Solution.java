package com.javarush.test.level22.lesson09.task02;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);

        StringBuilder sb = getCondition(map);
        System.out.println(sb.toString());
    }

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder sb = new StringBuilder("");
        Iterator iter = params.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry pair = (Map.Entry) iter.next();
            if (pair.getValue() != null) {
                if (iter.hasNext()) {
                    sb.append(String.format("%s = '%s' and ", pair.getKey(), pair.getValue()));
                } else sb.append(String.format("%s = '%s'", pair.getKey(), pair.getValue()));
            }
        }

        if (sb.toString().endsWith(" ")) {
            String s = sb.toString();
            s = s.substring(0, s.length()-5);
            sb = new StringBuilder(s);
        }

        return sb;
    }
}
