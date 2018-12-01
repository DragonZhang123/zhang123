package mathPro;

public class Demo1 {
    public static void main(String[] args) {
        int min =1 ;
        int max =9 ;
        for (int i = min; i <=max ; i++) {
            for(int j =min;j<=max;j++){
                int result = i + j;
                if (i!=j && result<=max && i!=result &&j!=result){
                    System.out.printf("结果：%d + %d = %d \n",i,j,result);
                }
            }
            
        }

    }
}
