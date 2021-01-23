import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



public class DateTest {

    private static int num;

    public static int countBits(int number){
        int ans = 0;
        while (true) {
            if (number == 0) break;

            if (number % 2 != 0) {
                ans++;
            }
            number = number >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(countBits(7));
        System.out.println(countBits(5));
        System.out.println(countBits(16));
        System.out.println(countBits(24));
        System.out.println(countBits(26));

        Map<String, String> map = new HashMap<>();
        String mKey = "key";
        String mValue = "value";
        map.put(mKey, mValue);

        System.out.println(map.get(mKey));

        int h, hh, k, kk;
        hh = (h = mKey.hashCode()) ^ (h >>> 16);
        System.out.println("hh: " + hh);

        k = mKey.hashCode();
        System.out.println("k: " + k);
        kk = k ^ (k >>> 16);
        System.out.println("kk: " + kk);

//        int a = 1, b = 0;
//        System.out.println(a ^ b);
//        System.out.println(a ^ a);
//        System.out.println(b ^ b);

        System.out.println(num);
    }
}
