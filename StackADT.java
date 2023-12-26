package personal;

import java.util.Scanner;

public class StackADT {

	//we need array, tos(top of stack), MaxSize of the stack
	int stack[], tos, MaxSize;
	
	//ADT we need --> createStack(), void push(int num), int pop(), int peek(), boolean isFull(), boolean isEmpty() 
	void createStack(int size) {
		stack = new int[size];
		tos = -1;
		MaxSize = size; 
	}//end create stack
	
	void push(int num) {
		stack[++tos] = num;
	}//end of push
	
	int pop() {
		return stack[tos--];
	}//end of pop
	
	int peek() {
		return stack[tos];
	}//end of peek
	
	boolean isFull() {
		return tos == MaxSize - 1;
	}//end of is full
	
	boolean isEmpty() {
		return tos == - 1;
	}//end of is empty
	
	void printStack() {
		for(int i = tos; i > -1; i--) {
			System.out.print(stack[i] + " ");
		}//end for
	}//end print stack
	
	public static void main(String[] args) {
		StackADT obj = new StackADT();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of Stack");
		int size = sc.nextInt();
		obj.createStack(size);
		int ch;
		do {
			System.out.println("1. Push \n2. Pop \n3. Peek \n4. Print \n0. Exit");
			ch = sc.nextInt();
			switch(ch) {
			case 1:{
				if(!obj.isFull()) {
					System.out.println("Enter number");
					int num = sc.nextInt();
					obj.push(num);
					System.out.println("Number ::" + num + "pushed in the stack");
				}else
					System.out.println("Stack is FULL");
				break;
				}//end case 1
			case 2:{
				if(!obj.isEmpty()) {
					System.out.println(obj.pop() + " is popped out from stack");
				}else
					System.out.println("Stack is EMPTY");
				break;
			}//end case 2
			case 3:{
				if(!obj.isEmpty()) {
					System.out.println(obj.peek() + " is the Element at peak");
				}else
					System.out.println("Stack is EMPTY");
				break;
			}//end case 3
			case 4:{
				if(!obj.isEmpty()) {
					System.out.println("Elements on the stack are");
					obj.printStack();
				}else
					System.out.println("Stack is EMPTY");
				break;
			}//end case 4
			case 0:
				System.out.println("System is Exiting");
				break;
			default: System.out.println("Wrong Choice");
				break;
			}//end switch
		}while(ch!=0);
		sc.close();
	}//end main
	
}
