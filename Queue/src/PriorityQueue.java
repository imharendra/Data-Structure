class PQ{
    int size;
    int arr[];
    int front,rear;
     PQ(int n){
        this.size=n;
        arr=new int[size];
        front =rear=-1;
    }

    void enQueue(int x){
        if(rear==size-1)
            System.out.println("Overflow");
        else if(rear==-1){
            front=rear=0;
            arr[rear]=x;
        }
        else {
            check(x);
            rear++;
        }
    }

    void check(int x){
         int i=0;
        for(i=0;i<=rear;i++){
            if(arr[i]>x){
                int j=rear+1;
                for(j=rear+1;j>i;j--){
                    arr[j]=arr[j-1];
                }
                arr[j]=x;
                return;
            }
        }
        arr[i]=x;
    }

    void deQueue(){
        int data;
        if(front==-1)
            System.out.println("UnderFlow");
        else if(front==rear){
            data=arr[front];
            System.out.println("Deleted data is "+ data);
            rear=front=-1;
        }
        else {
            data=arr[front];
            System.out.println("Deleted data is "+ data);
            front++;
        }
    }

    void peak(){
        if(front==-1)
            System.out.println("Queue is empty");
        else {
            System.out.println("Peak element is "+ arr[front]);
        }
    }

    void disp(){
        if(front==-1){
            System.out.println("Queue is Empty");
        }
        else{
            for(int i=front;i<=rear;i++){
                System.out.print(arr[i]+"-> ");
            }
            System.out.println("Null");
        }
    }
}

class PriorityQueue{
    public static void main(String k[]){
        PQ p=new PQ(5);
        p.disp();
        p.enQueue(34);
        p.enQueue(21);
        p.enQueue(432);
        p.enQueue(42);
        p.disp();
        p.deQueue();
        p.peak();
        p.disp();
    }
}