package refactorBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionService {
//   1.按照价格筛选大于1000 的
//   2.按照币种进行分类
    private static  Map<String,List<Transaction>> demo(List<Transaction> transactions){
        Map<String, List<Transaction>> mapByCurrency = new HashMap<>();
        for (Transaction transaction : transactions) {
            if (transaction.getPrice()>1000){
                String currency = transaction.getCurrency();
                List<Transaction> transactionByCurrency = mapByCurrency.get(currency);
                if (transactionByCurrency == null) {
                    transactionByCurrency = new ArrayList<>();
                    mapByCurrency.put(currency,transactionByCurrency);
                }
            }
        }
        return mapByCurrency;

    }

    public static void main(String[] args) {
        List<Transaction> list= new ArrayList<>();
        list.add(new Transaction(550,"CNY"));
        list.add(new Transaction(1100,"CNY"));
        list.add(new Transaction(1200,"USD"));
        list.add(new Transaction(1300,"CNY"));
        list.add(new Transaction(800,"CNY"));
        list.add(new Transaction(8000,"USD"));
        list.add(new Transaction(600,"CNY"));
        list.add(new Transaction(700,"USD"));
        list.add(new Transaction(500,"USD"));
        Map<String, List<Transaction>> listMap = TransactionService.demo(list);
        System.out.println(listMap);


    }

}
