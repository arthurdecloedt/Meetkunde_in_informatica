import util.Circle;
import util.Point;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by arthurdecloedt on 20/05/17.
 */
public class Alg1 extends Alg {

    public List<Circle> circleList;
    public boolean hasRun=false;
    public Set<Point> solSet;


    @Override
    public void init(List<Circle> circleList) {
        this.circleList=circleList;
        solSet=new HashSet<>();

    }

    @Override
    public Set<Point> getSolutions() {
        assert hasRun;
        return solSet;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        for (Circle c1 :
                circleList) {
            for (Circle c2 :circleList
                 ) {
                    if(c1.equals(c2)) continue;

                    if (Circle.willIntersect(c1,c2)) solSet.addAll(Circle.getIntersects(c1, c2));
            }
        }
        this.deltat = System.currentTimeMillis() - startTime;
        System.out.println("timerun:="+deltat);

        hasRun=true;
    }
}
