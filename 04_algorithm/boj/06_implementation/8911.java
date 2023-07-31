import java.util.*;
import java.io.*;

public class Main {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(reader.readLine());
            String[] controlProgram = st.nextToken().split("");
            int areaOfRectangle = getAreaOfRectangleByTurtleMovement(controlProgram);
            System.out.println(areaOfRectangle);
        }
    }

    private static int getAreaOfRectangleByTurtleMovement(String[] controlProgram) {
        Turtle turtle = new Turtle(0, 0, 0);
        Rectangle rectangle = new Rectangle(0, 0, 0, 0);

        for (String order : controlProgram) {
            switch (order) {
                case "F":
                    turtle.x += dx[turtle.direction];
                    turtle.y += dy[turtle.direction];
                    break;
                case "B":
                    turtle.x -= dx[turtle.direction];
                    turtle.y -= dy[turtle.direction];
                    break;
                case "L":
                    turtle.direction = (turtle.direction + 3) % 4;
                    break;
                case "R":
                    turtle.direction = (turtle.direction + 1) % 4;
            }

            if (order.equals("F") || order.equals("B")) {
                rectangle.minX = Math.min(rectangle.minX, turtle.x);
                rectangle.maxX = Math.max(rectangle.maxX, turtle.x);
                rectangle.minY = Math.min(rectangle.minY, turtle.y);
                rectangle.maxY = Math.max(rectangle.maxY, turtle.y);
            }
        }

        int width = rectangle.maxX - rectangle.minX;
        int height = rectangle.maxY - rectangle.minY;

        return width * height;
    }

    private static class Turtle {
        private int x;
        private int y;
        private int direction;

        public Turtle(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    private static class Rectangle {
        private int minX;
        private int maxX;
        private int minY;
        private int maxY;

        public Rectangle(int minX, int maxX, int minY, int maxY) {
            this.minX = minX;
            this.maxX = maxX;
            this.minY = minY;
            this.maxY = maxY;
        }
    }
}