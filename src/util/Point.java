package util;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Created by arthurdecloedt on 20/05/17.
 */
public class Point {

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public final double x;
    public final double y;

    public static double distance(Point a, Point b){
        return sqrt(pow(a.x-b.x,2)+pow(a.y-b.y,2));
    }

    public boolean equals(Point p){

        long xr=Math.round(this.x*10000);
        long yr=Math.round(this.y*10000);
        long xpr=Math.round(p.x*10000);
        long ypr=Math.round(p.y*10000);
        return (xr==xpr && yr==ypr);

    }

    @Override
    public String toString() {
        return "x " + x+"y "+y;
    }

    @Override
    public int hashCode() {
        return ((int)(x*10000))*31+(int)(y*10000);
    }
}
