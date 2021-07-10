package util;

public class ClassField {

    private final String className;

    public static boolean isClassField(String line) {
        return line.startsWith("public class");
    }

    private ClassField(String className) {
        this.className = className;
    }

    public static ClassField getClassField(String line) {
        String className = line.replace("public class", "").replace("{", "").trim();
        return new ClassField(className);
    }

    @Override
    public String toString() {
        return "public class " + className + " {";
    }
}
