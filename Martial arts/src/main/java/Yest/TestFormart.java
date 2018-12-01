package Yest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFormart {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateYMFormat = new SimpleDateFormat("yyyy-MM");
        Date parse = dateYMFormat.parse("2018-01");
        System.out.println(parse);
        String f ="http://192.168.1.227:8082/image/repository/DataStore/device_version/201801/19/1516329699372101.lic";
        String result = f.substring(f.lastIndexOf('/')+1);
        System.out.println(result);
    }
    public static boolean isPowerOfThree(int n) {
        if (n <= 0)
            return false;
        double r = Math.log10(n) / Math.log10(3);
        if (r % 1 == 0)
            return true;
        else
            return false;
    }
}