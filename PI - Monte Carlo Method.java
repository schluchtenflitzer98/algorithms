package fun;

import java.util.Random;

public class Pi {

    public static void main(String[] args) {

        Random rnd = new Random();

        double hit = 0;
        double trials = 0;
        int loop = 1000000000; //1.000.000.000
        double x;
        double y;
        double curr;

        for(int i = 0; i < loop;i++) {
            x = rnd.nextDouble();
            y = rnd.nextDouble();

            curr = Math.sqrt(((x * x) + (y * y)));

                    if(curr <= 1){
                        hit++;
                    }

                    trials++;

        }

        System.out.println("Value: " + (4 * (hit/trials)));

    }

}
