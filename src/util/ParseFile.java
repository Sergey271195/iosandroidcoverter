package util;

public class ParseFile {

    private final String fileName;
    private final String filePath;

    private ParseFile(String fileName) {
        this.fileName = fileName;
        this.filePath = "./resources/" + fileName;
    }

    public static ParseFile of(String fileName) {
        return new ParseFile(fileName);
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {
        return filePath;
    }
}
