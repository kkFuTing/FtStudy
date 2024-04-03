package com.futing.javalib.algorithm;


/**
 * Created by futing on 2024/4/3.
 */
public class ListNode {
    public static void main(String[] args) {
        Node node = new Node();
        Node header =node;
        for (int i = 0; i < 5; i++) {
            if (node.next != null){
                node = node.next;
            }
            node.val = i;
            node.next=new Node();
        }
        node.next = null;

        System.out.println("==结果测试==");
        while (header != null) {
            System.out.println(header.val);
            header = header.next;
        }
    }

    public static class Node {
        int val;
        Node next;

        public Node() {

        }

        public Node(int val) {
            this.val = val;
        }

        public Node(Node next) {
            this.next = next;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }


}
