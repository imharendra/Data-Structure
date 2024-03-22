class ListNode4{
    int data;
    ListNode4 next;
    ListNode4 prev;
    ListNode4(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}

class DoublyCircularList{
    ListNode4 start;
    ListNode4 last;
    DoublyCircularList(){
        start=null;
        last=null;
    }

    void addFirst(int data){
        ListNode4 ptr=new ListNode4(data);
        if(start==null){
            start=last=ptr;
            last.next=start;
            start.prev=last;
        }
        else {
            ptr.next = start;
            start.prev=ptr;
            start = ptr;
            last.next = start;
            start.prev=last;
        }
    }

    void addLast(int data){
        ListNode4 ptr=new ListNode4(data);
        if(start==null)
        {
            start=last=ptr;
            last.next=start;
            start.prev=last;
        }
        else{
            last.next=ptr;
            ptr.prev=last;
            last=ptr;
            last.next=start;
            start.prev=start;
        }
    }

    void addAtIndex(int data, int posi) {
        if (posi > count() || posi < 0) {
            System.out.println("Invalid Position");
        } else if (posi == 0) {
            addFirst(data);
        } else if (posi == count())
            addLast(data);
        else {
            ListNode4 ptr=new ListNode4(data);
            ListNode4 temp=start;
            int i=0;
            while(i<posi-1){
                temp=temp.next;
                i++;
            }
            ptr.next=temp.next;
            ptr.next.prev=ptr;
            ptr.prev=temp;
            temp.next=ptr;
        }
    }
    int count(){
        int c=0;
        if(start==null)
            return 0;
        else{
            ListNode4 temp=start;
            do{
                c++;
                temp=temp.next;
            }while(temp!=start);
        }
        return c;
    }

    void removeFirst(){
        int del;
        if(start==null)
            System.out.println("List is Already empty");
        else if(start==last){
            del=start.data;
            System.out.println("Deleted element is "+del);
            start=last=null;
        }
        else{
            start=start.next;
            last.next=start;
            start.prev=last;
        }
    }

    void removeLast(){
        int del;
        if(start==null)
            System.out.println("List is Already empty");
        else if(start==last){
            del=start.data;
            System.out.println("Deleted element is "+del);
            start=last=null;
        }
        else{
            ListNode4 temp=start;
            while(temp.next!=last){
                temp=temp.next;
            }
            last=temp;
            temp=temp.next;
            last.next=start;
            start.prev=last;
            temp=null;
        }
    }

    void removeAtIndex(int posi) {
        if (posi >= count() || posi < 0) {
            System.out.println("Invalid Position");
        } else if (posi == 0) {
            removeFirst();
        } else if (posi == count()-1)
            removeLast();
        else {
            ListNode4 temp=start;
            ListNode4 prev=null;
            int i=0;
            while(i<posi){
                prev=temp;
                temp=temp.next;
                i++;
            }
            prev.next=temp.next;
            prev.next.prev=prev;
            temp=null;
        }
    }

    void getFirst(){
        if(start==null)
            System.out.println("List is empty");
        else{
            System.out.println("1st element is "+ start.data);
        }
    }
    void getLast(){
        if(last==null)
            System.out.println("List is empty");
        else
            System.out.println("Last element is "+ last.data);
    }

    void disp(){
        if(start==null)
            System.out.println("List is empty");
        else
        {
            ListNode4 temp=start;
            do{
                System.out.print(temp.data+"->");
                temp=temp.next;
            }while(temp!=start);
            System.out.println("Null");
        }
    }


}

class DoublyCircular{
    public static void main(String[] args) {
        DoublyCircularList dc=new DoublyCircularList();

        dc.addFirst(30);
        dc.addFirst(20);
        dc.addLast(40);
        dc.addLast(50);
        dc.addLast(60);
        dc.addFirst(10);
        dc.addLast(70);
        dc.disp();
        dc.getFirst();
        dc.getLast();
        dc.removeLast();
        dc.disp();
        dc.addAtIndex(15,1);
        dc.disp();
        dc.removeAtIndex(5);
        dc.disp();
        System.out.println(dc.count());
    }
}