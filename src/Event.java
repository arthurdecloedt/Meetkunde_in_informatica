import util.Circle;

/**
 * Created by arthurdecloedt on 26/05/17.
 */
public class Event {


    public final Circle circle;

    public final boolean begin;

    public boolean isEnd(){
        return !begin;
    }
    public Event(Circle circle, boolean begin) {
        this.circle = circle;
        this.begin = begin;
        if (begin) this.xval=circle.left;
        else this.xval=circle.right;
    }
    public final double xval;

    @Override
    public String toString() {
        return "xval: "+ xval +" is begin: "+begin +" circle: "+circle.toString();
    }
}
