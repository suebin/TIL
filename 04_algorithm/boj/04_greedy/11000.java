import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Lecture[] lectures = new Lecture[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lectures[i] = new Lecture(start, end);
        }

        Arrays.sort(lectures);

        Queue<Integer> rooms = new PriorityQueue<>();
        rooms.offer(lectures[0].end);

        for (int i = 1; i < lectures.length; i++) {
            if (rooms.peek() <= lectures[i].start) {
                rooms.poll();
            }

            rooms.offer(lectures[i].end);
        }

        System.out.print(rooms.size());
    }

    public static class Lecture implements Comparable<Lecture> {
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }

            return this.start - o.start;
        }
    }
}