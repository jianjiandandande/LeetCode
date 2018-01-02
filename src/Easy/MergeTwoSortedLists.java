package Easy;

/**
 * Created by Vincent on 2017/12/19.
 *
 *Description：Merge two sorted linked lists and return it as a new list. The new list should be made by splicing
 *together the nodes of the first two lists.
 *
 * 题目的要求是：输入两个已排好序的链表,然后返回一个新的链表，新链表应该通过拼接前两个链表的节点来完成。
 *
 */
public class MergeTwoSortedLists {

    public static void main(String[] args){


        MergeTwoSortedLists mtsl = new MergeTwoSortedLists();

        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);


        listNode.next = listNode1;
        listNode1.next = listNode2;

        listNode3.next = listNode4;
        listNode4.next = listNode5;
        System.out.println("???");
        ListNode listNode6 = mtsl.mergeTwoLists(listNode,listNode3);
        System.out.println("111");
        while(listNode6!=null){
            System.out.println(listNode6.val);
            listNode6 = listNode6.next;
        }

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            System.out.println(l1.val+","+l2.val);

            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;

            }
            temp = temp.next;

        }


        temp.next = l1 != null ? l1 : l2;

        return temp.next;
    }

    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

}
