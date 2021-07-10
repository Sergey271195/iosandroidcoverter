package util;

public class IosFindByAnnotation extends FindByAnnotation {
    public static final String INITIAL_ANNOTATION = "@FindBy";
    public static final String RESULT_ANNOTATION = "@FindBy";

    public IosFindByAnnotation() {
        super(INITIAL_ANNOTATION, RESULT_ANNOTATION);
    }

    public static FindByAnnotation fromLine(String line) {
        IosFindByAnnotation ios = new IosFindByAnnotation();
        return ios.parseAnnotation(line);
    }
}
