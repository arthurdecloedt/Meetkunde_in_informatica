import util.Circle;
import util.Point;

import java.util.Comparator;
import java.util.List;
import java.util.Set;


/**
 * Created by arthurdecloedt on 20/05/17.
 */
public abstract class Alg {


    public long deltat;

    public static Alg Create(int mode) {

        switch (mode) {
            case 1:
                return new Alg1();

            case 3:
                return new Alg2();

            default:
                return new Alg2();

        }
    }


    public abstract void init(List<Circle> circleList);

    public abstract Set<Point> getSolutions();

    public abstract void run();

    public static Comparator<Event> eventComparatorxminasc =
            (o1, o2) -> {
                double x1 = o1.xval;
                double x2 = o2.xval;
                return Double.compare(x1, x2);
            };


    public static Comparator<Circle> circleComparatoryminasc=
            (o1, o2) -> {
                double y1 = o1.down;
                double y2 = o2.down;
                return Double.compare(y1, y2);
            };



}
