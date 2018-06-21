package lamda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.function.Predicate;

public class LamdaDemo {
    private static String processFile(IBufferedReaderProcesser processer) throws Exception {
        try (BufferedReader br =new BufferedReader(new FileReader("E:\\WiFi_Log.txt"))){
            return processer.process(br);
        }
    }
    private static String predicateDemo(Predicate<String> predicate)  {
        if (predicate.test("red")){
            return "true";
        }
        return "false";
    }
    //简化方法引用
    //1 静态方法引用


    public static void main(String[] args) throws Exception {
        System.out.println(LamdaDemo.processFile(bufferedReader -> bufferedReader.readLine()));
        System.out.println(LamdaDemo.predicateDemo(str->"red".equals(str)));

    }
}
