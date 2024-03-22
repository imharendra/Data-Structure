class Stack1{
    int top;
    int size;
    int arr[];
    Stack1(int n){
        this.size=n;
        top=-1;
        arr=new int[size];
    }

    void push(int data){
        if(top==size-1){
            System.out.println("Stack is full");
        }
        else{
            top++;
            arr[top]=data;
        }
    }

    void pop(){
        int del;
        if(top==-1){
            System.out.println("The Stack is already empty");
        }
        else{
            del=arr[top];
            top--;
            System.out.println("Deleted top element is "+del);
        }
    }

    void disp(){
        if(top==-1)
            System.out.println("Stack is empty");
        else{
            for(int i=0;i<=top;i++){
                System.out.print(arr[i]+" ->");
            }
            System.out.println("null");
        }
    }
}

public class StackByArray{
    public static void main(String[] args) {
        Stack1 st=new Stack1(5);
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.push(60);
        st.disp();
        st.pop();
        st.pop();
        st.push(40);
        st.disp();
    }
}