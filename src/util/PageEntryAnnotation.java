package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PageEntryAnnotation {
    public static final String PAGE_ENTRY_ANNOTATION = "@PageEntry";
    private static Pattern pattern = Pattern.compile(PAGE_ENTRY_ANNOTATION + "\\(\\s*title\\s*=\\s*\"(.*?)\"\\)");
    private String title;

    public static PageEntryAnnotation getFieldTitle(String line) {
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            return PageEntryAnnotation.withTitle(matcher.group(1));
        }
        return PageEntryAnnotation.withTitle("");
    }

    private static PageEntryAnnotation withTitle(String title) {
        PageEntryAnnotation pageEntryAnnotation = new PageEntryAnnotation();
        pageEntryAnnotation.setTitle(title);
        return pageEntryAnnotation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return PAGE_ENTRY_ANNOTATION + "(title = \"" + title + "\")";
    }
}
