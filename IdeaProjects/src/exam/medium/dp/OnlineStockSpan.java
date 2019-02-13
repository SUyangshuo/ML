package medium.dp;

import java.util.Stack;

/**
 * @author YangShuo
 * @create 2019/2/13
 * @comment
 */
public class OnlineStockSpan {

    Stack<int[]> stack=new Stack<>();

    public void StockSpanner() {

    }

    public int next(int price) {
        int rec=1;

        while(!stack.isEmpty() && stack.peek()[0]<=price){//在前多少天内是最大的

            rec+=stack.pop()[1];

        }

        stack.push(new int[]{price,rec});

        return rec;
    }
}
