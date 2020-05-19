import java.util.*;
import java.io.*;
class Linked
{
    Node head;
    Node slow_ptr,fast_ptr,second_half;
    class Node
    {
        char data;
        Node next;
        Node(char d)
        {
            data=d;
            next=null;
        }
    }
    boolean ispalindrome(Node head)
    {
        slow_ptr=head;
        fast_ptr=head;
        Node prev_of_slow_ptr=head;
        Node midnode=null;
        boolean res=true;
        if(head!=null&& head.next!=null)
        {
            while(fast_ptr!=null && fast_ptr.next!=null)
            {
                fast_ptr=fast_ptr.next.next;
                prev_of_slow_ptr=slow_ptr;
                slow_ptr=slow_ptr.next;
            }
            if(fast_ptr!=null)
            {
                midnode=slow_ptr;
                slow_ptr=slow_ptr.next;
            }
            second_half=slow_ptr;
            prev_of_slow_ptr.next=null;
            reverse();
            res=compareLists(head,second_half);
            reverse();
            if(midnode!=null)
            {
                 prev_of_slow_ptr.next=midnode;
                 midnode.next=second_half;
            }
            else
                prev_of_slow_ptr.next=second_half;
        }
        return res;
    }
    void reverse()
    {
        Node prev=null;
        Node current=second_half;
        Node next;
        while(current!=null)
        {
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        second_half=prev;
    }
    boolean compareLists(Node head1,Node head2)
    {
        Node temp1=head1;
        Node temp2=head2;
        while(temp1!=null && temp2!=null)
        {
            if(temp1.data==temp2.data)
            {
                temp1=temp1.next;
                temp2=temp2.next;
            }
            else
             return false;
        }
        if(temp1==null && temp2==null)
        return true;
        else
        return false;
    }
    public void push(char new_data)
    {
        Node new_node=new Node(new_data);
        new_node.next=head;
        head=new_node;
    }
    void printList(Node ptr)
    {
        while(ptr!=null)
        {
            System.out.print(ptr.data + "->");
            ptr=ptr.next;
        }
        System.out.println("NULL");
    }
    public static void main(String[] args)
    {
        LinkedList llist=new LinkedList();
        char str[]={'a','b','a','c','a','b','a'};
        String string=new String(str);
        for(int i=0;i<7;i++)
        {
            llist.push(str[i]);
            llist.printList(llist.head);
            if(llist.ispalindrome(llist.head)!=false)
            {
               System.out.println("Is Palindrome");
               System.out.print(" ");
            }
            else
            {
                System.out.println("Not Palindrome");
               System.out.print(" ");
            }
        }
    }
}
