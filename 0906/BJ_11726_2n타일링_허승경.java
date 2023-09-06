import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**2023-09-06
 * [문제] BJ : 11726 2×n 타일링 
 * [아이디어]
 * - n=1,2일 때까지는 값 설정
 * - n이 3이상일 경우, n번째 값은 n-1번째의 값 + n-2 번째의 값
 * - dp[i] 구할 때마다 10007 나머지 처리 해주기
 * 
 * 메모리 : 14324 KB
 * 시   간 :   128 ms
 * @author 허승경
 *
 */
public class BJ_11726_2n타일링_허승경 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int [] dp = new int[n+1];
		
		// 미리 초기화 시키려면 dp의 크기를 먼저 지정하기
		if(n==1) {
			System.out.println(1);
		}else if(n==2) {
			System.out.println(2);
		}else {
			dp[1] = 1;
			dp[2] = 2;
			for(int i = 3; i <= n; i++) {
				dp[i] = (dp[i-1] + dp[i-2]) % 10007;
			}
			System.out.println(dp[n]);			
		}
	}

}
