class ListNode1{
    int data;
    ListNode1 next;
    ListNode1(int data){
        this.data=data;
        this.next=null;
    }
}
class Queue{
    ListNode1 front;
    ListNode1 rear;

    void add(int data){
        ListNode1 ptr=new ListNode1(data);
        if(front==null){
            front=ptr;
            rear=ptr;
        }
        else {
            rear.next = ptr;
            rear=ptr;
        }
    }
    void remove(){
        int value;
        if(front==null){
            System.out.println("Queue is empty");
        }
        else if(front==rear){
            value=front.data;
            front=rear=null;
        }
        else{
            value=front.data;
            front=front.next;
        }
    }
    void peak(){
        if(front==null){
            System.out.println("Queue is empty");
        }
        else {
            System.out.println("Data is "+ front.data);
        }
    }
    void disp(){
        if(front==null){
            System.out.println("Queue is empty");
        }
        else{
            ListNode1 temp=front;
            while(temp!=null){
                System.out.print(temp.data +" -> ");
                temp=temp.next;
            }
            System.out.println("null");
        }
    }

}

class DynamicQueue{
    public static void main(String k[]){
        Queue ob=new Queue();
        ob.add(10);
        ob.add(20);
        ob.add(30);
        ob.add(40);
        ob.peak();
        ob.disp();
        ob.remove();
        ob.remove();
        ob.disp();
        ob.peak();
        //ob.disp();

    }
}