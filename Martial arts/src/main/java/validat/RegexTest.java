package validat;



import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式专用测试类
 * Created by elwin on 2017/10/31.
 */
public class RegexTest {

   /* @Test
    public void testSqlHandel(){
        System.out.println(new Date().getTime());
        for(int i=0;i<1;i++){

            String normalSql ="select * from table1   where   [#{userName}? user_name>=#{userName}] or [#{passWord}? pass_word=#{passWord}]";

            normalSql = normalSql.replaceAll(" +"," ");

            String regex1 = "\\[[a-zA-Z0-9_\\#\\{\\}\\=\\>\\?\\(\\)\\<\\s+]+]";

            String regex4 ="\\#\\{[a-zA-Z0-9_]+\\}\\?";

            String regex5 ="[a-zA-Z0-9_\\#\\{\\}\\=\\>\\?\\(\\)\\<\\s+]";

            Map<String ,Object> map  = new HashMap<String, Object>();
            map.put("userName","admin");
            map.put("passWord","woulderful");
            Pattern pattern = Pattern.compile(regex1);
            Matcher matcher = pattern.matcher(normalSql);
            while(matcher.find()){
                String matchWord = matcher.group(0);

                String new_String=matchWord;
                Pattern pattern1 = Pattern.compile(regex4);
                Matcher matcher1 = pattern1.matcher(new_String);
                while(matcher1.find()){
                    String tmp = matcher1.group(0);

                    String key = tmp.substring(2,tmp.length()-2);

                    if(map.get(key)!=null){
                        new_String = matchWord.replace(tmp,"");
                        new_String = new_String.substring(2,new_String.length()-1);
                    }else{
                        new_String ="";
                    }

                    normalSql=normalSql.replace(matchWord,new_String);
                }

            }


            normalSql = normalSql.replaceAll("\\s+"," ");

            if(normalSql.contains("where and")){

                normalSql= normalSql.replace("where and" ,"where");
            }
            if(normalSql.contains("where or")){

                normalSql= normalSql.replace("where or" ,"where");
            }



            System.out.println(normalSql);


        }

        System.out.println(new Date().getTime());
    }


    @Test
    public void testSQLChange(){
        String sql ="select (select ab,tc,td from tbl where tt=1) from (select * from tbl1 left jon ttt  on where a=b and c =d and f=2 where t3=1 )";

        String regex = "\\[[a-zA-Z0-9_\\#\\{\\}\\=\\>\\?\\(\\)\\<\\s+]+]";

        String  mainBody="select.*?from";
        Pattern pattern = Pattern.compile(mainBody);
        Matcher matcher = pattern.matcher(sql);

        while(matcher.find()){
            String matchWord = matcher.group(0);
            System.out.println("matchWord="+matchWord);
        }
        String sql1  = sql.replaceFirst(mainBody,"select count(0) from ");
        System.out.println(sql1);
    }

    @Test
    public void testAviatorHande2(){
       Object a = AviatorEvaluator.exec("a>b+c? h:m", 6,4,1,"woulderful","hello");
        System.out.println(a);

        Map<String, Object> env = new HashMap<String, Object>();

        Map<String, Object> test = new HashMap<String, Object>();
        test.put("name","zhangsan");
        test.put("age",18);
        Map<String, Object> test1 = new HashMap<String, Object>();
        test1.put("name","zhangsan");
        test1.put("age",18);
        Map<String, Object> test2 = new HashMap<String, Object>();
        test2.put("name","zhangsan");
        test2.put("age",18);
        Map<String, Object> test3 = new HashMap<String, Object>();
        test3.put("name","zhangsan");
        test3.put("age",18);
        List<Map<String,Object>>list  = new ArrayList<Map<String, Object>>();
        list.add(test);
        list.add(test1);
        list.add(test2);
        env.put("list", list);
        Object result = AviatorEvaluator.execute("count(list)", env);
        System.out.println(result);  // 3
        System.out.println(AviatorEvaluator.execute("list[0]", env));   // hello world

        Map<String,Object> aaa = (Map<String,Object>)AviatorEvaluator.execute("list[0]", env);
        System.out.println(aaa.get("age"));  // 3

    }*/




}
