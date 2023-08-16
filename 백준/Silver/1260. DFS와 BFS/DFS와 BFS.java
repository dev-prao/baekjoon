import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder(); //출력값 저장
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); //그래프 값 저장
    static int[] check; //방문한 정점을 기록할 배열
    static int count; //방문 순서


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //입력값 처리
        StringTokenizer st = new StringTokenizer(br.readLine()); //그래프 값 저장

        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());

        check = new int[vertex + 1];

        for (int i = 0 ; i <= vertex ; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0 ; i < edge ; i++) {
            st = new StringTokenizer(br.readLine());
            int fromVertex = Integer.parseInt(st.nextToken());
            int toVertex = Integer.parseInt(st.nextToken());
            graph.get(fromVertex)
                 .add(toVertex);
            graph.get(toVertex)
                 .add(fromVertex);
        }

        for (int i = 1 ; i < graph.size() ; i++) {
            Collections.sort(graph.get(i));
        }

        count = 1;

        dfs(startVertex);
        sb.append("\n");
        check = new int[vertex + 1];

        bfs(startVertex);

        System.out.println(sb);
        
        br.close();
    }

    private static void dfs(int vertex) {
        check[vertex] = count;
        sb.append(vertex + " ");
        for (int i = 0; i < graph.get(vertex).size(); i++) {
            int newVertex = graph.get(vertex).get(i);
            if (check[newVertex] == 0) {
                count++;
                dfs(newVertex);
            }
        }
    }

    private static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<Integer>();
        check[vertex] = count++; //순번 저장
        queue.add(vertex);
        while (!queue.isEmpty()) {
            int point = queue.poll();
            sb.append(point + " ");
            for (int newVertex : graph.get(point)) { //인접 정점 탐색
                if (check[newVertex] == 0) { //방문했는지 확인
                    check[newVertex] = count++; //순번 확인
                    queue.add(newVertex);
                }
            }
        }
    }

}