import util.Circle;
import util.Point;

import java.util.*;

/**
 * Created by arthurdecloedt on 20/05/17.
 */
public class Alg2 extends Alg {

    public List<Circle> circleList;
    public LinkedList<Event> eventqueue;
    public boolean hasRun=false;
    public Set<Point> solSet=new HashSet<>();
    public SortedMap<Double,Circle> sweeplineStatus;

    @Override
    public void init(List<Circle> circleList) {
        this.circleList=circleList;
        eventqueue=new LinkedList<>();
        for (Circle circle :
                circleList) {
            eventqueue.add(new Event(circle,true));
            eventqueue.add(new Event(circle,false));
        }
        eventqueue.sort(eventComparatorxminasc);
        this.sweeplineStatus=new TreeMap<>();

    }

    @Override
    public Set<Point> getSolutions() {
        if (!hasRun) return null;

        return solSet;

    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        sweepline();
        hasRun=true;
        this.deltat = System.currentTimeMillis() - startTime;
        System.out.println("timerun:="+deltat);
        return;

    }

    public void sweepline(){

        for (Event event :
                eventqueue) {
            if (event.begin) this.beginEvent(event);
            else this.endEvent(event);

        }

    }

    private void endEvent(Event event) {
        this.sweeplineStatus.remove(event.circle.down,event.circle);
        Circle circle=event.circle;
        this.rangequery(circle);


    }

    private void beginEvent(Event event) {
        Circle circle=event.circle;
        //this.rangequery(circle);
        sweeplineStatus.put(circle.up,circle);

    }

    private void rangequery(Circle circle) {
        SortedMap<Double,Circle> submap;
        submap=sweeplineStatus.subMap(circle.down, circle.up);

        for (Circle circle2 :
                submap.values()) {
            if (Circle.willIntersect(circle,circle2)){
                solSet.addAll(Circle.getIntersects(circle,circle2));
            }

        }
    }
}
