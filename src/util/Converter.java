package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Converter {

    private List<String> imports = new ArrayList<>();
    private ClassField classField;
    private PageEntryAnnotation pageEntryAnnotation;
    private List<Field> unAnnotatedFields = new ArrayList<>();
    private Map<ElementTitleAnnotation, FieldWithAnnotations> fieldsMap = new HashMap<>();

    public static ParsedClass convertAndroid(List<String> file) {
        return new Converter().convert(file, true);
    }

    public static ParsedClass convertIos(List<String> file) {
        return new Converter().convert(file, false);
    }

    private ParsedClass convert(List<String> file, boolean isAndroid) {

        for (int i = 0; i < file.size(); i++) {
            String line = file.get(i);
            if (isImport(line)) {
                continue;
            } else if (isClass(line)) {
                continue;
            } else if (isPageEntry(line)) {
                continue;
            } else if (Field.isField(line)) {
                System.out.println(i);
                unAnnotatedFields.add(Field.parseLine(line));
            } else if (isElementTitle(line)) {
                ElementTitleAnnotation annotation = ElementTitleAnnotation.getFieldTitle(line);

                int nextAnnotationLine = isAndroid
                    ? findNextFindByIdAnnotationForAndroid(file, i)
                    : findNextFindByIdAnnotationForIos(file, i);
                FindByAnnotation findByAnnotation = isAndroid
                    ? AndroidFindByAnnotation.fromLine(file.get(nextAnnotationLine))
                    : IosFindByAnnotation.fromLine(file.get(nextAnnotationLine));

                int nextFieldLine = findNextFieldLine(file, nextAnnotationLine);
                Field field = Field.parseLine(file.get(nextFieldLine));

                FieldWithAnnotations fieldWithAnnotations =
                        new FieldWithAnnotations(annotation, findByAnnotation, field);

                fieldsMap.put(annotation, fieldWithAnnotations);
                i = nextFieldLine;
            }
        }

        List<String> unAnnotatedFieldsString =
                unAnnotatedFields.stream().map(Field::toString).collect(Collectors.toList());

        return ParsedClass.builder
                .isAndroid(isAndroid)
                .withImports(imports)
                .withUnAnnotatedFields(unAnnotatedFieldsString)
                .withClassField(classField)
                .withFieldsMap(fieldsMap)
                .withPageEntryAnnotation(pageEntryAnnotation)
                .build();
    }

    private int findNextFindByIdAnnotationForAndroid(List<String> file, int counter) {
        return findNextFindByIdAnnotation(file, counter, AndroidFindByAnnotation.INITIAL_ANNOTATION);
    }

    private int findNextFindByIdAnnotationForIos(List<String> file, int counter) {
        return findNextFindByIdAnnotation(file, counter, IosFindByAnnotation.INITIAL_ANNOTATION);
    }

    private int findNextFindByIdAnnotation(List<String> file, int counter, String annotation) {
        String line = file.get(counter);
        while (!line.startsWith(annotation)) {
            counter++;
            line = file.get(counter);
        }
        return counter;
    }

    private int findNextFieldLine(List<String> file, int counter) {
        String line = file.get(counter);
        while (!Field.isField(line)) {
            counter++;
            line = file.get(counter);
        }
        return counter;
    }

    private boolean isImport(String line) {
        if (line.startsWith("import")) {
            imports.add(line);
            return true;
        }
        return false;
    }

    private boolean isClass(String line) {
        if (ClassField.isClassField(line)) {
            this.classField = ClassField.getClassField(line);
            return true;
        }
        return false;
    }

    private boolean isPageEntry(String line) {
        if (line.startsWith(PageEntryAnnotation.PAGE_ENTRY_ANNOTATION)) {
            this.pageEntryAnnotation = PageEntryAnnotation.getFieldTitle(line);
            return true;
        }
        return false;
    }

    private boolean isElementTitle(String line) {
        return line.startsWith(ElementTitleAnnotation.ELEMENT_TITLE_ANNOTATION);
    }

}
