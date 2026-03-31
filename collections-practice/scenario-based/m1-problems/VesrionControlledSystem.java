import java.util.*;

class File {
    String version;
    int size;

    File(String version, int size) {
        this.version = version;
        this.size = size;
    }
}

public class VesrionControlledSystem {
    static Map<String, List<File>> map = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();
            String[] parts = line.split(" ");

            String command = parts[0];

            switch (command) {

                case "UPLOAD": {
                    String file = parts[1];
                    String version = parts[2];
                    int size = Integer.parseInt(parts[3]);

                    map.putIfAbsent(file, new ArrayList<>());

                    // check duplicate version
                    boolean exists = false;
                    for (File fv : map.get(file)) {
                        if (fv.version.equals(version)) {
                            exists = true;
                            break;
                        }
                    }

                    if (!exists) {
                        map.get(file).add(new File(version, size));
                    }
                    break;
                }

                case "FETCH": {
                    String file = parts[1];

                    if (!map.containsKey(file)) {
                        System.out.println("File Not Found");
                        break;
                    }

                    List<File> list = new ArrayList<>(map.get(file));

                    list.sort((a, b) -> {
                        if (a.size != b.size)
                            return a.size - b.size;
                        return a.version.compareTo(b.version);
                    });

                    for (File fv : list) {
                        System.out.println(file + " " + fv.version + " " + fv.size);
                    }
                    break;
                }

                case "LATEST": {
                    String file = parts[1];

                    if (!map.containsKey(file)) {
                        System.out.println("File Not Found");
                        break;
                    }

                    List<File> list = map.get(file);
                    File last = list.get(list.size() - 1);

                    System.out.println(file + " " + last.version + " " + last.size);
                    break;
                }

                case "TOTAL_STORAGE": {
                    String file = parts[1];

                    if (!map.containsKey(file)) {
                        System.out.println("File Not Found");
                        break;
                    }

                    int sum = 0;
                    for (File fv : map.get(file)) {
                        sum += fv.size;
                    }

                    System.out.println(file + " " + sum);
                    break;
                }
            }
        }

        sc.close();
    }
}