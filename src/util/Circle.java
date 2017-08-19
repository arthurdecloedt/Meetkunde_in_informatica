package util;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
public class Circle {


    public final Point p;
    public final double right;
    public final double left;
    public final double down;
    public final double up;


    public Circle(Point p, double r) {
        this.p = p;
        this.r = r;
        this.left=getX()-r;
        this.right=getX()+r;
        this.down=this.getY()-r;
        this.up=this.getY()+r;
    }

    public Circle(double x, double y, double r) {
        this.p = new Point(x, y);
        this.r = r;
        this.left=x-r;
        this.right=getX()+r;
        this.down=this.getY()-r;
        this.up=this.getY()+r;

    }



    public double getX() {
        return p.x;
    }

    public double getY() {
        return p.y;
    }

    public final double r;


    public static Set<Point> getIntersects(Circle c1, Circle c2) {
        return getIntersects(c1.p, c2.p, c1.r, c2.r);
    }

    public static Set<Point> getIntersects(Point p1, Point p2, double r0, double r1) {
        double x0 = p1.x;
        double y0 = p1.y;
        double x1 = p2.x;
        double y1 = p2.y;
        Set<Point> solutions = new HashSet<>();



        double d = sqrt(pow((x1 - x0), 2) + pow((y1 - y0), 2));

        double a = (pow(r0,2) - pow(r1,2) + pow(d,2)) / (2 * d);
        double c=pow(r0,2) - pow(a,2);
        double h = sqrt(pow(r0,2) - pow(a,2));
        double x2 = x0 + a * (x1 - x0) / d;
        double y2 = y0 + a * (y1 - y0) / d;
        double x3 = x2 + h * (y1 - y0) / d;
        double y3 = y2 - h * (x1 - x0) / d;
        double x4=x2-h*(y1-y0)/d;
        double y4=y2+h*(x1-x0)/d;
        solutions.add(new Point(x4, y4));
        solutions.add(new Point(x3, y3));
        if (Double.isNaN(x3)){
            System.err.println("nan");
        }
        return solutions;
    }

    public static boolean willIntersect(Circle c1, Circle c2) {
        if (c1.equals(c2)) {
            return false;
        }
        if (c1.p.equals(c2.p)) {
            return false;
        }
        double dist =Point.distance(c1.p, c2.p);
        if (dist <= c1.r + c2.r &&dist>=Math.abs( c1.r-c2.r)) {

            return true;
        }
        return false;
    }
    public static boolean willIntersecp(Circle c1, Circle c2) {


        boolean r = willIntersect(c1, c2);
        System.out.println("intersect+" + r);
        return r;

    }
    public boolean equalp(Circle c) {


        boolean r = this.equals(c);
        System.out.println("equals+"+r);
        return r;
    }

    public boolean equals(Circle c) {
        return (c.getX()==getX()&&c.getY()== getY()&&c.r==r);
    }

    @Override
    public String toString() {
        return "x " + getX()+"y "+getY()+"r "+r;
    }


}
