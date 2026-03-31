import java.util.*;
import java.util.stream.Collectors;

public class TrailUtil {

    private List<Trail> trailList = new ArrayList<>();

    public List<Trail> getTrailList() {
        return trailList;
    }

    public void setTrailList(List<Trail> trailList) {
        this.trailList = trailList;
    }

    // Requirement 1
    public void addTrailRecord(Trail trail) {
        if (trail != null) {
            trailList.add(trail);
        }
    }

    // Requirement 2
    public Trail getTrailById(String trailId) {
        return trailList.stream()
                .filter(t -> t.getTrailId().equalsIgnoreCase(trailId))
                .findFirst()
                .orElse(null);
    }

    // Requirement 3
    public Set<Trail> getMostHikedTrails() {
        if (trailList.isEmpty()) {
            return new HashSet<>();
        }

        int maxHikes = trailList.stream()
                .mapToInt(Trail::getHikeCount)
                .max()
                .orElse(0);

        return trailList.stream()
                .filter(t -> t.getHikeCount() == maxHikes)
                .collect(Collectors.toSet());
    }

    // Requirement 4
    public Map<String, Integer> getHikeCountByRegion() {
        return trailList.stream()
                .collect(Collectors.groupingBy(
                        Trail::getRegion,
                        Collectors.summingInt(Trail::getHikeCount)
                ));
    }

    // Requirement 5
    public Map<String, List<Trail>> groupTrailsByDifficulty() {
        return trailList.stream()
                .collect(Collectors.groupingBy(Trail::getDifficulty));
    }

    // Requirement 6
    public boolean updateHikeCount(String trailId, int additionalHikes) {
        if (additionalHikes <= 0) {
            return false;
        }

        Trail trail = getTrailById(trailId);
        if (trail != null) {
            trail.setHikeCount(trail.getHikeCount() + additionalHikes);
            return true;
        }
        return false;
    }

    // Requirement 7
    public List<Trail> filterTrails(String region, String difficulty) {
        return trailList.stream()
                .filter(t -> t.getRegion().equalsIgnoreCase(region))
                .filter(t -> t.getDifficulty().equalsIgnoreCase(difficulty))
                .collect(Collectors.toList());
    }

    // Requirement 8
    public Map<String, List<Trail>> getTopTrailsByRegion(int n) {
        return trailList.stream()
                .collect(Collectors.groupingBy(
                        Trail::getRegion,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparingInt(Trail::getHikeCount).reversed())
                                        .limit(n)
                                        .collect(Collectors.toList())
                        )
                ));
    }

    // Requirement 9
    public Map<String, String> getDifficultyStats() {
        Map<String, List<Trail>> grouped = groupTrailsByDifficulty();
        Map<String, String> stats = new HashMap<>();

        for (Map.Entry<String, List<Trail>> entry : grouped.entrySet()) {
            int count = entry.getValue().size();
            int totalHikes = entry.getValue().stream()
                    .mapToInt(Trail::getHikeCount)
                    .sum();
            int average = count == 0 ? 0 : totalHikes / count;

            stats.put(entry.getKey(),
                    "count=" + count +
                            ", totalHikes=" + totalHikes +
                            ", averageHikes=" + average);
        }
        return stats;
    }
}
