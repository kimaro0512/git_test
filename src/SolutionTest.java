import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

    public int getNum(char c) {
        return c - '0';
    }

    public char getChar(int n) {
        if(n == 0) return '0';
        else if(n == 1) return '1';
        else if(n == 2) return '2';
        else if(n == 3) return '3';
        else if(n == 4) return '4';
        else if(n == 5) return '5';
        else if(n == 6) return '6';
        else if(n == 7) return '7';
        else if(n == 8) return '8';
        else if(n == 9) return '9';
        else return '0';
    }

    public String solution(String p, int n) {
        String answer = "";

        int mod = 24 * 3600;

        int h = getNum(p.charAt(3)) * 10 + getNum(p.charAt(4));
        if(p.charAt(0) == 'A') {
            if(h == 12) {
                h = 0;
            }
        }

        int m = getNum(p.charAt(6)) * 10 + getNum(p.charAt(7));
        int s = getNum(p.charAt(9)) * 10 + getNum(p.charAt(10));

        int seconds = (h * 3600) + (m * 60) + s;
        if(p.charAt(0) == 'P') {
            seconds += (12 * 3600);
        }


        seconds += n;

        int H = seconds / 3600;
        H %= 24;
        seconds %= 3600;
        int M = seconds / 60;
        seconds %= 60;
        int S = seconds;

        if(H < 10) {
            answer += '0';
            answer += getChar(H);
        }
        else {
            answer += getChar(H/10);
            H %= 10;
            answer += getChar(H);
        }

        answer += ':';
        if(M < 10) {
            answer += '0';
            answer += getChar(M);
        }
        else {
            answer += getChar(M/10);
            M %= 10;
            answer += getChar(M);
        }

        answer += ':';
        if(S < 10) {
            answer += '0';
            answer += getChar(S);
        }
        else {
            answer += getChar(S/10);
            S %= 10;
            answer += getChar(S);
        }

        return answer;
    }
}

public class SolutionTest {
    public static void main(String[] args) {
        String p;
        int n;

        Scanner sc = new Scanner(System.in);
        p = sc.nextLine();
        n = sc.nextInt();

        Solution sol = new Solution();

        String ans = sol.solution(p, n);
        System.out.println(ans);

//        String str = "";
//        StringBuffer sbf = new StringBuffer();
//        sbf.append(1 + '0');
//        str += getChar(1);
//        str = str + (1 + '0');
//        System.out.println(sbf.toString());

    }
}