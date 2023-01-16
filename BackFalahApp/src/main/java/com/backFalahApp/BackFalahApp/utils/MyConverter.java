package com.backFalahApp.BackFalahApp.utils;
import java.util.Arrays;
import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import static java.util.Collections.*;

public class MyConverter  {
    private static final String SPLIT_CHAR = ",";

    public static String convertToEntityAttribute(List<String> stringList) {
        return stringList != null ? String.join(SPLIT_CHAR, stringList) : "";
    }

    public static List<String> convertToDatabaseColumn(String string) {
        if (string == null) return emptyList();
        if (string.charAt(0) == '[' && string.charAt(string.length() - 1) == ']'){
            string = string.substring(1, string.length()-1);
            string = string.replace("\"","");
            string = string.replace(" ","");
        }
        return Arrays.asList(string.split(SPLIT_CHAR));
    }
}