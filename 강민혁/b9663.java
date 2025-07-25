package 강민혁;

import java.io.*;

public class b9663 {

  private static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    final int[] board = new int[n];

    dfs(board, 0, n);
    System.out.println(count);
  }

  public static void dfs(int[] board, int row, int n) {
    // 모든 행에 퀸을 배치 완료 시 count++
    if (row == n) {
      count++;
      return;
    }

    // 현재 행에 퀸 넣기
    for (int col = 0; col < n; col++) {
      if (isSafe(board, row, col)) { // safe 하다면 원하는 위치에 퀸 배치
        board[row] = col;
        dfs(board, row + 1, n); // 재귀 태워서 다음 행 다시 시도
        // 다음 행 실패시 재귀 스택이 줄어 이전으로 돌아감
      }
    }
  }

  // (row, col) 위치에 퀸을 놓을 수 있는지 확인
  public static boolean isSafe(int[] board, int row, int col) {
    // 이미 배치된 퀸들과 충돌 검사 (0행부터 row-1행까지)
    for (int i = 0; i < row; i++) {
      // 1. 같은 열에 퀸이 있는지 확인
      if (board[i] == col) {
        return false;
      }

      // 2. 대각선에 퀸이 있는지 확인
      // 마이너스 처리를 위해 절댓값으로 구현
      if (Math.abs(i - row) == Math.abs(board[i] - col)) {
        return false;
      }
    }

    return true;
  }
}
