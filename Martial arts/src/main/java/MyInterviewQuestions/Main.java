package MyInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhangguanlong on 2017/12/26.
 */
import java.util.*;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] xs=new int[n];
        int[] ys=new int[n];

        for(int i=0;i<n;i++){
            xs[i]=scanner.nextInt();
            ys[i]=scanner.nextInt();
        }

        for(int i=1;i<xs.length;i++){
            for(int j=0;j<xs.length-i;j++){
                if(xs[j+1]<xs[j]){
                    int xt=xs[j];
                    int yt=ys[j];

                    xs[j]=xs[j+1];
                    xs[j+1]=xt;

                    ys[j]=ys[j+1];
                    ys[j+1]=yt;

                }
            }
        }
        maxPoint(xs, ys);
    }

    public static void maxPoint(int[] xs,int[] ys){

        ArrayList<Integer> listX=new ArrayList<Integer>();
        ArrayList<Integer> listY=new ArrayList<Integer>();

        for(int i=0;i<xs.length;i++){
            int x=xs[i];
            int y=ys[i];//第i个点的坐标

            for(int j=0;j<xs.length ;j++){ //去掉第i个点
                if(xs[j]>x && ys[j]>y){
                    break;
                }
                if(j==xs.length-1){
                    listX.add(x);
                    listY.add(y);
                }
            }

        }
        for (int i = 0; i < listX.size(); i++) {
            System.out.println(listX.get(i)+" "+listY.get(i));
        }
    }
}