import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Test {
    public List<Integer> hongbao(Integer totalmoney, Integer totalpeople){
        Integer restmoney=totalmoney;
        Integer restpeople=totalpeople;
        List <Integer> list=new ArrayList<>();
        Random random=new Random();

        for (int i=0;i<totalpeople-1;i++){
            int amount=random.nextInt(totalmoney/totalpeople*2-1)+1;
            restmoney-=amount;
            restpeople--;
            list.add(amount);
        }
        list.add(restmoney);
        return list;
    }
    public static void main(String[] args) {


        List<Integer> list= new Test().hongbao(100,16);
        for (Integer people :list){
            try {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("抢到了"+new BigDecimal(people).divide(new BigDecimal(1)) );
                    }
                }).start();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        System.out.println("手慢的四人没抢到");


    }
}




