package util;

public class FieldWithAnnotations {
    private final ElementTitleAnnotation elementTitleAnnotation;
    private final FindByAnnotation findByAnnotation;
    private final Field field;

    public FieldWithAnnotations(ElementTitleAnnotation elementTitleAnnotation,
                                FindByAnnotation findByAnnotation,
                                Field field) {
        this.elementTitleAnnotation = elementTitleAnnotation;
        this.findByAnnotation = findByAnnotation;
        this.field = field;
    }

    public ElementTitleAnnotation getElementTitleAnnotation() {
        return elementTitleAnnotation;
    }

    public FindByAnnotation getFindByAnnotation() {
        return findByAnnotation;
    }

    public Field getField() {
        return field;
    }

    @Override
    public String toString() {
        return "FieldWithAnnotations{" +
                "elementTitleAnnotation=" + elementTitleAnnotation +
                ", findByAnnotation=" + findByAnnotation +
                ", field=" + field +
                '}';
    }
}
