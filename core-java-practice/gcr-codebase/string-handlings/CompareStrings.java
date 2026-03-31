public class CompareStrings {
    public static void main(String[] args) {
        String str1 = "apple";
        String str2 = "banana";

        int result = str1.compareTo(str2);
        if (result < 0) System.out.println(str1 + " comes before " + str2);

        else if (result > 0) System.out.println(str2 + " comes before " + str1);

        else System.out.println("Both strings are equal");
    }
}
