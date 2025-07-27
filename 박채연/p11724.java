package 박채연;

import java.util.*;
import java.io.*;

public class p11724 {
    // 전역으로 그래프, visted 배열 두기
    public static List<Integer>[] adjacentList;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // nodeCount= 노드개수, edgeCount= 엣지개수 받아 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        // 노드 배열 인덱스마다 인접 리스트 생성해 그래프 형태 표현하기
        adjacentList = new ArrayList[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            adjacentList[i] = new ArrayList<>();
        }

        // 인접 리스트에 입력값 넣기 양방향 주의
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());

            adjacentList[nodeA].add(nodeB);
            adjacentList[nodeB].add(nodeA);
        }

        // dfs 끝까지 돌때마다 result +1, visted 배열
        int result=0;
        visited = new boolean[nodeCount + 1];

        for (int i = 1; i <= nodeCount; i++) {
            if (!visited[i]) {
                dfs(i, adjacentList, visited);
                result++;
            }
        }
        System.out.print(result);
    }

    // 시작하는 부분 : node, 그래프 형태 : adjacentList, 방문 여부 : visited
    public static void dfs(int node, List<Integer>[] adjacentList,boolean[] visited){
        visited[node]=true;
        // 인접한 노드 중 방문 안한것 dfs 재귀 호출
        for(int neighbor : adjacentList[node]){
            if(!visited[neighbor]){
                dfs(neighbor,adjacentList,visited);
            }
        }
    }
}
