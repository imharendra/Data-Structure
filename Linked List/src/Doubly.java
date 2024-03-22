class ListNode2{
    int data;
    ListNode2 next;
    ListNode2 prev;
    ListNode2(int data){
        this.data=data;
        next=null;
        prev=null;
    }
}

class DoublyList{
    ListNode2 head;
    DoublyList(){
        head=null;
    }

    void addFirst(int data){
        ListNode2 ptr=new ListNode2(data);
        if(head==null){
            head=ptr;
        }
        else{
            ptr.next=head;
            head.prev=ptr;
            head=ptr;
        }
    }

    void addAtLast(int data){
        ListNode2 ptr=new ListNode2(data);
        if(head==null){
            head=ptr;
        }
        else{
            ListNode2 temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=ptr;
            ptr.prev=temp;
        }
    }
    int count(){
        int ans=0;
        if(head==null){
            return ans;
        }
        else{
            ListNode2 temp=head;
            while(temp!=null){
                ans++;
                temp=temp.next;
            }
        }
        return ans;
    }
    void addAtIndex(int data, int posi){
        if(posi>count() || posi<0){
            System.out.println("Invalid Index");
        }
        else{
            ListNode2 ptr=new ListNode2(data);
            int i=1;
            ListNode2 temp=head;
            while(i<posi){
                temp=temp.next;
                i++;
            }
            ptr.next=temp.next;
            ptr.prev=temp;
            temp.next.prev=ptr;
            temp.next=ptr;
        }
    }

    void removeFirst(){
        int del;
        if(head==null)
            System.out.println("List Is Already empty!");
        else if(head.next==null){
            del=head.data;
            System.out.println("Deleted data is "+del);
            head=null;
        }
        else{
            ListNode2 temp=head;
            head=head.next;
            head.prev=null;
            del=temp.data;
            System.out.println("Deleted data is "+del);
            temp=null;
        }
    }

    void removeLast(){
        int del;
        if(head==null)
            System.out.println("List is already Empty");
        else if(head.next==null){
            del=head.data;
            System.out.println("Deleted data is "+del);
            head=null;
        }
        else{
            ListNode2 temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            del=temp.data;
            System.out.println("Deleted data is "+del);
            temp.prev.next=null;
            temp=null;
        }
    }

    void disp(){
        if(head==null)
            System.out.println("List is Empty");
        else{
            ListNode2 temp=head;
            while(temp!=null){
                System.out.print(temp.data+" ->");
                temp=temp.next;
            }
            System.out.println("null");
        }
    }
}

class Doubly{
    public static void main(String[] args) {
        DoublyList list=new DoublyList();
        list.disp();
        list.addAtLast(83);
        list.addFirst(34);
        list.addFirst(868);
        list.addAtIndex(322,2);
        list.addAtLast(23);
        list.disp();
        System.out.println("Nodes count is "+list.count());
        list.removeFirst();
        list.removeLast();
        list.removeFirst();
        list.disp();
        System.out.println(list.count());

    }
}
