import java.io.*;
import java.util.*;

public class Main {
    static int vertex, edge, startVertex, count = 1; //정점, 간선, 시작 정점, 순번
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); //그래프 값 저장
    static int[] result; //순번 저장 배열
    static boolean[] visited; //방문 확인 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        startVertex = Integer.parseInt(st.nextToken());

        result = new int[vertex + 1];
        visited = new boolean[vertex + 1];

        for(int i = 0; i <= vertex; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int startVertex = Integer.parseInt(st.nextToken());
            int toVertex = Integer.parseInt(st.nextToken());
            graph.get(startVertex).add(toVertex);
            graph.get(toVertex).add(startVertex);
        }

        bfs(startVertex);

        for(int i = 1; i <= vertex; i++) {
            bw.write(result[i] + "\n");
        }
        bw.flush(); //결과 출력
        bw.close();
        br.close();
    }

    //너비 우선 탐색 함수
    public static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<Integer>();
        result[vertex] = count++; //순번 저장
        visited[vertex] = true; //방문 확인
        queue.add(vertex);
        while(!queue.isEmpty()) {
            int point = queue.poll();
            Collections.sort(graph.get(point), Collections.reverseOrder()); //내림차순 정렬
            for(int next : graph.get(point)) { //인접 정점 탐색
                if(!visited[next]) {
                    visited[next] = true;
                    result[next] = count++;
                    queue.add(next);
                }
            }
        }
    }
}