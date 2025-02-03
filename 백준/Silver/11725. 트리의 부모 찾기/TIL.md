# 백준 11725번 - 트리의 부모 찾기

### 문제 설명

루트가 1인 트리에서 각 노드의 부모를 찾아야 한다. 입력은 두 정점의 연결 정보이며, 방향성이 없는 그래프 형태로 제공된다.

### 입력 형식

- 노드 개수 N(2 ≤ N ≤ 100,000)
- N-1개의 간선 정보

### 출력 형식

- 2번 노드부터 N번 노드까지 부모 노드 출력

### 문제 접근

입력은 방향성이 없는 트리의 간선 정보이므로 인접 리스트를 활용하여 그래프를 구성한다.
이후 DFS를 이용해 부모를 찾는다.

트리는 순환이 없는 연결 그래프로, 임의의 두 노드를 잇는 유일한 경로가 존재한다.
DFS를 이용해 부모를 찾는 과정은 트리의 계층 구조를 따라가며 탐색하는 과정과 같다.

각 노드를 방문하며 부모를 저장하여 탐색하는 방법으로 풀이하였다.

### 코드 구현 (Java)

```java
package tests;

import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] tree;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int node) {
        for (int next : tree[node]) {
            if (parent[next] == 0) {
                parent[next] = node;
                dfs(next);
            }
        }
    }
}
```


### 핵심 개념

- 트리 구성: 인접 리스트 활용
- DFS 탐색: 부모를 찾으며 탐색
- 출력 최적화: StringBuilder 사용

### 시간 복잡도

- O(N)