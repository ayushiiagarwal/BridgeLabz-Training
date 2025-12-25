import java.util.*;
public class OTPGenerator {
    public static int generateOTP() {
        Random random = new Random();
        return 100000 + random.nextInt(900000);
    }

    public static boolean unique(int[] otps) {
        HashSet<Integer> set = new HashSet<>();
        for (int otp : otps) {
            if (!set.add(otp)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] otps = new int[10];
        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
            System.out.println(otps[i]);
        }
        System.out.println("All Unique OTPs: " + unique(otps));
    }
}