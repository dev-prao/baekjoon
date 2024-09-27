import java.io.*;
import java.util.*;

class Solution {
    
    static int r, c;
    static int max = 0;
    static int idx = 1;
    
    static Set<Integer> oilSet = new HashSet<>();
    static Map<Integer, Integer> idxCount = new HashMap<>();
    static Deque<int[]> q = new ArrayDeque<>();
    
    static int[][] map;
    
    static int[] dr = {1,0,0,-1};
    static int[] dc = {0,1,-1,0};
    
    public int solution(int[][] land) {
        //맵을 석유 덩어리 크기로 채우기
        r = land.length;
        c = land[0].length;
        //맵 채우기
        map = new int[r][c];
        setMap(land); //(번호, 석유 덩어리 크기)        
        getMax();
        
        return max;
    }
    
    public void getMax() {
        for(int i = 0; i < c; i++) {
            int sum = 0;
            oilSet.clear();
            for(int j = 0; j < r; j++) {
                if(map[j][i] == 0) continue;
                oilSet.add(map[j][i]);
            }
            for(int k : oilSet) {
                sum += idxCount.get(k);
            }
            max = Math.max(max, sum);
        }
    }
    
    public void setMap(int[][] land) {
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(land[i][j] == 0 || map[i][j] != 0) continue;
                int oilCount = findOil(land, new int[]{i,j});
                idxCount.put(idx, oilCount);
                idx++;
            }
        }
    }
    
    public int findOil(int[][] land, int[] p) {
        q.clear();
        int count = 1;
        map[p[0]][p[1]] = idx;
        q.offer(p);
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                

                if(isOutOfMap(nr, nc) || land[nr][nc] == 0 || map[nr][nc] != 0) continue;
                
                map[nr][nc] = idx;
                count++;
                
                q.offer(new int[]{nr, nc});
            }
        }
        
        return count;
    }
    
    
    public boolean isOutOfMap(int r1, int c1) {
        return r1 < 0 || c1 < 0 || r1 >= r || c1 >= c;
    }
    
    public void printArr(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}