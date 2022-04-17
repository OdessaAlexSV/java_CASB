package asv;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("Word");
    hello("user");
    hello("Alex");

    Square s = new Square(5);
    System.out.println("Square's area with side " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Rectangle's area with sides " + r.a + " & " + r.b + " = " + r.area());

    Point p = new Point(10,20);
    System.out.println("Distance between point p1(" + p.x + ";" + p.y + ") and p2(10.0,20.0) = " + p.distance(10,20));
    System.out.println("Distance between point p1(" + p.x + ";" + p.y + ") and p2(13.0,20.0) = " + p.distance(13,20));
    System.out.println("Distance between point p1(" + p.x + ";" + p.y + ") and p2(13.0,60.0) = " + p.distance(13,60));
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }
}