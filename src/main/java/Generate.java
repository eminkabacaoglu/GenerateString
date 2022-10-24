import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Generate implements Runnable{

    public int max;
    public int min;
    public int wantedStringNum;
    public char[] set ;
    public String str;
    public Generate(int max,int min,int wantedStringNum,char[] set,String str) {
        this.max=max;
        this.min=min;
        this.wantedStringNum=wantedStringNum;
        this.set=set;
        this.str=str;
    }

    @Override
    public void run() {
        try {
            checkCombination(max,min,wantedStringNum,set);
            for(int i =min;i<=max;i++){
                writeAllKLength(set, i);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        writeToFile(wantedStringNum);
    }

    public  boolean  checkCombination(int max,int min, int wantedStringNum, char[] set) throws Exception {
        int sum=0;
        for(int j=min;j<=max;j++){
            sum+=Math.pow(set.length,j);
        }
        if(sum>=wantedStringNum){
            return true;
        }
        else {
            throw new Exception("Bigger than combination");

        }

    }
    public void writeAllKLength(char[] set, int k)
    {
        int n = set.length;
        writeAllKLengthRec(set, "", n, k);

    }

    public List<String> strings = new ArrayList<String>();
    public void writeAllKLengthRec(char[] set, String prefix, int n, int k) {
        if (k == 0)
        {
            strings.add(prefix);
            return;
        }

        for (int i = 0; i < n; ++i)
        {
            String newPrefix = prefix + set[i];
            writeAllKLengthRec(set, newPrefix, n, k - 1);
        }
    }


    public void writeToFile(int wanted)
    {
        Collections.shuffle(strings);
        for (int i=0;i<wanted;i++){
            try {
                FileOutputStream output = new FileOutputStream(str+".txt",true);
                byte[] yaziByte = (strings.get(i)+"\n").getBytes();
                output.write(yaziByte);
                output.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(str+" Created");

    }

    static void clearFile(String str){
        try
        {
            File f= new File(str+".txt");
            if(f.delete())
            {
                System.out.println(f.getName() + " deleted");
            }
            else
            {
                System.out.println("failed");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
