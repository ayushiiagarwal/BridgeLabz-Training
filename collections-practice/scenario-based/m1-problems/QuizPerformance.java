import java.util.*;

class Student {
    String name;
    String dept;
    int quiz1, quiz2, quiz3;

    Student(String name, String dept, int quiz1, int quiz2, int quiz3) {
        this.name = name;
        this.dept = dept;
        this.quiz1 = quiz1;
        this.quiz2 = quiz2;
        this.quiz3 = quiz3;
    }

    int total() {
        return quiz1 + quiz2 + quiz3;
    }
}

public class QuizPerformance {

    static List<Student> list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();
            String[] parts = line.split(" ");

            String cmd = parts[0];

            switch (cmd) {

                case "Record": {
                    String name = parts[1];
                    String dept = parts[2];
                    int quiz1 = Integer.parseInt(parts[3]);
                    int quiz2 = Integer.parseInt(parts[4]);
                    int quiz3 = Integer.parseInt(parts[5]);

                    list.add(new Student(name, dept, quiz1, quiz2, quiz3));
                    System.out.println("Record Added: " + name);
                    break;
                }

                case "Top": {

                    if (list.isEmpty()) {
                        System.out.println("No Records Available");
                        break;
                    }

                    String type = parts[1];

                    // Top Department
                    if (!type.startsWith("Q")) {

                        String dept = type;
                        boolean found = false;
                        int max = Integer.MIN_VALUE;

                        // find max
                        for (Student s : list) {
                            if (s.dept.equals(dept)) {
                                found = true;
                                max = Math.max(max, s.total());
                            }
                        }

                        if (!found) {
                            System.out.println("Department Not Found");
                            break;
                        }

                        for (Student s : list) {
                            if (s.dept.equals(dept) && s.total() == max) {
                                System.out.println(s.name + " " + s.total());
                            }
                        }
                    }

                    // Top Q1 / Q2 / Q3
                    else {

                        int max = Integer.MIN_VALUE;

                        // find max
                        for (Student s : list) {
                            if (type.equals("Q1"))
                                max = Math.max(max, s.quiz1);
                            else if (type.equals("Q2"))
                                max = Math.max(max, s.quiz2);
                            else
                                max = Math.max(max, s.quiz3);
                        }

                        // print
                        for (Student s : list) {
                            if (type.equals("Q1") && s.quiz1 == max)
                                System.out.println(s.name + " " + s.quiz1);
                            else if (type.equals("Q2") && s.quiz2 == max)
                                System.out.println(s.name + " " + s.quiz2);
                            else if (type.equals("Q3") && s.quiz3 == max)
                                System.out.println(s.name + " " + s.quiz3);
                        }
                    }

                    break;
                }
            }
        }

        sc.close();
    }
}