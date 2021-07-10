package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindByAnnotation {

    private final String initialAnnotation;
    private final String resultingAnnotation;
    private  final Pattern pattern;

    private String key = "";
    private String value = "";

    public FindByAnnotation(String initialAnnotation, String resultingAnnotation) {
        this.resultingAnnotation = resultingAnnotation;
        this.initialAnnotation = initialAnnotation;
        pattern = Pattern.compile(initialAnnotation + "\\(\\s*(.*?)\\s*=\\s*\"(.*?)\"\\)");
    }

    public FindByAnnotation parseAnnotation(String line) {
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            setKey(matcher.group(1));
            setValue(matcher.group(2));
        }
        return this;
    }

    public boolean isEmpty() {
        return value.isEmpty();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getInitialAnnotation() {
        return initialAnnotation;
    }

    @Override
    public String toString() {
        return resultingAnnotation + "(" +
                (value.isBlank() ? "" : key + " = \"" + value + "\"") + ")";
    }
}
