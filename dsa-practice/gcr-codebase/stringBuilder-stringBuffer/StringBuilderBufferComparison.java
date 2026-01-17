public class StringBuilderBufferComparison {
    public static void main(String[] args) {
        long start = System.nanoTime();

        StringBuffer br = new StringBuffer();
        for(int i=0; i<1000000; i++)
            br.append("hello");

        long bufferTime = System.nanoTime() - start;

        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<1000000;i++)
            sb.append("hello");

        long builderTime = System.nanoTime() - start;

        System.out.println("StringBuffer Time: " + bufferTime);
        System.out.println("StringBuilder Time: " + builderTime);
    }
}
