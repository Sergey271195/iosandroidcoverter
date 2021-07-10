import util.*;

import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        FilePair filePair = new FilePair("MainPageAndroid.java", "MainPageIos.java").convert();
        List<String> androidFile = filePair.androidFileAsStringList;
        List<String> iosFile = filePair.iosFileAsStringList;
        ParsedClass androidConverter = Converter.convertAndroid(androidFile);
        ParsedClass iosConverter = Converter.convertIos(iosFile);
        System.out.println(androidConverter);
        System.out.println(iosConverter);
        HybridClass hybridClass = HybridClass.convert(androidConverter, iosConverter);
        System.out.println(hybridClass);

        BufferedWriter writer = new BufferedWriter(new FileWriter("HybridClass.java"));
        writer.write(hybridClass.toString());
        writer.close();
    }
}
