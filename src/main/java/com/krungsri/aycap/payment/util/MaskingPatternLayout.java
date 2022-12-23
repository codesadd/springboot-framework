package com.krungsri.aycap.payment.util;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class MaskingPatternLayout extends PatternLayout {
    private List<String> maskPatterns = new ArrayList<>();

    public void addMaskPattern(String maskPattern) {
        maskPatterns.add(maskPattern);
    }

    @Override
    public String doLayout(ILoggingEvent event) {
        return maskMessage(super.doLayout(event));
    }

    private String maskMessage(String message) {
        if (maskPatterns.isEmpty()) {
            return message;
        }
        
        StringBuilder sb = new StringBuilder(message);
        for (int in = 0; in < maskPatterns.size(); in++) {
            String pattern = maskPatterns.get(in);
            Matcher matcher = Pattern.compile(pattern).matcher(sb);
            while (matcher.find()) {
                 if (in == 0) { //address Masking
                    IntStream.rangeClosed(1,1).forEach(group -> {
                        if (matcher.group(group) != null) {
                            IntStream.range(matcher.start(group), matcher.end(group)).forEach(i -> sb.setCharAt(i, '*'));
                        }
                    });
                }
                else if (in == 1) { // IP Address Masking
                    IntStream.rangeClosed(2, 3).forEach(group -> {
                        if (matcher.group(group) != null) {
                            IntStream.range(matcher.start(group), matcher.end(group)).forEach(i -> sb.setCharAt(i, '*'));
                        }
                    });
                }else if (in == 2) { //email Masking
                    IntStream.rangeClosed(1, 1).forEach(group -> {
                        if (matcher.group(group) != null) {
                            IntStream.range(matcher.start(group)+1, matcher.end(group)).forEach(i -> sb.setCharAt(i, '*'));
                        }
                    });
                }else if (in == 3) { // CardNo Masking
                    IntStream.rangeClosed(2, 2).forEach(group -> {
                        if (matcher.group(group) != null) {
                            IntStream.range(matcher.start(group), matcher.end(group)).forEach(i -> sb.setCharAt(i, '*'));
                        }
                    });
                }else if (in == 4) { // FirstName Masking
                     IntStream.rangeClosed(1, 1).forEach(group -> {
                         if (matcher.group(group) != null) {
                             IntStream.range(matcher.start(group)+4, matcher.end(group)).forEach(i -> sb.setCharAt(i, '*'));
                         }
                     });
                 }else if (in == 5) { // LastName Masking
                     IntStream.rangeClosed(1, 1).forEach(group -> {
                         if (matcher.group(group) != null) {
                             IntStream.range(matcher.start(group)+4, matcher.end(group)).forEach(i -> sb.setCharAt(i, '*'));
                         }
                     });
                 }

            }
        }
        
        return sb.toString();
    }
}