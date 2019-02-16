package medium.link;

/**
 * @author YangShuo
 * @create 2019/2/15
 * @comment
 */
/**
 * 138. Copy List with Random Pointer
 */

class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  };

public class CopyListwithRandomPointer {
    /**
     * 赋值带有随机指针的链表
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head ==null){
            return head;
        }
        RandomListNode newhead=head;
        //给每个节点后边添加一个新节点
        while(newhead != null){
            RandomListNode newnode=new RandomListNode(newhead.label);
            newnode.next=newhead.next;
            newhead.next=newnode;
            newhead=newnode.next;
        }

        //复制每个节点的随机指针
        newhead=head;

        while(newhead!=null ){
            if(newhead.random!=null)
                newhead.next.random=newhead.random.next;


            newhead=newhead.next.next;

        }
        RandomListNode newHead = head.next;

        newhead = head;
        while(newhead != null){
            RandomListNode newNode = newhead.next;
            newhead.next = newNode.next;
            if(newNode.next!=null)
                newNode.next = newNode.next.next;
            newhead = newhead.next;
        }

        return newHead;
    }

}
