package medium.ergodic;

import java.util.*;

/**
 * @author YangShuo
 * @create 2019/2/14
 * @comment
 */

class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  };
public class CloneGraph {

    //133--遍历一个图并且复制
    //使用bfs或者dfs 遍历

    //bfs广度优先遍历  有使用队列实现
    public UndirectedGraphNode cloneGraphbfs(UndirectedGraphNode node) {

        if(node == null){
            return null;
        }

        LinkedList<UndirectedGraphNode> link=new LinkedList<>();
        //使用一个hashmap用来保存节点信息
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<>();

        UndirectedGraphNode head=new UndirectedGraphNode(node.label);

        map.put(node,head);

        link.add(node);
        while(!link.isEmpty()){
            UndirectedGraphNode ug=link.poll();
            for(UndirectedGraphNode temp:ug.neighbors){
                if(!map.containsKey(temp)){
                    link.add(temp);
                    UndirectedGraphNode u=new UndirectedGraphNode(temp.label);
                    map.put(temp,u);
                }
                map.get(ug).neighbors.add(temp);
            }
        }

       return  head;
    }
    //dfs深度优先遍历  使用栈实现--非递归
    public UndirectedGraphNode cloneGraphdfs(UndirectedGraphNode node) {
        if(node == null){
            return null;
        }
        Stack<UndirectedGraphNode> stack=new Stack<>();
        stack.add(node);

        HashMap<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap();

        UndirectedGraphNode head=new UndirectedGraphNode(node.label);
        map.put(node,head);

        while(!stack.isEmpty()){
            UndirectedGraphNode ug=stack.pop();
            for(UndirectedGraphNode temp:ug.neighbors){
                if(!map.containsKey(temp)){
                    stack.add(temp);
                    UndirectedGraphNode u=new UndirectedGraphNode(temp.label);
                    map.put(temp,u);
                }
                map.get(ug).neighbors.add(temp);
            }
        }
        return head;
    }
    //递归形式的dfs
    public static UndirectedGraphNode cloneGraphdfs2step1(UndirectedGraphNode node){
        if(node == null){
            return null;
        }
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap();
        UndirectedGraphNode head=new UndirectedGraphNode(node.label);

        map.put(node,head);
        cloneGraphdfs2(map,node);
        return  head;
    }


    public static void cloneGraphdfs2(HashMap<UndirectedGraphNode,UndirectedGraphNode> map,UndirectedGraphNode node) {
        if(node == null){
            return ;
        }
        for(UndirectedGraphNode temp:node.neighbors){
            if(!map.containsKey(temp)){
                UndirectedGraphNode newug=new UndirectedGraphNode(temp.label);
                map.put(temp,newug);
                cloneGraphdfs2(map,temp);//dfs

            }
            map.get(node).neighbors.add(map.get(temp));//todo:注意这里添加的时候克隆的节点，而不是原节点
        }

    }
}
