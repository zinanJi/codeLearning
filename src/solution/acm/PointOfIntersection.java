package solution.acm;

import java.util.LinkedList;

import java.util.Queue;
import java.util.Scanner;


import static java.lang.StrictMath.abs;
import static java.lang.StrictMath.sqrt;

public class PointOfIntersection {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Circle> c = new LinkedList<>();
        String st = sc.nextLine();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j<2;j++) {
                String str = sc.nextLine();
                String[] strs = str.split(" ");
                Circle circle = new Circle(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]), Integer.parseInt(strs[2]));
                c.add(circle);
            }
        }
        for (int i = 0; i < n; i++) {
            Circle circle1 = c.poll();
            Circle circle2 = c.poll();
            double dis = sqrt((circle1.x - circle2.x) * (circle1.x - circle2.x) + (circle1.y - circle2.y) * (circle1.y - circle2.y));
            if (circle1.r == circle2.r || dis <= abs(circle1.r - circle2.r)) {
                System.out.println("Impossible.");
            } else {
                double x = circle2.x + circle2.r * (circle2.x - circle1.x) / (circle1.r - circle2.r);
                double y = circle2.y + circle2.r * (circle2.y - circle1.y) / (circle1.r - circle2.r);

                System.out.println(String.format("%.2f", x) + " " + String.format("%.2f", y));

            }
        }
    }

    static class Circle {
        double x;
        double y;
        double r;

        public Circle(double x, double y, double r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }
}
