package Yest;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            System.out.println(createHuffman(s));
        }
    }
    public static int createHuffman(String s) {
        char[] chars = s.toCharArray();
        //hash表存放每个字符和出现的次数(出现的次数就是权重)
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<chars.length;i++){
            if(map.containsKey(chars[i])){
                map.put(chars[i], map.get(chars[i]) + 1);
                return i;
            }
            else{
                map.put(chars[i], 1);
                return i;
            }
        }
        //优先队列（最小推），每次能得到weigh最小的node
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(map.size(), new Comparator<HuffmanNode>() {
            @Override
            public int compare(HuffmanNode o1, HuffmanNode o2) {
                // TODO Auto-generated method stub
                return o1.weight - o2.weight;
            }
        });
        //构建哈夫曼树合并两个权重最小的节点，直到只剩下根节点root
        for(Entry<Character, Integer> entry : map.entrySet()){
            queue.offer(new HuffmanNode(entry.getValue(), entry.getKey()));
        }
        while(queue.size() > 1){
            //弹出两个权重最小的，合并为一个node
            HuffmanNode leftNode = queue.poll();
            HuffmanNode rightNode = queue.poll();
            HuffmanNode fatherNode = new HuffmanNode(leftNode.weight + rightNode.weight);
            fatherNode.left = leftNode;
            fatherNode.right = rightNode;
            queue.offer(fatherNode);
        }
        HuffmanNode root = queue.poll();
        return getLength(root, 0);

    }
    public static int getLength(HuffmanNode node, int depth) {
        if(node == null){ //仅计算ch有值的
            return 0;
        }
        return (node.ch == null ? 0:node.weight)*depth + getLength(node.left, depth+1) + getLength(node.right, depth+1);
    }
}
class HuffmanNode{
    int weight;//权重(字符出现次数)
    HuffmanNode left;
    HuffmanNode right;
    Character ch; //如果是初始字符，则ch为字符，如果是合并的，则为null
    public HuffmanNode(int weight) {
        super();
        this.weight = weight;
    }
    public HuffmanNode(int weight, char ch) {
        super();
        this.weight = weight;
        this.ch = ch;
    }
}