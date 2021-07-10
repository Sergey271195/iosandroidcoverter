package util;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ElementTitleAnnotation {
    public static final String ELEMENT_TITLE_ANNOTATION = "@ElementTitle";
    private static Pattern pattern = Pattern.compile(ELEMENT_TITLE_ANNOTATION + "\\(\"(.*?)\"\\)");
    private String title;

    public static ElementTitleAnnotation getFieldTitle(String line) {
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            return ElementTitleAnnotation.withTitle(matcher.group(1));
        }
        return ElementTitleAnnotation.withTitle("");
    }

    private static ElementTitleAnnotation withTitle(String title) {
        ElementTitleAnnotation elementTitleAnnotation = new ElementTitleAnnotation();
        elementTitleAnnotation.setTitle(title);
        return elementTitleAnnotation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return ELEMENT_TITLE_ANNOTATION + "(\"" + title + "\")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElementTitleAnnotation)) return false;
        ElementTitleAnnotation that = (ElementTitleAnnotation) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
