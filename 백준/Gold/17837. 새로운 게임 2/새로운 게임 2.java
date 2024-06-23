import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static Dot[][] board;
    static Piece[] pieces;
    static int[] dx = {0, 0, 0, -1, 1}; //→, ←, ↑, ↓
    static int[] dy = {0, 1, -1, 0, 0};
    static boolean finished;

    static class Dot {
        int color;
        List<Piece> list;

        public Dot(int color, List<Piece> list) {
            this.color = color;
            this.list = list;
        }
    }

    static class Piece {
        int num, x, y, dir;

    public Piece(int num, int x, int y, int dir) {
        this.num = num;
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    
    board = new Dot[N + 1][N + 1];
    pieces = new Piece[K + 1];

    for(int i = 1; i < N + 1; i++) {
        st = new StringTokenizer(br.readLine(), " ");
        
        for(int j = 1; j < N + 1; j++) {
            int color = Integer.parseInt(st.nextToken());
            board[i][j] = new Dot(color, new ArrayList<>());
        }
    }
    
    for(int i = 1; i <= K; i++) {
        st = new StringTokenizer(br.readLine(), " ");
        
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        //저장
        pieces[i] = new Piece(i, x, y, d);
        board[x][y].list.add(pieces[i]);
    }
    
    //구현
    int count= 0;
    while(count <= 1000) {
        count++;
        
        //System.out.println(count + "턴---------------------");
        
        for(int i = 1; i < K + 1; i++) { //말 1번부터 움직이기
           // System.out.println(i + "번 말 움직이기---");
            int x = pieces[i].x;
            int y = pieces[i].y;
            int nx = x + dx[pieces[i].dir];
            int ny = y + dy[pieces[i].dir];
            
            if(nx == 0 || nx == N + 1 || ny == 0 || ny == N + 1 || board[nx][ny].color == 2) { //체스판을 벗어나는 경우 or 이동하려는 칸이 파란색
                moveToBlue(pieces[i]);
            } else if(board[nx][ny].color == 0) { //이동하려는 칸이 흰색
                moveToWhite(pieces[i]);
            } else if(board[nx][ny].color == 1) { //이동하려는 칸이 빨간색
                moveToRed(pieces[i]);
            }
            
            if(finished) break;
        }
        if(finished) break; // 턴이 진행되던 중에 말이 4개 이상 쌓이는 순간 게임이 종료
    }
    
    //출력
    if(!finished) {
        System.out.println(-1);
    } else {
        System.out.println(count);
    }
}

public static void moveToWhite(Piece piece) {
    int nx = piece.x + dx[piece.dir];
    int ny = piece.y + dy[piece.dir];
    
    //자신 위에 있는 말 다같이 이동
    int idx = board[piece.x][piece.y].list.indexOf(piece);
    List<Piece> tmp = new ArrayList<>(board[piece.x][piece.y].list.subList(idx, board[piece.x][piece.y].list.size()));
    board[piece.x][piece.y].list = new ArrayList<>(board[piece.x][piece.y].list.subList(0, idx));
    
    //System.out.println(tmp.size());
    
   // System.out.println("흰색 이동 실행");
    for(Piece p : tmp) {
        p.x = nx;
        p.y = ny;
        
       // System.out.println(p.num + "번: " + p.x + " " + p.y + " " + p.dir);
    }
    
    board[nx][ny].list.addAll(tmp); //이동하려는 칸 위에 추가
    
    if(board[nx][ny].list.size() >= 4) {
        finished = true;
    }
}

public static void moveToRed(Piece piece) {
    int nx = piece.x + dx[piece.dir];
    int ny = piece.y + dy[piece.dir];
    
    //자신 위에 있는 말 순서 반대로 바꾸기
    int idx = board[piece.x][piece.y].list.indexOf(piece);
    List<Piece> tmp = new ArrayList<>(board[piece.x][piece.y].list.subList(idx, board[piece.x][piece.y].list.size()));
    Collections.swap(tmp, 0, tmp.size() - 1);
    board[piece.x][piece.y].list = new ArrayList<>(board[piece.x][piece.y].list.subList(0, idx));
    
    //System.out.println(tmp.size());
    
    //System.out.println("빨강색 이동 실행");
    for(Piece p : tmp) {
        p.x = nx;
        p.y = ny;
        
        //System.out.println(p.num + "번: " + p.x + " " + p.y + " " + p.dir);
    }
    
    board[nx][ny].list.addAll(tmp); //이동하려는 칸 위에 추가
    
    if(board[nx][ny].list.size() >= 4) {
        finished = true;
    }
}

public static void moveToBlue(Piece piece) {
    int idx = board[piece.x][piece.y].list.indexOf(piece);
    
    changeDir(piece);
    
    int nx = piece.x + dx[piece.dir];
    int ny = piece.y + dy[piece.dir];
    
    //System.out.println("파란색 이동 실행");
    
    if(1<= nx && nx <= N && 1<= ny && ny <= N && board[nx][ny].color != 2) { //방향을 반대로 바꾼 후에 이동하려는 칸이 파란색이 아니면 이동
         if(board[nx][ny].color == 0) { //이동하려는 칸이 흰색
                moveToWhite(piece);
            } else if(board[nx][ny].color == 1) { //이동하려는 칸이 빨간색
                moveToRed(piece);
            }
        //        board[piece.x][piece.y].list.remove(idx);
//        piece.x = nx;
//        piece.y = ny;
//        board[nx][ny].list.add(piece);
//        
//        if(board[nx][ny].list.size() >= 4) {
//            finished = true;
//        }
    }
    //System.out.println(piece.num + "번: " + piece.x + " " + piece.y + " " + piece.dir);
}

public static void changeDir(Piece piece) {
    if(piece.dir == 1) { //방향 반대로
        piece.dir = 2;
    } else if(piece.dir == 2) {
        piece.dir = 1;
    } else if(piece.dir == 3) {
        piece.dir = 4;
    } else if(piece.dir == 4) {
        piece.dir = 3;
    }
}

public static boolean check() {
    for(int i = 1; i < N + 1; i++) {
        for(int j = 1; j < N + 1; j++) {
            if(board[i][j].list.size() >= 4) {
               // System.out.println("4개이상: " + i + " " + j);
                return true;
            }
        }
    }
    return false;
}
}