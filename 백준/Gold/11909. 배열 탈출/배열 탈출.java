import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int arr[][]; //입력받을 배열
    static int dp[][]; //최소값 저장할 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        dp = new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[1][1] = 0; 

        int diff = 0; 

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i == N && j == N) break; 
                if(i != N){
                    if(arr[i+1][j] >= arr[i][j]){ 
                        diff = arr[i+1][j] - arr[i][j]+1;
                        dp[i+1][j] = Math.min(dp[i+1][j],diff+dp[i][j]);
                    }
                    else{
                        dp[i+1][j] = Math.min(dp[i+1][j],dp[i][j]);
                    }
                }
                if(j != N){
                    if(arr[i][j+1] >= arr[i][j]){ 
                        diff = arr[i][j+1] - arr[i][j]+1; 
                        dp[i][j+1] = Math.min(dp[i][j+1],diff+dp[i][j]);
                    }
                    else{
                        dp[i][j+1] = Math.min(dp[i][j+1],dp[i][j]);
                    }
                }
            }
        }

        System.out.println(dp[N][N]);
    }
}