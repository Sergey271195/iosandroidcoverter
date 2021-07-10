package util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParsedClass {

    public static final String NEW_LINE = "\n";
    public static final String DOUBLE_NEW_LINE = "\n\n";
    public static final String TAB = "\t";
    public static final String NEW_LINE_TAB = "\n\t";

    private final boolean isAndroid;
    private final List<String> imports;
    private final List<String> unAnnotatedFields;
    private final ClassField classField;
    private final PageEntryAnnotation pageEntryAnnotation;
    private final Map<ElementTitleAnnotation, FieldWithAnnotations> fieldsMap;
    public static Builder builder = new Builder();

    private ParsedClass(boolean isAndroid,
                        List<String> imports,
                        List<String> unAnnotatedFields,
                        ClassField classField,
                        PageEntryAnnotation pageEntryAnnotation,
                        Map<ElementTitleAnnotation, FieldWithAnnotations> fieldsMap) {
        this.isAndroid = isAndroid;
        this.imports = imports;
        this.unAnnotatedFields = unAnnotatedFields;
        this.classField = classField;
        this.pageEntryAnnotation = pageEntryAnnotation;
        this.fieldsMap = fieldsMap;
    }

    public static class Builder {
        private boolean isAndroid;
        private List<String> imports = List.of();
        private List<String> unAnnotatedFields = List.of();
        private ClassField classField;
        private PageEntryAnnotation pageEntryAnnotation;
        private Map<ElementTitleAnnotation, FieldWithAnnotations> fieldsMap = Map.of();

        private Builder() {
        }

        public Builder isAndroid(boolean isAndroid) {
            this.isAndroid = isAndroid;
            return this;
        }

        public Builder withClassField(ClassField classField) {
            this.classField = classField;
            return this;
        }

        public Builder withImports(List<String> imports) {
            this.imports = imports;
            return this;
        }

        public Builder withUnAnnotatedFields(List<String> unAnnotatedFields) {
            this.unAnnotatedFields = unAnnotatedFields;
            return this;
        }

        public Builder withPageEntryAnnotation(PageEntryAnnotation pageEntryAnnotation) {
            this.pageEntryAnnotation = pageEntryAnnotation;
            return this;
        }

        public Builder withFieldsMap(Map<ElementTitleAnnotation, FieldWithAnnotations> fieldsMap) {
            this.fieldsMap = fieldsMap;
            return this;
        }

        public ParsedClass build() {
            return new ParsedClass(
                    isAndroid,
                    imports,
                    unAnnotatedFields,
                    classField,
                    pageEntryAnnotation,
                    fieldsMap
            );
        }

    }

    private String convertFieldsWithAnnotationToString() {
        return fieldsMap.values().stream()
                .map(value ->
                        TAB + value.getElementTitleAnnotation() + NEW_LINE_TAB +
                         value.getFindByAnnotation() + NEW_LINE_TAB +
                         value.getField() + DOUBLE_NEW_LINE).collect(Collectors.joining());
    }

    private String convertImports() {
        return imports.stream().collect(Collectors.joining(NEW_LINE));
    }

    private String convertUnAnnotatedFields() {
        return !unAnnotatedFields.isEmpty()
                ? unAnnotatedFields.stream().map(str -> TAB + str).collect(Collectors.joining(NEW_LINE))
                : "";
    }

    public boolean isAndroid() {
        return isAndroid;
    }

    public ClassField getClassField() {
        return classField;
    }

    public PageEntryAnnotation getPageEntryAnnotation() {
        return pageEntryAnnotation;
    }

    public Map<ElementTitleAnnotation, FieldWithAnnotations> getFieldsMap() {
        return fieldsMap;
    }

    public List<String> getImports() {
        return imports;
    }

    public List<String> getUnAnnotatedFields() {
        return unAnnotatedFields;
    }

    @Override
    public String toString() {
        return convertImports() + DOUBLE_NEW_LINE +
                pageEntryAnnotation + NEW_LINE +
                classField + NEW_LINE +
                (unAnnotatedFields.isEmpty() ? NEW_LINE : convertUnAnnotatedFields() + DOUBLE_NEW_LINE) +
                convertFieldsWithAnnotationToString() + "}";
    }
}
