package MyInterviewQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhangguanlong on 2017/12/26.
 */

/**
 * 小易有一个长度为n序列，小易想移除掉里面的重复元素，
 * 但是小易想是对于每种元素保留最后出现的那个。小易遇到了困难,希望你来帮助他
 * 输入描述:
 输入包括两行： 第一行为序列长度n(1 ≤ n ≤ 50) 第二行为n个数sequence[i](1 ≤ sequence[i] ≤ 1000)，以空格分隔


 输出描述:
 输出消除重复元素之后的序列，以空格分隔，行末无空格

 输入例子1:
 9 100 100 100 99 99 99 100 100 100

 输出例子1:
 99 100

 */
public class RepeatElement {
    /**
     * 使用Scanner接收控制台输入
     难点应该是要求中的对于每种元素保留最后出现的那个这一句：
     像出现如下情况时：100 100 99 11 11 11，移除重复元素必然是：100 99 11
     而若出现这种情况：100 100 100 99 99 99 100 100 100，
     为满足 对于每种元素保留最后出现的那个 这一要求，三个99前后都出现了100，
     这时只能保留99后面的100，即 99 100；
     只需从后往前遍历给定的数组即可满足对于每种元素保留最后出现的那个这一要求，
     用一个ArrayList保存合并重复元素后的集合，
     每往前遍历一个元素先判断该元素是否已经存在集合中，不存在就添加到集合中。
     遍历结束要将集合倒序输出，因为遍历的时候对目标数组的遍历是从后往前的，
     加入到集合的顺序也是从后往前的，而输出时应该从前往后输出。
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        String sou = scanner.nextLine();
        String[] strs = sou.split(" ");
        int[] nums = new int[count];
        int i = 0;
        for (String s : strs) {
            nums[i++] = Integer.parseInt(s);
        }

        List<Integer> list = new ArrayList<>();
        i = 0;
        for (int j = nums.length - 1; j >= 0; j--) {
            if (!list.contains(nums[j]))
                list.add(i++, nums[j]);
        }

        for (int j = list.size() - 1; j >= 0; j--) {
            String out = j == 0 ? list.get(j) + "" : list.get(j) + " ";
            System.out.print(out);
        }

    }
}
