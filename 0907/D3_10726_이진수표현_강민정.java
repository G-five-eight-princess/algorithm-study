import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
* <pre>
* [아이디어]
* AND 연산을 이용한다.
* </pre>
*
* 시간= 136ms
* 메모리=30,932kb
*/

class D3_10726_이진수표현_강민정
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
		    int T;
		    T = Integer.parseInt(br.readLine());

    		for(int test_case = 1; test_case <= T; test_case++)
    		{
                st = new StringTokenizer(br.readLine());
                String answer = "OFF";
                int nBit = (1 << Integer.parseInt(st.nextToken())) - 1;			// 마지막 N 비트가 모두 1인 비트
                int m = Integer.parseInt(st.nextToken());							// 정수
                   
               if((m & nBit) == nBit) {				// AND 연산을 한 결과가 마지막 N 비트가 모두 1로 켜져있다면
               	answer = "ON";
               }
                bw.append("#").append(String.valueOf(test_case)).append(" ").append(answer).append("\n");
    		}
        bw.flush();
	}
}
