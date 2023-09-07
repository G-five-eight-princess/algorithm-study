import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**2023-09-07
 * [문제] BJ : 1926-그림
 * [아이디어] dfs
 * - 조건에 해당하는 인덱스를 dfs 다 돌리고 나면 그림의 개수를 증가, 최대 넓이를 구한다.
 * 
 * 최적화 -> BFS
 * 
 * 메모리 : 49008 KB
 * 시   간 :  1084 ms
 * @author 허승경
 *
 */
public class BJ_1926_그림_허승경 {
	
	static int n;
	static int m;
	static int [][] graph;
	static boolean [][] visited;
	static int [] dx = {-1, 1, 0, 0};		// 상-하-좌-우
	static int [] dy = {0, 0, -1, 1};
	static int count;
	static int tmpArea;
	
	static void dfs(int x, int y) {
		visited[x][y] = true;		// 방문 확인
		tmpArea++;	// 해당 그림의 넓이
		
		int nx = 0;
		int ny = 0;
		for(int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			if(nx >= 0 && nx < n && ny >= 0 && ny < m) {			// 배열의 범위 내에 해당
				if(!visited[nx][ny] && graph[nx][ny] == 1) {		// 아직 방문 전이고 그림일 때
					dfs(nx, ny);		// dfs 돌리기
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());	// 세로 크기(행)
		m = Integer.parseInt(st.nextToken());	// 가로 크기(열)
		
		graph = new int[n][m];		// 그림 정보 배열
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// dfs 돌리기
		count = 0;	// 그림의 개수
		int maxArea = 0;	// 가장 넓은 그림의 넓이
		visited = new boolean[n][m];	// n*m 크기의 방문 배열
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				tmpArea = 0;
				if(graph[i][j] == 1 && !visited[i][j]) {	// 현재 인덱스가 그림이고 방문 전일때
					dfs(i, j);			// dfs() 돌리기
					count++;			// 그림의 개수 증가
					maxArea = Math.max(maxArea, tmpArea);	// 최대 그림 넓이 갱신
				}
			}
		}
		System.out.println(count+"\n"+maxArea); 	// 결과 출력

	}

}
