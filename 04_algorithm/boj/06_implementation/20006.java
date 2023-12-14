import java.util.*;
import java.io.*;

public class Main {
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(reader.readLine());
            int level = Integer.parseInt(st.nextToken());
            String id = st.nextToken();

            Player player = new Player(level, id);
            boolean isEntered = false;

            for (Room room : rooms) {
                if (isEntryAllowed(room.status, player.level - room.players.get(0).level)) {
                    enterRoom(room, player);
                    isEntered = true;
                    break;
                }
            }

            if (!isEntered) {
                rooms.add(new Room());
                enterRoom(rooms.get(rooms.size() - 1), player);
            }
        }

        print(rooms);
    }

    private static boolean isEntryAllowed(Status status, int diff) {
        return status != Status.STARTED && diff >= -10 && diff <= 10;
    }

    private static void enterRoom(Room room, Player player) {
        room.players.add(player);

        if (room.players.size() == m)
            room.status = Status.STARTED;
    }

    private static void print(List<Room> rooms) {
        StringBuilder ans = new StringBuilder();
        for (Room room : rooms) {
            ans.append(room.status.getValue()).append("\n");
            Collections.sort(room.players);
            for (Player player : room.players) {
                ans.append(player.level).append(" ").append(player.id).append("\n");
            }
        }

        System.out.println(ans);
    }

    private static class Room {
        List<Player> players;
        Status status;

        public Room() {
            this.players = new ArrayList<>();
            this.status = Status.WAITING;
        }
    }

    private static class Player implements Comparable<Player> {
        int level;
        String id;

        public Player(int level, String id) {
            this.level = level;
            this.id = id;
        }

        @Override
        public int compareTo(Player o) {
            return this.id.compareTo(o.id);
        }
    }

    public enum Status {
        WAITING("Waiting!"),
        STARTED("Started!");

        private final String value;

        Status(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}