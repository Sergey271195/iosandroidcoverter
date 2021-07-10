package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Field {

    private final String PUBLIC_SCOPE = "public";
    private final String PRIVATE_SCOPE = "private";
    private final String PROTECTED_SCOPE = "protected";
    private List<String> VISIBILITY_SCOPES = List.of(PUBLIC_SCOPE, PRIVATE_SCOPE, PROTECTED_SCOPE);

    private final String STATIC = "static";
    private final String FINAL = "final";

    private String visibilityScope;
    private boolean isStatic = false;
    private boolean isFinal = false;
    private String clazz;
    private String variableName;
    private String initialValue;

    public static boolean isField(String line) {
        return !line.startsWith("import") &&
               !line.startsWith("public class") &&
                line.matches("^[a-zA-Z].+");
    }

    public static Field parseLine(String line) {
        return new Field().parseLineInner(line);
    }

    public Field parseLineInner(String line) {
        String withParsedVisibility = parseVisibilityScope(line);
        String withParsedStatic = parseStatic(withParsedVisibility);
        String withParsedFinal = parseFinal(withParsedStatic);
        return parseClassAndName(withParsedFinal);
    }

    private String parseVisibilityScope(String line) {
        String fieldScope =  VISIBILITY_SCOPES.stream()
            .filter(scope -> line.startsWith(scope))
            .findFirst().orElse("");
        setVisibilityScope(fieldScope);
        return line.replace(fieldScope, "").trim();
    }

    private String parseStatic(String line) {
        if (line.startsWith(STATIC)) {
            setStatic(true);
            return line.replace(STATIC, "").trim();
        }
        return line;
    }

    private String parseFinal(String line) {
        if (line.startsWith(FINAL)) {
            setFinal(true);
            return line.replace(FINAL, "").trim();
        }
        return line;
    }

    private Field parseClassAndName(String line) {
        List<String> elements = Arrays.stream(line.split(" ")).collect(Collectors.toList());
        String lastElement = elements.get(elements.size() - 1);
        String lastElementNormalized = lastElement.substring(0, lastElement.length() - 1);
        elements.set(elements.size() - 1, lastElementNormalized);
        setClazz(elements.get(0).trim());
        setVariableName(elements.get(1).trim());

        String initialValue = elements.size() > 3 && elements.get(2).trim().equals("=")
            ? elements.stream().skip(3).collect(Collectors.joining(""))
            : "";

        setInitialValue(initialValue);
        return this;
    }

    public String getVisibilityScope() {
        return visibilityScope;
    }

    public void setVisibilityScope(String visibilityScope) {
        this.visibilityScope = visibilityScope;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public void setStatic(boolean aStatic) {
        isStatic = aStatic;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean aFinal) {
        isFinal = aFinal;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(String initialValue) {
        this.initialValue = initialValue;
    }

    @Override
    public String toString() {
        return visibilityScope + " " +
               (isStatic ? STATIC + " " : "") +
               (isFinal ? FINAL + " " : "") +
               clazz + " " +
               variableName +
               (initialValue.isBlank() ? ";" : " = " + initialValue + ";");
    }
}
