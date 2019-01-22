package medium.ergodic;

import java.util.*;

/**
 * @author YangShuo
 * @create 2019/1/22
 * @comment
 */

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time.
 Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

 Note:

 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.

 Input:
 beginWord = "hit",
 endWord = "cog",
 wordList = ["hot","dot","dog","lot","log","cog"]

 Output: 5

 Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.
 */
public class WordLadderI {

    public static void main(String[] args) {

        String[] a={"hot","dot","dog","lot","log","cog"};

        List<String> list=new ArrayList<>();

        list= Arrays.asList(a);


        int i = ladderLength("hit","cog",list);

        System.out.print("结果是" + i);
    }
    //利用bfs广度优先遍历
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set wordListSet = new HashSet(wordList);
        //创建队列
        LinkedList<String> quen=new LinkedList<>();
        int allword=1;
        quen.add(beginWord);
        while(!quen.isEmpty()){
            String temp=quen.poll();
            //把字符串转化为字符数组
            System.out.println("队列元素"+temp);


            for(int i=0;i<temp.length();i++){

                char index='a';
                char ss[] = temp.toCharArray();

                while(index-96<27){

                    //System.out.println("index---"+index);

                    ss[i] = index;
                   index++;
                   String t = String.valueOf(ss);
                   // System.out.println("转换后"+t);


                   if(t.equals(endWord)){
                       return allword+1;
                   }
                   if(wordListSet.contains(t)){
                       System.out.println("转换后"+t);
                       allword++;

                       quen.add(t);
                       wordListSet.remove(t);
                   }
                }

            }
        }


        return 0;
    }
}
