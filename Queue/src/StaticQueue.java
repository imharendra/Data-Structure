class AQueue{
    int q[];
    int front,rear,size;
    AQueue(int n){
        this.size=n;
        q=new int[size];
        front=-1;
        rear=-1;
    }

    void add(int data){
        if(rear==size-1){
            System.out.println("Queue is full");
            return;
        }
        else if(front==-1){
            front=rear=0;
        }
        else{
            rear++;
        }
        q[rear]=data;
    }
    void del(){
        int value;
        if(front==-1){
            System.out.println("Queue is already empty");
        }
        else if(front==rear){
           value=q[front];
           front=rear=-1;
        }
        else{
            front++;
        }
    }
    void peak(){
        if(front==-1)
            System.out.println("Queue is empty");
        else
            System.out.println("Peak element is "+q[front]);
    }
    void disp(){
        if(front==-1)
            System.out.println("Queue is empty");
        else{
            for(int i=front;i<=rear;i++){
                System.out.print(q[i]+" -> ");
            }
            System.out.println("null");
        }
    }
}

class StaticQueue{
    public static void main(String k[]){
        AQueue ob=new AQueue(5);
        ob.add(12);
        ob.add(78);
        ob.add(67);
        ob.add(45);
        ob.disp();
        ob.peak();
        ob.del();
        ob.disp();
    }
}