package util;

public class AndroidFindByAnnotation extends FindByAnnotation {
    public static final String INITIAL_ANNOTATION = "@AndroidFindBy";
    public static final String RESULT_ANNOTATION = "@AndroidFindBy";

    public AndroidFindByAnnotation() {
        super(INITIAL_ANNOTATION, RESULT_ANNOTATION);
    }

    public static FindByAnnotation fromLine(String line) {
        AndroidFindByAnnotation android = new AndroidFindByAnnotation();
        return android.parseAnnotation(line);
    }
}
