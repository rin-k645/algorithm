# [Gold IV] 같은 수로 만들기 - 2374 

[문제 링크](https://www.acmicpc.net/problem/2374) 

### 성능 요약

메모리: 14624 KB, 시간: 116 ms

### 분류

자료 구조, 그리디 알고리즘, 집합과 맵, 스택

### 제출 일자

2025년 7월 27일 21:16:47

### 문제 설명

<p>n(1 ≤ n ≤ 1,000)개의 자연수 A[1], A[2], A[3], …, A[n]이 있다. 이 자연수에 Add(i)라는 연산을 하면, A[i]가 1만큼 증가한다. 이때, A[i]만 증가하는 것이 아니고, A[i]의 좌우로 인접한 같은 수의 그룹이 한번에 1씩 증가한다. A[1]과 A[n]은 인접해 있지 않다.</p>

<p>예를 들어 수가 {1, 1, 1, 1, 3, 3, 1} 이었다고 해 보자. Add(2)를 하면 A[2]의 좌우로 인접한 같은 수가 1씩 증가하니까 {2, 2, 2, 2, 3, 3, 1}이 된다. 여기서 Add(4)를 하면 {3, 3, 3, 3, 3, 3, 1}이 되고, 여기서 Add(1)을 하면 {4, 4, 4, 4, 4, 4, 1}이 된다.</p>

<p>이와 같이 Add라는 연산을 사용하여 A[1] = A[2] = A[3] = … = A[n]이 되도록 하려 한다. 이때, 최소 회수로 Add연산을 사용하는 방법을 찾는 것이 문제이다.</p>

### 입력 

 <p>첫째 줄에 정수 n이 주어진다. 다음 n개의 줄에는 차례로 A[1], A[2], …, A[n]이 주어진다. 모든 입력은 1,000,000,000을 넘지 않는다.</p>

### 출력 

 <p>첫째 줄에 최소의 Add연산 사용 회수를 출력한다. 이 값은 10<sup>25</sup>을 넘지 않는다.</p>

