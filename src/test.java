import java.util.Random;

/**
 * Created by arthurdecloedt on 26/05/17.
 */
public class test {


    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {MeetkundeMain.main(new String[]{});}

        if(true) return;
        Random random = new Random();
        for (int i = 0; i < 250; i++) {
            double r1 =10 * random.nextDouble();
            double r2 =10 * random.nextDouble();
            double r3 =10 * random.nextDouble();
            System.out.println(r1+" "+r2+" "+r3);
        }
    }
}
