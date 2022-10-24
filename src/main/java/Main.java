import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        char[] set = {'a', 'b', 'c', 'd','e', 'f', 'g', 'h'};
        Scanner scn = new Scanner(System.in);
        System.out.print("How Many Strings Do You Need?: ");
        int wantedStringNum=scn.nextInt();
        System.out.print("Min Lenght: ");
        int min=scn.nextInt();
        System.out.print("Max Lenght: ");
        int max = scn.nextInt();

        Generate.clearFile("100k");
        Generate.clearFile("50k");
        Generate.clearFile("5k");

        Generate g1 = new Generate(max,min,wantedStringNum*1000,set,"100k");
        Thread t1 = new Thread(g1);
//        g1.run();

        Generate g2 = new Generate(max,min,wantedStringNum*100,set,"50k");
        Thread t2 = new Thread(g2);
//        g2.run();

        Generate g3 = new Generate(max,min,wantedStringNum,set,"5k");
        Thread t3 = new Thread(g3);
//        g3.run();

        t1.start();
        t2.start();
        t3.start();

    }




}
