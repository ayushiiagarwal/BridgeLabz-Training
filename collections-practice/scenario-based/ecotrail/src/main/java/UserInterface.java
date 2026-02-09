import java.util.*;

public class UserInterface {

    public static void main(String[] args) {

        TrailUtil util = new TrailUtil();

        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("Enter number of trails");
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < n; i++) {
                String[] data = sc.nextLine().split(":");
                Trail trail = new Trail(
                        data[0], data[1], data[2], data[3],
                        Integer.parseInt(data[4])
                );
                util.addTrailRecord(trail);
            }

            System.out.println("Enter Trail Id");
            String id = sc.nextLine();
            Trail t = util.getTrailById(id);
            System.out.println(t != null ? t : "Trail Id " + id + " not found");

            Set<Trail> mostHiked = util.getMostHikedTrails();
            mostHiked.forEach(System.out::println);

            Map<String, Integer> regionMap = util.getHikeCountByRegion();
            regionMap.forEach((k, v) -> System.out.println(k + ": " + v + " hikes"));

            Map<String, List<Trail>> grouped = util.groupTrailsByDifficulty();
            grouped.forEach((k, v) -> {
                System.out.println(k);
                v.forEach(System.out::println);
            });
        }
    }
}
