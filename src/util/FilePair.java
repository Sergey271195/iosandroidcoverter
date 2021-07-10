package util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FilePair {

    private final ParseFile androidFile;
    private final ParseFile iosFile;

    public List<String> androidFileAsStringList;
    public List<String> iosFileAsStringList;

    public FilePair(String androidFile, String iosFile) {
        this.androidFile = ParseFile.of(androidFile);
        this.iosFile = ParseFile.of(iosFile);
    }

    public FilePair convert() throws IOException {
        this.androidFileAsStringList = convertFile(androidFile);
        this.iosFileAsStringList = convertFile(iosFile);
        return this;
    }

    private List<String> convertFile(ParseFile file) throws IOException {
        List<String> resultFile = new ArrayList<>();
        InputStream inputFile = new FileInputStream(file.getFilePath());
        try (BufferedReader br =
                     new BufferedReader(new InputStreamReader(inputFile, StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.isBlank()) {
                    resultFile.add(line.trim());
                }
            }
        }
        return resultFile;
    }

}
