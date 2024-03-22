class ListNode1{
    int data;
    ListNode1 next;
    ListNode1(int data){
        this.data=data;
        next=null;
    }
}
class SinglyList{
    ListNode1 head;
    SinglyList(){
        head=null;
    }

    void addFirst(int data){
        ListNode1 ptr=new ListNode1(data);
        if(head==null)
        {
            head=ptr;
        }
        else{
            ptr.next=head;
            head=ptr;
        }
    }

    void addLast(int data){
        ListNode1 ptr=new ListNode1(data);
        if(head==null)
            head=ptr;
        else{
            ListNode1 temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=ptr;
        }
    }

    int count(){
        int c=0;
        if(head==null)
            return 0;
        else{
            ListNode1 temp=head;
            while(temp!=null)
            {
                c++;
                temp=temp.next;
            }
        }
        return c;
    }

    void addAtIndex(int data,int posi){

        if(posi>count() || posi<0)
            System.out.println("Invalid Index!");
        else if(posi==0)
            addFirst(data);
        else if(posi==count())
            addLast(data);
        else{
            ListNode1 ptr=new ListNode1(data);
            int check=0;
            ListNode1 temp=head;
            while(check<posi-1){
                temp=temp.next;
                check++;
            }
            ptr.next=temp.next;
            temp.next=ptr;
        }
    }

    void removeFirst(){
        int del;
        if(head==null)
            System.out.println("List is already Empty");
        else{
            del=head.data;
            System.out.println("Deleted data is "+ del);
            head=head.next;
        }
    }

    void removeLast(){
        int del;
        if(head==null)
            System.out.println("List is already Empty");
        else if(head.next==null){
            head=null;
        }
        else{
            ListNode1 temp=head;
            ListNode1 prev=null;
            while(temp.next!=null){
                prev=temp;
                temp=temp.next;
            }
            del=temp.data;
            System.out.println("Deleted data is "+ del);
            prev.next=null;
            temp=null;
        }
    }

    void removeAtIndex(int posi){
        int del;
        if(head==null){
            System.out.println("List is already empty");
        }
        else if(posi>count() || posi<=0)
            System.out.println("Invalid position");
        else{
            int c=1;
            ListNode1 prev=null;
            ListNode1 temp=head;
            while(c<=posi){
                prev=temp;
                temp=temp.next;
                c++;
            }
            prev.next=temp.next;
            del=temp.data;
            temp=null;
            System.out.println("Deleted data is "+ del);
        }
    }

    void getFirst(){
        if(head==null)
            System.out.println("List Is Empty");
        else
            System.out.println("First Node is "+head.data);
    }

    void getLast(){
        if(head==null)
            System.out.println("List Is Empty");
        else{
            ListNode1 temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            System.out.println("Last Node is "+temp.data);
        }
    }

    void disp(){
        if(head==null)
            System.out.println("List Is Empty");
        else{
            ListNode1 temp=head;
            while(temp!=null){
                System.out.print(temp.data+" ->");
                temp=temp.next;
            }
            System.out.println("Null");
        }
    }

    void reverse(){
        //>> Most imp
        ListNode1 nextnode=null;
        ListNode1 prev=null;
        ListNode1 current=head;
        while(current!=null){
            nextnode=current.next;
            current.next=prev;
            prev=current;
            current=nextnode;
        }
        head=prev;
    }

}

class Singly{
    public static void main(String[] args) {
        SinglyList sl=new SinglyList();
        sl.removeFirst();
        sl.disp();
        sl.addFirst(34);
        sl.addFirst(76);
        sl.addLast(676);
        sl.addAtIndex(76,2);
        sl.disp();
        sl.reverse();
        sl.disp();
        sl.removeLast();
        sl.getFirst();
        sl.disp();

    }
}