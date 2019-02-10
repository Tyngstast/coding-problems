package com.henrj.java8;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class ReduceExample {

    public static void main(String[] args) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("question", "test");
        parameters.put("second", "two");
        parameters.put("third", "three");

        String s = parameters.entrySet().stream()
                .map(entry -> {
                    try {
                        return encode(entry.getKey()) + "=" + encode((String) entry.getValue());
                    } catch (UnsupportedEncodingException e) {
                        return null;
                    }
                })
                .reduce((p1, p2) -> p1 + "&" + p2)
                .orElse("");

        System.out.println(s);
    }

    private static String encode(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, StandardCharsets.UTF_8)
                .replaceAll("\\+", "%20")
                .replaceAll("%21", "!")
                .replaceAll("%27", "'")
                .replaceAll("%28", "(")
                .replaceAll("%29", ")")
                .replaceAll("%7E", "~");
    }
}
