package util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HybridClass {
    private final ParsedClass androidParsedClass;
    private final ParsedClass iosParsedClass;
    private final String imports;
    private final String unAnnotatedFields;
    private final ClassField classField;
    private final PageEntryAnnotation pageEntryAnnotation;
    private final List<FieldWithDoubleAnnotations> fields;

    private HybridClass(ParsedClass androidParsedClass, ParsedClass iosParsedClass) {
        this.androidParsedClass = androidParsedClass;
        this.iosParsedClass = iosParsedClass;
        this.imports = getImports();
        this.unAnnotatedFields = getUnAnnotatedFields();
        this.classField = androidParsedClass.getClassField();
        this.pageEntryAnnotation = androidParsedClass.getPageEntryAnnotation();
        this.fields = getFields();
        System.out.println(fields);
    }

    public static HybridClass convert(ParsedClass androidParsedClass, ParsedClass iosParsedClass) {
        return new HybridClass(androidParsedClass, iosParsedClass);
    }

    private String getImports() {
        return Stream.concat(androidParsedClass.getImports().stream(), iosParsedClass.getImports().stream())
                .distinct().collect(Collectors.joining(ParsedClass.NEW_LINE)) + ParsedClass.NEW_LINE;
    }

    private String getUnAnnotatedFields() {
        return Stream.concat(androidParsedClass.getUnAnnotatedFields().stream(),
                             iosParsedClass.getUnAnnotatedFields().stream())
                .distinct().collect(Collectors.joining(ParsedClass.NEW_LINE_TAB)) + ParsedClass.NEW_LINE;
    }

    private List<FieldWithDoubleAnnotations> getFields() {
        return Stream.concat(
                androidParsedClass.getFieldsMap().keySet().stream(),
                iosParsedClass.getFieldsMap().keySet().stream()
        ).distinct()
         .map(this::convertToFieldWithDoubleAnnotations)
         .collect(Collectors.toList());
    }

    private FieldWithDoubleAnnotations convertToFieldWithDoubleAnnotations(ElementTitleAnnotation elementTitle) {
        FieldWithAnnotations androidField = androidParsedClass.getFieldsMap().get(elementTitle);
        FieldWithAnnotations iosField = iosParsedClass.getFieldsMap().get(elementTitle);

        FindByAnnotation androidFindByAnnotation = androidField == null ? null :  androidField.getFindByAnnotation();
        FindByAnnotation iosFindByAnnotation = iosField == null ? null :  iosField.getFindByAnnotation();

        Field hybridField = androidField == null ? iosField.getField() : androidField.getField();

        return new FieldWithDoubleAnnotations(
                elementTitle,
                androidFindByAnnotation,
                iosFindByAnnotation,
                hybridField
        );
    }

    private String convertFieldsWithAnnotationToString() {
        return fields.stream()
                .map(FieldWithDoubleAnnotations::toString).collect(Collectors.joining(ParsedClass.NEW_LINE));
    }

    @Override
    public String toString() {
        return  imports + ParsedClass.DOUBLE_NEW_LINE +
                pageEntryAnnotation + ParsedClass.NEW_LINE +
                classField + ParsedClass.NEW_LINE +
                (unAnnotatedFields.isEmpty()
                        ? ParsedClass.NEW_LINE :
                        ParsedClass.NEW_LINE_TAB + unAnnotatedFields + ParsedClass.NEW_LINE
                ) +
                convertFieldsWithAnnotationToString() + "}";
    }
}
