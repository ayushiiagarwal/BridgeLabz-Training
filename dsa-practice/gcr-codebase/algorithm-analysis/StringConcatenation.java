public class StringConcatenation {
    public static void main(String[] args) {
        int N = 100000;

        long start = System.nanoTime();
        String str = "";
        for (int i = 0; i < N; i++){
            str += "A";
        }
        long end = System.nanoTime();
        System.out.println("String Time: " + (end - start));

        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++)
            sb.append("a");
        end = System.nanoTime();
        System.out.println("StringBuilder Time: " + (end - start));

        start = System.nanoTime();
        StringBuffer br = new StringBuffer();
        for (int i = 0; i < N; i++)
            br.append("a");
        end = System.nanoTime();
        System.out.println("StringBuffer Time: " + (end - start));
    }
}