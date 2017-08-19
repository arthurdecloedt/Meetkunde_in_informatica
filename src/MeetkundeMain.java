import util.Circle;
import util.Point;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by arthurdecloedt on 20/05/17.
 */
public class MeetkundeMain {

    private String inputFileName="1";

    public int mode=0;
    public int n;
    public List<Circle> circleList=new ArrayList<>();
    public Alg solver;
    public String outputfilename="uitvoercirkels2.txt";


    public static void main(String[] args) {
        MeetkundeMain meetkundeMain = new MeetkundeMain();
        meetkundeMain.run();

    }

    private void run() {
        BufferedReader input;
        try {
            input = new BufferedReader(new FileReader(new File(inputFileName)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error Finding File");
        }
        try {
            String s = input.readLine();
            mode= Integer.parseInt(s);
            mode=2;
            assert (mode>0 && mode<4);

            s = input.readLine();
            n= Integer.parseInt(s);
            while (input.ready()){
                s = input.readLine();
                String[] c =s.split(" ");
                double x = Double.parseDouble(c[0]);
                double y = Double.parseDouble(c[1]);
                double r = Double.parseDouble(c[2]);
                Circle circle = new Circle(x,y,r);
                //System.out.println(circle);
                circleList.add(circle);
            }
            assert circleList.size()==n;
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error Reading From File");
        }
        if(mode==3){
            outputNotImplemented();
            return;
        }
        solver = Alg.Create(mode);
        solver.init(circleList);
        solver.run();
        Set<Point> solset=solver.getSolutions();
        System.out.println(solset.size());

        output(solset,solver);
    }

    private void outputNotImplemented() {
        PrintWriter output=null;
        try {
            output = new PrintWriter(this.outputfilename, "UTF-8");
            output.println(" Dit algoritme is niet ge ´ ¨ımplementeerd.");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        finally {
            output.close();
        }
    }

    public void output(Set<Point> solset,Alg alg){
        PrintWriter output=null;
        try {
            Set<Integer> hashset=new HashSet<>();
            output= new PrintWriter(this.outputfilename, "UTF-8");
            for (Point p :
                    solset) {
                if(true){
                    int hash=p.hashCode();
                    if (hashset.contains(hash)) continue;
                    hashset.add(hash);
                }
                output.println(p.x + " " + p.y);
            }
            output.println('\r');
            output.println(alg.deltat);
            output.flush();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            output.close();
        }
    }


}
