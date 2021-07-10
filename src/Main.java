import util.*;

import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        String androidFileName = "MainPageAndroid.java";
        String iosFileName = "MainPageIos.java";
        String outputFile = "HybridClass.java";

        FilePair filePair = new FilePair(androidFileName, iosFileName).convert();

        List<String> androidFile = filePair.androidFileAsStringList;
        List<String> iosFile = filePair.iosFileAsStringList;

        ParsedClass androidConverter = Converter.convertAndroid(androidFile);
        System.out.println(androidConverter);

        ParsedClass iosConverter = Converter.convertIos(iosFile);
        System.out.println(iosConverter);

        HybridClass hybridClass = HybridClass.convert(androidConverter, iosConverter);
        System.out.println(hybridClass);

        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        writer.write(hybridClass.toString());
        writer.close();
    }
}
