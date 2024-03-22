class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}

class Stack{
    Node top;
    Stack(){
        top=null;
    }

    void push(int data){
        Node ptr=new Node(data);
        if(top==null){
            top=ptr;
        }
        else{
            ptr.next=top;
            top=ptr;
        }
    }

    void pop(){
        int del=0;
        if(top==null)
            System.out.println("Stack is empty");
        else {
           del=top.data;
            System.out.println("Deleted top element is "+ del);
            Node temp=top;
            top=top.next;
            temp=null;
        }
    }

    void disp(){
        if(top==null)
            System.out.println("Stack is null");
        else{
            Node temp=top;
            while(temp!=null){
                System.out.print(temp.data+" ->");
                temp=temp.next;
            }
            System.out.println("null");
        }
    }
    void peak(){
        if(top==null)
            System.out.println("Stack in null");
        else{
            System.out.println("Peak of stack is "+ top.data);
        }
    }
}

 class DynamicStack{
    public static void main(String[] args) {
        Stack st=new Stack();
        st.disp();
        st.pop();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.disp();
        st.pop();
        st.pop();
        st.disp();
        st.peak();
    }
}