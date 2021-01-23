import java.util.*;

public class Main {
    static int[][] A = new int[55][55];

    static void clockwise(int index, int num, int M) {
        for (int i = 0; i < num; i++) {
            int tmp = A[index][M - 1];
            for(int j = M - 1; j > 0; j--) {
                A[index][j] = A[index][j - 1];
            }
            A[index][0] = tmp;
        }
    }

    static void counterclockwise(int index, int num, int M) {
        for (int i = 0; i < num; i++) {
            int tmp = A[index][0];
            for(int j = 0; j < M - 1; j++) {
                A[index][j] = A[index][j + 1];
            }
            A[index][M - 1] = tmp;
        }
    }

    static  boolean findSameNumber(int N, int M) {
        int[][] B = new int[55][55];
        for(int i = 0; i < 55; i++) {
            for(int j = 0; j < 55; j++) {
                B[i][j] = 0;
            }
        }

        // 인접하면서 수가 같은 것 찾기(지워진 수는 -1로 표시)
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M - 1; j++) {
                if (A[i][j] == A[i][j + 1] && A[i][j] != -1) {
                    B[i][j] = 1;
                    B[i][j + 1] = 1;
                }
            }

            if (A[i][0] == A[i][M - 1] && A[i][0] != -1) {
                B[i][0] = 1;
                B[i][M - 1] = 1;
            }
        }

        for (int j = 0; j < M; j++) {
            for (int i = 1; i < N; i++) {
                if (A[i][j] == A[i + 1][j] && A[i][j] != -1) {
                    B[i][j] = 1;
                    B[i + 1][j] = 1;
                }
            }
        }

        boolean ret = false;
        // 원판에 지워진 수 반영
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                if (B[i][j] == 1) {
                    ret = true;
                    A[i][j] = -1;
                }
            }
        }

        return ret;
    }

    static void calc(int N, int M) {
        int sum = 0;
        int count = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != -1) {
                    count++;
                    sum += A[i][j];
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != -1) {
                    if (A[i][j] * count < sum) {
                        int a = A[i][j];
                        A[i][j] = a + 1;
                    } else if (A[i][j] * count > sum) {
                        int a = A[i][j];
                        A[i][j] = a - 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < 55; i++) {
            for(int j = 0; j < 55; j++) {
                A[i][j] = 0;
            }
        }

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int T = scanner.nextInt();

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                int x = scanner.nextInt();
                A[i][j] = x;
            }
        }

        for (int i = 0; i < T; i++) { // T번 회전
            int x = scanner.nextInt();
            int d = scanner.nextInt();
            int k = scanner.nextInt();

            // 원판 회전
            for (int j = x; j <= N; j += x) {
                if (d == 0) {
                    clockwise(j, k, M);
                } else if (d == 1) {
                    counterclockwise(j, k, M);
                }
            }

            boolean flag = findSameNumber(N, M);

            if (flag == false) {
                // 평균 구하기
                calc(N, M);
            }
        }

        // 원판에 적힌 수의 총 합
        int total = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != -1) {
                    total += A[i][j];
                }
            }
        }

        System.out.println(total);
    }
}