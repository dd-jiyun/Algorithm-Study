package 이지윤;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class b2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while(queue.size() > 1) {
           queue.poll();
           queue.addLast(queue.poll());
        }

        System.out.println(queue.peek());
    }
}
