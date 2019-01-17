package medium.ergodic;

/**
 * @author YangShuo
 * @create 2019/1/15
 * @comment
 */

import java.util.LinkedList;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 Example:

 X X X X
 X O O X
 X X O X
 X O X X

 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X

 Explanation:

 Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.


 找到没有和边上的o连接的o  并把他们变成x

 */

//首先遍历周围一圈的字母，发现有o的就从该点进行BFS，并且把遍历到的o 改为$ 在周围一圈遍历完成后，把所有的$ 变成o 把所有的o变成x
public class SurroundedRegions {
    public  static int t=1;
    public static void main(String[] args) {
        char[][] a={{'X','O','X','O','X','O'}
                        ,{'O','X','O','X','O','X'}
                        ,{'X','O','X','O','X','O'}
                        ,{'O','X','O','X','O','X'}};

        solve(a);

    }


    public static void solve(char[][] board) {
        if(board.length<=1 || board[0].length<=1){
            return;
        }
        //确定矩阵的大小
        int x= board.length;
        int y= board[0].length;
        for(int i=0;i<y;i++){
           full(board,0,i); //第一行元素
            full(board,x-1,i); //最后一行元素

        }

        for(int i=0;i<x;i++){
            full(board,i,0); //第一列元素
            full(board,i,y-1); //最后一列元素

        }

        //对于最终的矩阵进行转化

        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(board[i][j]=='X'  || board[i][j]=='O'){
                    board[i][j]='X';

                    continue;
                }else  if(board[i][j]=='$'){
                    board[i][j]='O';


                    continue;
                }

            }
            System.out.println();


        }
    }
    //利用bfs进行广度优先遍历，使用队列 先进先出
    public static void full(char[][] board,int x,int y){
        if(board[x][y]!='O'){
            return;
        }else if(board[x][y]=='O'){
            board[x][y]='$';
        }
        LinkedList<Integer> quen=new LinkedList<>();
        //记录当前的坐标
        Integer temp = x*board[0].length+y;
        quen.add(temp);

        while(!quen.isEmpty()){
           int tt = quen.poll();
            int i=tt/board[0].length;//横坐标
            int z=tt%board[0].length;//纵坐标

            //todo:查看该点上下左右的位置是否有‘o'
            if(z-1>0 && board[i][z-1]=='O'){  //该点左边
                quen.add(i*board[0].length+z-1);
                board[i][z-1]='$';
            }
            if(i-1>0 && board[i-1][z]=='O'){   //该点下边
                quen.add((i-1)*board[0].length+z);
                board[i-1][z]='$';
            }

            if(z+1<board[0].length && board[i][z+1]=='O'){ //该点右边
                quen.add(i*board[0].length+z+1);
                board[i][z+1]='$';
            }

            if(i+1<board.length && board[i+1][z]=='O'){ //该店上边
                quen.add((i+1)*board[0].length+z);
                board[i+1][z]='$';
            }
        }
    }

    //ac版本



}
