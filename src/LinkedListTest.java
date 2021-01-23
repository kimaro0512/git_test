public class LinkedListTest {


     //Definition for singly-linked list.
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    static class Solution {
         Solution() {};
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode ret = null;
            ListNode cur = null;

            int m = 0;
            while(true) {
                if(l1 == null && l2 == null) {
                    if(m > 0) {
                        ListNode node = new ListNode(m);
                        cur.next = node;
                        cur = node;
                    }
                    break;
                }

                int sum = 0;
                if(l1 != null && l2 != null) {
                    sum = l1.val + l2.val + m;
                    m = sum / 10;
                    sum = sum % 10;
                    l1 = l1.next;
                    l2 = l2.next;
                }
                else if(l1 == null) {
                    sum = l2.val + m;
                    m = sum / 10;
                    sum = sum % 10;
                    l2 = l2.next;
                }
                else if(l2 == null) {
                    sum = l1.val + m;
                    m = sum / 10;
                    sum = sum % 10;
                    l1 = l1.next;
                }

                if(cur == null) {
                    cur = new ListNode(sum);
                    ret = cur;
                    System.out.println(cur == ret);
                }
                else {
                    ListNode node = new ListNode(sum);
                    cur.next = node;
                    cur = node;
                }
            }

            System.out.println(ret);
            System.out.println(cur);

            return ret;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        Solution solution = new Solution();
        ListNode l3 = solution.addTwoNumbers(l1, l2);
        System.out.println(l3.val);
    }
}
