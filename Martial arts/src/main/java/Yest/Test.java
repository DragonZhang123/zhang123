package Yest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Test {
    void test(){
        try {

        } catch (Exception e){

        }


    }
    public static List<TcmFilesBase> addList(List<TcmFilesBase> tcmFilesBase, String currentUserName) {
        List<TcmFilesBase> list= new ArrayList<>();
        tcmFilesBase.forEach((TcmFilesBase fileBase)->{
            fileBase.setCrtUser(currentUserName);
            fileBase.setFileId(1L);
            fileBase.setCrtTime(new Date());
            Long fileId = new Date().getTime()+1;
            fileBase.setFileId(fileId);
            list.add(fileBase);
        });
        return list;
    }

    public static void main(String[] args) {
        List<TcmFilesBase> list = new ArrayList<>();
        list.add(new TcmFilesBase(new Date().getTime(),"111"));
        list.add(new TcmFilesBase(new Date().getTime(),"222"));
        list.add(new TcmFilesBase(new Date().getTime(),"333"));
        List<TcmFilesBase> list1 = addList(list, "me");
       /* for (TcmFilesBase tcmFilesBase : list1) {
            System.out.println(tcmFilesBase.toString());
        }*/
       List<String> stringList = Arrays.asList("111","222","333");
        System.out.println(NumberOf1Between1AndN_Solution(2048));
    }
    public static int NumberOf1Between1AndN_Solution(int n) {
        if(n<=0)
            return 0;

        int count = 0;
        while(n>0)
        {
            String str = String.valueOf(n);
            char[] chars = str.toCharArray();
            for(int i=0; i<chars.length; i++)
            {
                if(chars[i] == '1')
                    count++;
            }
            n--;
        }
        return count;
    }

}
