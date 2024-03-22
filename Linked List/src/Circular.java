class ListNode3{
    int data;
    ListNode3 next;
    ListNode3(int data){
        this.data=data;
        this.next=null;
    }
}

class CircularList{
    ListNode3 start;
    ListNode3 last;
    CircularList(){
        start=null;
        last=null;
    }

    void addFirst(int data){
        ListNode3 ptr=new ListNode3(data);
        if(start==null){
            start=last=ptr;
            last.next=start;
        }
        else {
            ptr.next = start;
            start = ptr;
            last.next = ptr;
        }
    }

    void addLast(int data){
        ListNode3 ptr=new ListNode3(data);
        if(start==null)
        {
            start=last=ptr;
            last.next=start;
        }
        else{
            last.next=ptr;
            last=ptr;
            last.next=start;
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
            ListNode3 ptr=new ListNode3(data);
            ListNode3 temp=start;
            int i=0;
            while(i<posi-1){
                temp=temp.next;
                i++;
            }
            ptr.next=temp.next;
            temp.next=ptr;
        }
    }
    int count(){
        int c=0;
        if(start==null)
            return 0;
        else{
            ListNode3 temp=start;
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
            ListNode3 temp=start;
            while(temp.next!=last){
                temp=temp.next;
            }
            last=temp;
            last.next=start;
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
            ListNode3 temp=start;
            ListNode3 prev=null;
            int i=0;
            while(i<posi){
                prev=temp;
                temp=temp.next;
                i++;
            }
            prev.next=temp.next;
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
            ListNode3 temp=start;
            do{
                System.out.print(temp.data+"->");
                temp=temp.next;
            }while(temp!=start);
            System.out.println("Null");
        }
    }


}

class Circular{
    public static void main(String[] args) {
        CircularList cl=new CircularList();

        cl.addFirst(30);
        cl.addFirst(20);
        cl.addLast(40);
        cl.addLast(50);
        cl.addLast(60);
        cl.addFirst(10);
        cl.addLast(70);
        cl.disp();
        cl.getFirst();
        cl.getLast();
        cl.removeLast();
        cl.disp();
        cl.addAtIndex(15,1);
        cl.disp();
        cl.removeAtIndex(5);
        cl.disp();
        System.out.println(cl.count());
    }
}