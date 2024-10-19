class Shape
{
  void draw()
  {
   System.out.println("\nDraw any shape");

  }

  void erase()
  {
  System.out.println("\nErase any shape ");
  }
}

class Circle extends Shape
{
 void draw()
 {
 System.out.println("\nDraw Circle");
 }
 void erase()
 {
 System.out.println("\n Erase Circle ");
 }

}

class Triangle extends Shape
{
 void draw()
 {
 System.out.println("\nDraw Triangle");
 }
 void erase()
 {
 System.out.println("\n Erase Triangle ");
 }

}
class Square extends Shape
{
 void draw()
 {
 System.out.println("\nDraw Square");
 }
 void erase()
 {
    System.out.println("\n Erase Square ");
}

}

public class test
{
public static void main(String args[])
{
Shape a=new Circle();
Shape b=new Triangle();
Shape c=new Square();

a.draw();
a.erase();

b.draw();
b.erase();

c.draw();
c.erase();
}
}
