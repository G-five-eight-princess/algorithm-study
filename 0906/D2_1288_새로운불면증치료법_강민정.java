import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
 * <pre>
 * [아이디어]
 * 비트 연산을 이용한다.
 * 배수를 생성하고 각 자리의 수마다 비트에 추가한다.
 * 예를 들어서, 2를 만나면 비트는 100이 된다.
 * 0부터 9까지 모든 비트가 1로 채워지면 답을 출력한다.
 * </pre>
 * 
 * 시간: 131ms
 * 메모리: 21,208kb
 */

class D2_1288_새로운불면증치료법_강민정 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T;		// 테스트케이스 수
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int m = (1 << 10) - 1;		// 0부터 9까지의 비트를 1로 켠다. -1을 한 이유는 공집합을 제외시킴
			int bit = 0;		// 초기 비트
			
			for (int i = 1;; i++) {
				String drainage = String.valueOf(N * i); // N의 i번째 배수
				for (char c : drainage.toCharArray()) {		// 문자열 -> 문자로 변환
					bit |= 1 << Integer.parseInt(String.valueOf(c));		// 문자를 정수로 변환 후 비트에 추가
				}
				if (bit == m) { // 0부터 9까지 모든 숫자를 다봄
					bw.append("#").append(String.valueOf(test_case)).append(" ").append(drainage).append("\n");
					break;
				}
			}
		}
		bw.flush();
	}
}
