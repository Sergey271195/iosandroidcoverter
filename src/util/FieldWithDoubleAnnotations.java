package util;

public class FieldWithDoubleAnnotations {

    public ElementTitleAnnotation getElementTitleAnnotation() {
        return elementTitleAnnotation;
    }

    public FindByAnnotation getAndroidFindByAnnotation() {
        return androidFindByAnnotation;
    }

    public FindByAnnotation getIosFindByAnnotation() {
        return iosFindByAnnotation;
    }

    public Field getField() {
        return field;
    }

    private final ElementTitleAnnotation elementTitleAnnotation;
    private final FindByAnnotation androidFindByAnnotation;
    private final FindByAnnotation iosFindByAnnotation;
    private final Field field;

    public FieldWithDoubleAnnotations(ElementTitleAnnotation elementTitleAnnotation,
                                      FindByAnnotation androidFindByAnnotation,
                                      FindByAnnotation iosFindByAnnotation,
                                      Field field) {
        this.elementTitleAnnotation = elementTitleAnnotation;
        this.androidFindByAnnotation = androidFindByAnnotation;
        this.iosFindByAnnotation = iosFindByAnnotation;
        this.field = field;
    }

    private String convertAndroidFieldToString() {
        return androidFindByAnnotation == null || androidFindByAnnotation.isEmpty()
                ? "" : androidFindByAnnotation + ParsedClass.NEW_LINE_TAB;
    }

    private String convertIosFieldToString() {
        return iosFindByAnnotation == null || iosFindByAnnotation.isEmpty()
                ? "" : iosFindByAnnotation + ParsedClass.NEW_LINE_TAB;
    }

    @Override
    public String toString() {
        return ParsedClass.TAB + elementTitleAnnotation + ParsedClass.NEW_LINE_TAB +
               convertAndroidFieldToString() +
               convertIosFieldToString() +
               field + ParsedClass.NEW_LINE;
    }
}
