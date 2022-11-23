package closest.pair;

import java.util.Iterator;

public class Distance {

    private long iter = 0;

    public void resetCounter() {
        iter = 0;
    }

    /**
     * The following void takes the two linkedLists that divide all the points and checks for the points that have a
     * distance in x with the closest point to the division that is lower than the closest distance found before (storing them in a
     * linkedList for each group). Then it compares each point of one of those linkedLists against all the others in the other.<p>
     * If the distance of the points compared is lower than the one found before then the array containing the closest points
     * stores the new distance and the points.
     * Input: Two linkedLists containing a subgroup of all points each and an array with the preliminary closest distance.<P>
     * Output: An array with the closest distance of all points.
     *
     * @param dist  An array containing the closest distance found and coordinates of the points that have it
     * @param listA The linkedList containing the first group of the points
     * @param listB The linkedList containing the second group of the points
     */
    public void bruteForce(LinkedList<Point> listA, LinkedList<Point> listB, double[] dist) {
        LinkedList<Point> firstGroup = discard(listA, listA.size() - 1, dist[0]);
        LinkedList<Point> secondGroup = discard(listB, 0, dist[0]);
        Iterator<Point> fiterator = firstGroup.iterator();
        Iterator<Point> siterator = secondGroup.iterator();
        boolean checker =true;
        while (fiterator.hasNext() && siterator.hasNext() && checker) {
            Point pointF = fiterator.next();
            Point pointS = siterator.next();
            if(distance(pointF,pointS)<dist[0]){
                dist[0] = distance(pointF, pointS);
                dist[1] = pointF.getX();
                dist[2] = pointF.getY();
                dist[3] = pointS.getX();
                dist[4] = pointS.getY();
                System.out.println("Pair in between groups found!");
                System.out.println("The points (" + dist[1] + ", " + dist[2] + ") and (" + dist[3] + ", " + dist[4] + ")");
                System.out.println("Distance:" + dist[0] + "\n");
            }else{
                checker = false;
            }
            iter++;
        }
    }

    /**
     * The following method checks if the points of a linkedList have a distance x distance with the specified element of the
     * linkedList that is lower than the specified distance, if so, it adds the point to the linkedList it returns.<p>
     * Inputs: The source linkedList,the index of the element that is used to measure the distance and the closest distance previously found.<p>
     * Output: The linkedList for the results filled with the points that match the criteria.
     *
     * @param list  The linkedList containing all the points
     * @param index The index of the element to calculate distance
     * @param dist  The distance criteria
     * @return A linkedList with the points that match the criteria.
     */
    public LinkedList<Point> discard(LinkedList<Point> list, int index, double dist) {
        if (index >= list.size() || index < 0) {
            throw new IndexOutOfBoundsException("");
        } else {
            LinkedList<Point> result = new LinkedList<Point>();
            discard(list.iterator(), list, result, index, dist);
            return result;
        }
    }

    /**
     * The following void checks if the points of a linkedList have a distance x distance with the specified element of the
     * linkedList that is lower than the specified distance, if so, it adds the point to a separate linkedList<p>
     * Inputs: The iterator of the source linkedList, the source linkedList, the linkedList for the results, the index of the
     * element that is used to measure the distance and the closest distance previously found.<p>
     * Output: The linkedList for the results filled with the points that match the criteria.
     *
     * @param a     The iterator of the linkedList
     * @param list  The linkedList containing all the points
     * @param listF The linkedList that will store all points that match the criteria
     * @param index The index of the element to calculate distance
     * @param dist  The distance criteria
     */
    private void discard(Iterator<Point> a, LinkedList<Point> list, LinkedList<Point> listF, int index, double dist) {
        if (a.hasNext() && Math.abs(list.get(index).getX() - a.next().getX()) < dist) {
            listF.add(a.next());
            discard(a, list, listF, index, dist);
        }

    }

    /**
     * The following method iterates through the linkedList comparing each point
     * with the others and determines which pair has the minimal distance of all
     * and stores the pair and their distance in an array like this:<p>
     * [distance | firstPointX | firstPointY | secondPointX | secondPointY]<p>
     * input: The linkedList with all the points.<p>
     * output: An array with the closest pair and their distance.
     *
     * @param list A linkedList containing all the points.
     * @return An array containing the distance in the first position and the points' coordinates in the rest of the array.
     */
    public double[] bruteForce(LinkedList<Point> list) {
        double[] closestD = new double[5];
        closestD[0] = distance(list.get(0), list.get(1));
        closestD[1] = list.get(0).getX();
        closestD[2] = list.get(0).getY();
        closestD[3] = list.get(1).getX();
        closestD[4] = list.get(1).getY();
        for (int j = 0; j < list.size() - 1; j++) {
            Point pj = list.get(j);
            for (int i = list.indexOf(pj) + 1; i < list.size(); i++) {
                if (distance(pj, list.get(i)) < closestD[0]) {
                    closestD[0] = distance(pj, list.get(i));
                    closestD[1] = pj.getX();
                    closestD[2] = pj.getY();
                    closestD[3] = list.get(i).getX();
                    closestD[4] = list.get(i).getY();
                }
                iter++;
            }
        }
        return closestD;
    }

    /**
     * The following method iterates through the linkedList and splits it into two
     * linkedLists with half the points each, then it executes the bruteforce method in
     * both, shows their output in the console and compares the closest distances obtained.<p>
     * Finally, it returns an array containing the points with the minor distance of the two.<p>
     * input: The linkedList with all the points.<p>
     * output: An array with the closest pair and their distance in this way:<p>
     * [distance | firstPointX | firstPointY | secondPointX | secondPointY]
     *
     * @param list A linkedList containing all the points.
     * @return An array containing the distance in the first position and the points' coordinates in the rest of the array.
     */
    public double[] divideAndConquer(LinkedList<Point> list) {
        LinkedList<Point> firstHalf = sub(list, 0, list.size() / 2 - 1);
        LinkedList<Point> secondHalf = sub(list, list.size() / 2, list.size() - 1);
        double[] first = new double[5];
        first = bruteForce(firstHalf);
        System.out.println("First Pair");
        System.out.println("(" + first[1] + ", " + first[2] + ") and (" + first[3] + ", " + first[4] + ")");
        System.out.println("Distance**2: " + first[0] + "\n");
        double[] second = new double[5];
        second = bruteForce(secondHalf);
        System.out.println("Second Pair");
        System.out.println("(" + second[1] + ", " + second[2] + ") and (" + second[3] + ", " + second[4] + ")");
        System.out.println("Distance**2: " + second[0] + "\n");
        if (first[0] > second[0]) {
            bruteForce(firstHalf, secondHalf, second);
            return second;
        } else if (first[0] == second[0]) {
            bruteForce(firstHalf, secondHalf, second);
            return second;
        } else {
            bruteForce(firstHalf, secondHalf, first);
            return first;
        }
    }

    /**
     * The following method creates a linkedList list with the elements of other within the specified interval <p>
     * Inputs: The source linkedList, the lowest value and the top value of the interval and the linkedList that will contain
     * the result.<p>
     * Outputs: A sub-linkedList of the provided linkedList
     *
     * @param list The source linkedList
     * @param a    The lowest value (index)of the interval
     * @param b    The top value (index) of the interval
     * @return A sub-linkedList of the provided linkedList
     */
    public LinkedList<Point> sub(LinkedList<Point> list, int a, int b) {
        if (a >= list.size() || b >= list.size() || a < 0 || b < 0) {
            throw new IndexOutOfBoundsException("The specified interval is not contained in the provided linkedList");
        } else {
            LinkedList<Point> result = new LinkedList<>();
            sub(list, a, b, result);
            return result;
        }
    }

    /**
     * The following void creates a linkedList list with the elements of other within the specified interval <p>
     * Inputs: The source linkedList, the lowest value and the top value of the interval and the linkedList that will contain
     * the result.<p>
     * Outputs: A sub-linkedList of the provided linkedList
     *
     * @param list   The source linkedList
     * @param a      The lowest value (index)of the interval
     * @param b      The top value (index) of the interval
     * @param result The linkedList acting as a sub-List
     */
    private void sub(LinkedList<Point> list, int a, int b, LinkedList<Point> result) {
        if (a == b) {
            result.add(list.get(a));
        } else if (a < b) {
            result.add(list.get(a));
            sub(list, a + 1, b, result);
        }
    }

    /**
     * The following method returns the distance between two point objects
     * comparing their x and y.<p>
     * inputs: Point a and point b.<p>
     * outputs: The distance between the points.
     *
     * @param a The first point to compare.
     * @param b The second point to compare.
     * @return The distance between these points as a double.
     */
    public double distance(Point a, Point b) {
        return Math.pow((b.getY() - a.getY()), 2) + Math.pow((b.getX() - a.getX()), 2);
    }


    public long getIter() {
        return iter;
    }
}
