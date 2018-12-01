package validat;


import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * Created by zhangguanlong on 2017/11/21.
 */
public class ValidateFunctionTest {
   /* @Test
    public void testEmailCheck(){
        String email = "Mike@123.com";
        String email1 = "1233124YYYYmmm#23.gov";
        System.out.println("-----------------------");
        ValidateMessage message = ValidateFunction.checkEmail(ValidateFunction._EMAIL_CHECK,"email",email1);
        System.out.println("key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
        System.out.println("-----------------------");
    }*/
    @Test
    public void testIpCheck(){
        String ip = "Mike@123.com";
        String ip2 = "192.168.0.1";
        System.out.println("-----------------------");
        ValidateMessage message = ValidateFunction.check(ValidateFunction._IP_CHECK,"ip",ip2);
        System.out.println("key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
        System.out.println("-----------------------");
    }
    @Test
    public void testUrlCheck(){
        String url = "www.123.com";
        String url2 = "https://translate.google.cn/";
        String[] urlDict={
                //bad Case
                "www.baidu.com",           //常规网址，未带协议头的地址
                "w.baidu.com",            //常规网址，短子域名
                "baidu.com",             //常规网址，仅有主域名
                "测试.com",              //非常规合法网址，中文域名不在参考之列
                "1.2",                //错误域名
                " WWWW ",              //无效字符串
                "111测试",              //无效字符串
                //Correct Case
                "http://baidu.com",          //常规网址，仅有主域名
                "http://www.baidu.com",        //常规网址，带子域名
                "https://www.baidu.com/",       //常规网址，使用https协议头，带根目录
                "http://www.baidu.com/api",      //常规网址，有一级目录下资源
                "http://www.subdomain.baidu.com/index/subdir",   //常规网址，多级子域名，多级目录
                "ftp://www.www.subdomain.baidu.com/index/subdir/",//常规网址，多级子域名，多级目录，目录地址闭合
                "http://io.io"  };          //非常规网址，多级子域名，多级目录，目录地址闭合};
        for (String dic:urlDict) {
            System.out.println("-----------------------");
            ValidateMessage message = ValidateFunction.check(ValidateFunction._URL_CHECK,dic,dic);
            System.out.println("key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
            System.out.println("-----------------------");
        }

    }
    @Test
    public void testtelephoneCheck(){
        String[] phonenumber = {"123123","88710999","0531-88811888","024-1111111",
                                "1212121","122-111-2222"};
        for (String num:phonenumber) {
            System.out.println("-----------------------");
            ValidateMessage message = ValidateFunction.check(ValidateFunction._TEL_CHECK,"teltephone",num);
            System.out.println("key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
            System.out.println("-----------------------");
        }

    }
    @Test
    public void testpassLengthCheck(){
        String pass="afea";
        String pass2 = "123123";
        String pass1 = "1234567891234567890";
        System.out.println("-----------------------");
        ValidateMessage message = ValidateFunction.check(ValidateFunction._PASSWLENGTH_CHECK,"pass",pass2);
        System.out.println("key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
        System.out.println("-----------------------");
    }
    @Test
    public void testpostCodeCheck(){
        String code="250107";
        String code1 = "123123";
        String code2 = "1234567891234567890";
        System.out.println("-----------------------");
        ValidateMessage message = ValidateFunction.check(ValidateFunction._POSTALCODE_CHECK,"code",code1);
        System.out.println("key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
        System.out.println("-----------------------");
    }
    @Test
    public void testhandsetCheck(){
        String[] numdic={"13300000000","17800000000","19000000000",
                        "0000000000","11111111111","888888888888"};
        for (String num:numdic) {
            System.out.println("-----------------------");
            ValidateMessage message = ValidateFunction.check(ValidateFunction._HANDSET_CHECK,"num",num);
            System.out.println("key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
            System.out.println("-----------------------");
        }
    }
    @Test
    public void testidcardCheck(){
        String[] id={"370222222222222222","22222","11111111111111111X",
                "33333333333333333x","11111111111","888888888888"};
        for (String num:id) {
            System.out.println("-----------------------");
            ValidateMessage message = ValidateFunction.check(ValidateFunction._IDCARD_CHECK,"num",num);
            System.out.println("str: "+num+" key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
            System.out.println("-----------------------");
        }
    }
    @Test
    public void testdecimalCheck(){
        String[] decimal={"370222222222222222.1","22222.2","0.33",
                "0.333","3.3.3",".3"};
        for (String num:decimal) {
            System.out.println("-----------------------");
            ValidateMessage message = ValidateFunction.check(ValidateFunction._DECIMAL_CHECK,"num",num);
            System.out.println("str: "+num+" key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
            System.out.println("-----------------------");
        }
    }
    @Test
    public void testmonthCheck(){
        String[] decimal={"370222222222222222.1","22222.2","0.33",
                "0.333","3.3.3",".3"};
        for (Integer i = -1; i <100; i++) {
            System.out.println("-----------------------");
            ValidateMessage message = ValidateFunction.check(ValidateFunction._MONTH_CHECK,"num",i.toString());
            System.out.println("str: "+i+" key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
            System.out.println("-----------------------");
        }
    }
    @Test
    public void testDayCheck(){
        String[] decimal={"370222222222222222.1","22222.2","0.33",
                "0.333","3.3.3",".3"};
        for (Integer i = -1; i <100; i++) {
            System.out.println("-----------------------");
            ValidateMessage message = ValidateFunction.check(ValidateFunction._DAY_CHECK,"num",i.toString());
            System.out.println("str: "+i+" key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
            System.out.println("-----------------------");
        }
    }
    @Test
    public void testDateCheck(){
        String[] dic={"2002-01-31 00:00:00",//pass
                "2002-02-31 00:00:00",
                "2002-01-30",
                "2002-02-30",
                "20080303",
                "1999.1.1"};
        for (String date:dic) {
            System.out.println("-----------------------");
            ValidateMessage message = ValidateFunction.check(ValidateFunction._DATE_CHECK,"num",date);
            System.out.println("str: "+date+" key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
            System.out.println("-----------------------");
        }
    }
    @Test
    public void testNumberCheck(){
        String[] dic={"123",//pass
                "-123",//not pass
                "@#$%^",
                "0021",//pass
                "123123.123123123",
                "***123",
                "1/2",
                "1999.1.1",
                "h1",
                };
        for (String num:dic) {
            System.out.println("-----------------------");
            ValidateMessage message = ValidateFunction.check(ValidateFunction._NUMBER_CHECK,"num",num);
            System.out.println("str: "+num+" key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
            System.out.println("-----------------------");
        }

    }
    @Test
    public void testIntNumberCheck(){
        String[] dic={Integer.toString(Integer.MAX_VALUE),
                Integer.toString(Integer.MIN_VALUE),
                Integer.toString(Integer.MAX_VALUE+1),
                Integer.toString(Integer.MIN_VALUE-1),
                "0",
                "@#$%^",
                "0021",
                "123123.123123123",
                "***123",
                "1/2",
                "1999.1.1",
                "-123",
        };
        for (String intnum:dic) {
            System.out.println("-----------------------");
            ValidateMessage message = ValidateFunction.check(ValidateFunction._INTNUMBER_CHECK,"intNum",intnum);
            System.out.println("str: "+intnum+" key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
            System.out.println("-----------------------");
        }

    }
    @Test
    public void testUpCharCheck(){
        String[] dic={
                "a",
                "aa",
                "A",
                "AA",
                "Aa",
                "A1",
                "ABCCCCC",
                "&A",
        };
        LinkedList<String> dic2=new LinkedList<String>();
        for (int i = 64; i <123 ; i++) {
        char ch=(char)i;
        dic2.add(String.valueOf(ch));
        }
        for (String ch:dic) {
            System.out.println("-----------------------");
            ValidateMessage message = ValidateFunction.check(ValidateFunction._UPCHAR_CHECK,"upChar",ch);
            System.out.println("str: "+ch+" key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
            System.out.println("-----------------------");
        }

    }
    @Test
    public void testLowCharCheck(){
        String[] dic={
                "a",
                "aa",
                "A",
                "AA",
                "Aa",
                "A1",
                "ABCCCCC",
                "&A",
        };
        LinkedList<String> dic2=new LinkedList<String>();
        for (int i = 64; i <123 ; i++) {
            char ch=(char)i;
            dic2.add(String.valueOf(ch));
        }
        for (String ch:dic2) {
            System.out.println("-----------------------");
            ValidateMessage message = ValidateFunction.check(ValidateFunction._LOWCHAR_CHECK,"lowChar",ch);
            System.out.println("str: "+ch+" key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
            System.out.println("-----------------------");
        }

    }
    @Test
    public void testLetterCheck(){
        String[] dic={
                "Mike is LLL",
                "a",
                "aa",
                "A",
                "AA",
                "Aa",
                "A1",
                "ABCCCCC",
                "&A",
        };
        LinkedList<String> dic2=new LinkedList<String>();
        for (int i = 64; i <123 ; i++) {
            char ch=(char)i;
            dic2.add(String.valueOf(ch));
        }
        for (String ch:dic) {
            System.out.println("-----------------------");
            ValidateMessage message = ValidateFunction.check(ValidateFunction._LETTER_CHECK,"Letter",ch.toString());
            System.out.println("str: "+ch+" key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
            System.out.println("-----------------------");
        }

    }
    @Test
    public void testStrCheck(){
        String[] dic={
                "1",
                "1234567",
                "12345678",
                "123456789",
                "aaaaaaaa",
                "一二三四五六七八",
                "一二三四五六七八九",
                "@@@@@@@@",
                "12345678?",
                "、、、、、、】】",
                "........"
        };
        for (String ch:dic) {
            System.out.println("-----------------------");
            ValidateMessage message = ValidateFunction.check(ValidateFunction._STRING_CHECK,"String",ch.toString());
            System.out.println("str: "+ch+" key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
            System.out.println("-----------------------");
        }

    }
    @Test
    public void testChineseCheck(){
        String[] dic={
                "Mike is LLL",
                "张",//此例通过
                "1",
                "马云马大傻",
                "張",//此例通过
                "Aa",
                "吴吴",
                "ABCCCCC",
                "&A",
        };
        for (String ch:dic) {
            System.out.println("-----------------------");
            ValidateMessage message = ValidateFunction.check(ValidateFunction._CHINESE_CHECK,"Chinese",ch.toString());
            System.out.println("str: "+ch+" key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
            System.out.println("-----------------------");
        }

    }
    @Test
    public void testSpecialCheck(){
        String[] dic={
                " ",
                "a",
                "#",
                "A",
                "^",
                "/",
                "A1",
                "'",
                "&",
        };
        LinkedList<String> dic2=new LinkedList<String>();
        for (int i = 0; i <255 ; i++) {
            char ch=(char)i;
            dic2.add(String.valueOf(ch));
        }
        for (String ch:dic2) {
            System.out.println("-----------------------");
            ValidateMessage message = ValidateFunction.check(ValidateFunction._SPECIAL_CHECK,"Letter",ch.toString());
            System.out.println("str: "+ch+" key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
            System.out.println("-----------------------");
        }

    }
    @Test
    public void testChineseStringCheck(){
        String[] dic={
                "Mike is LLL",
                "张",//
                "1",
                "马云马大傻",
                "刘 大傻",//
                "張",//
                "Aa",
                "吴吴",
                "ABCCCCC",
                "&A",
        };
        for (String ch:dic) {
            System.out.println("-----------------------");
            ValidateMessage message = ValidateFunction.check(ValidateFunction._CHINESESTRING_CHECK,"Chinese",ch.toString());
            System.out.println("str: "+ch+" key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
            System.out.println("-----------------------");
        }

    }
    @Test
    public void testAccountNameCheck(){
        String[] dic={
                "Mike",
                "Mike_",
                "Mike_123",
                "Mike 123",
                "Mike-123",
                "NNN222@@$%&^*&",//
                "1",
                "马云马大傻",
                "刘 大傻",//
                "張",//
                "Aa",
                "1_333_12",
                "ABCCCCC",
                "&A",
        };
        for (String str:dic) {
            System.out.println("-----------------------");
            ValidateMessage message = ValidateFunction.check(ValidateFunction._ACCOUNTNAME_CHECK,"name",str);
            System.out.println("str: "+str+" key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
            System.out.println("-----------------------");
        }

    }
    @Test
    public void testMinusIntCheck(){
        String[] decimal={"-370222222222222222.1","-123","-0","22222.2","0.33",
                "-0.333","3.3.3",".3"};
        for (String str:decimal) {
            System.out.println("-----------------------");
            ValidateMessage message = ValidateFunction.check(ValidateFunction._MINUSINT_CHECK,"-int",str);
            System.out.println("str: "+str+" key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
            System.out.println("-----------------------");
        }
        for (Integer i = -10; i <100; i++) {
            System.out.println("-----------------------");
            ValidateMessage message = ValidateFunction.check(ValidateFunction._MINUSINT_CHECK,"num",i.toString());
            System.out.println("str: "+i+" key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
            System.out.println("-----------------------");
        }
    }
    @Test
    public void testFloatCheck(){
        String[] dic={
                "1.0",
                ".1",
                "0",
                " 0.2222222222222222222222222222222",
                "3.2.3",
                "999000",//
                "1.22",
                "1/2",
                "0100.1",//
                "-1.111111111111111"

        };
        for (String str:dic) {
            System.out.println("-----------------------");
            ValidateMessage message = ValidateFunction.check(ValidateFunction._FLOAT_CHECK,"float",str);
            System.out.println("str: "+str+" key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
            System.out.println("-----------------------");
        }

    }
    @Test
    public void testTXTCheck(){
        String[] dic={
                "x.txt",
                "1.txt",
                "E:\\1.txt",//pass
                "E:\\ ",
                "mo.doc",
                "E:\\mo.doc ","http://blog.csdn.net/21aspnet/"

        };
        for (String str:dic) {
            System.out.println("-----------------------");
            ValidateMessage message = ValidateFunction.check(ValidateFunction._TXT_CHECK,"txt路径",str);
            System.out.println("str: "+str+" key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
            System.out.println("-----------------------");
        }

    }
    @Test
    public void testColorCheck(){
        String[] dic={
                "#FF0000",
                "FF0000",
                "#FF1000",
                "#FF999 ",
                "#FFB6C1"
                ,"http://blog.csdn.net/21aspnet/"

        };
        for (String str:dic) {
            System.out.println("-----------------------");
            ValidateMessage message = ValidateFunction.check(ValidateFunction._COLOR_CHECK,"color",str);
            System.out.println("str: "+str+" key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
            System.out.println("-----------------------");
        }

    }
    @Test
    public void testMd5Check(){
        String[] dic={
                "e452d6e5ef6878a3",
                "788d6236e452d6e5ef6878a328de37ee",//pass
                "E452D6E5EF6878A3",
                " 788D6236E452D6E5EF6878A328DE37EE",
                "4BCD68C13BEFAD2BEBC6713ADB69B61C"//pass
                ,"http://blog.csdn.net/21aspnet/"

        };
        for (String str:dic) {
            System.out.println("-----------------------");
            ValidateMessage message = ValidateFunction.check(ValidateFunction._MD5_CHECK,"md5",str);
            System.out.println("str: "+str+" key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
            System.out.println("-----------------------");
        }

    }
    @Test
    public void testTimeCheck(){
        String[] dic={
                "12:23",
                "12:60",
                "24:00",
                "00:00",
                "11:99",
                "12.22"
        };
        for (String str:dic) {
            System.out.println("-----------------------");
            ValidateMessage message = ValidateFunction.check(ValidateFunction._TIME_CHECK,"time",str);
            System.out.println("str: "+str+" key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
            System.out.println("-----------------------");
        }

    }
    @Test
    public void testQQCheck(){
        String[] dic={
                "10000",
                "9999",
                "111111111",
                "1111111111",
                "111111111111",
                "1111111111111"
        };
        for (String str:dic) {
            System.out.println("-----------------------");
            ValidateMessage message = ValidateFunction.check(ValidateFunction._QQ_CHECK,"qq",str);
            System.out.println("str: "+str+" key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
            System.out.println("-----------------------");
        }

    }
    @Test
    public void testHexCheck(){
        String[] dic={
                "0x1e0f3",//123123
                "0x0",
                "0x11f7ced916872b",
                "0x1111111111",
                "111111111111",
                "1111111111111",
                "#FF0000",
                "FF0000",
                "#FF1000",
                "#FF999 ",
                "#FFB6C1"
        };
        for (String str:dic) {
            System.out.println("-----------------------");
            ValidateMessage message = ValidateFunction.check(ValidateFunction._HEX_CHECK,"hex",str);
            System.out.println("str: "+str+" key: "+message.getKey()+", message: "+message.getMessage()+", result: "+message.getResult());
            System.out.println("-----------------------");
        }

    }

}