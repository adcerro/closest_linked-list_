package closest.pair;

public final class Point implements Comparable<Point> {

    private int x;
    private int y;
/**
 * Generates a point, with the provided x and y coordinates.<p>
 * These coordinates are integers and cannot be modified <p>
 * Inputs: and x and a y integers <p>
 * Outputs: A point object with the specified coordinates
 * @param x  An integer
 * @param y  Another integer
 * */
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
/**
 * This method checks first if an object is an instance of the Point class.<p>
 * If that's the case it compares the x and y values of both point, if all coincide returns true<p>
 * If not all values coincide or the object is not an instance of the point class then returns false.<p>
 * Input: An object(Presumably a point) <p>
 * Output: Whether the object matches with the point.
 * @param obj  The object to compare.
 * */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof  Point){
            Point checker = (Point) obj;
            if(checker.getX()== this.getX() && checker.getY()== this.getY()){
                return true;
            }else {
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    /**
     * This implementation fo comparable prevents the existence of two points with the same x value<p>
     * Input: Another point to compare<p>
     * Output: The difference between the point's x and the provided point x's value <p>
     * */
    public int compareTo(Point o) {
        return this.x - o.x;
    }

}
