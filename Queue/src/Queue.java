class Q{
    int size;
    int front,rear;
    int arr[];
    Q(int n){
        this.size=n;
        arr=new int[size];
        front=-1;
        rear=-1;
    }

    void enqueue(int data){
        if(rear==size-1){
            System.out.println("Queue is full");
            return;
        }
        else if(rear==-1){
            rear=front=0;
        }
        else
            rear++;
        arr[rear]=data;
    }

    void peak(){
        if(front==-1){
            System.out.println("Queue is empty");
        }
        else
            System.out.println("Peak element of queue is "+arr[front]);
    }

    void dequeue(){
        int del;
        if(front==-1 || front==size){
            System.out.println("Index out of bound");
        }
        else {
            del=arr[front];
            System.out.println("Deleted data is "+del);
            front++;
        }

    }

    void disp(){
        if(front==-1)
            System.out.println("Queue is empty");
        else{
            for(int i=front;i<=rear;i++){
                System.out.print(arr[i]+" ->");
            }
            System.out.println("Null");
        }
    }

}
public class Queue {
    public static void main(String[] args) {
        Q ob=new Q(5);
        ob.dequeue();
        ob.enqueue(87);
        ob.enqueue(8);
        ob.enqueue(7);
        ob.enqueue(287);
        ob.enqueue(8237);
        ob.dequeue();
        ob.peak();
        ob.disp();

    }
}