package classes_constructors_and_inheritance.exercises;

public class Point {
    private int x;
    private int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance() {
        return Math.sqrt((x-0)*(x-0) + (y-0)*(y-0));
    }

    public double distance(int x, int y) {
        return Math.sqrt((this.x-x)*(this.x-x) + (this.y-y)*(this.y-y));
    }

    public double distance(Point point) {
        return distance(point.getX(), point.getY());
    }

    public static void main(String[] args) {
        Point point = new Point(6, 5);
        System.out.println(point.distance());
    }
}
