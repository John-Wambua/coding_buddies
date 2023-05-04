class LLNode{
    public next: LLNode|null
    constructor(public data: number) {
        this.next = null;
    }
}

class LinkedListStack {
    private stackTop: LLNode | null;
    private stackSize: number

    constructor() {
        this.stackTop = null;
        this.stackSize = 0
    }
    push(data: number): void {
        const node = new LLNode(data);
        node.next=this.stackTop;
        this.stackTop = node;
        this.stackSize++;
    }
    pop(): number {
        if (this.stackSize === 0){
            return Number.MIN_VALUE;
        }
        const temp = this.stackTop!;
        this.stackTop = this.stackTop!.next;
        const data = temp.data;
        this.stackSize--;
        return data;
    }
    getSize(): number {
        return this.stackSize;
    }
    isEmpty(): boolean {
        return this.stackSize === 0;
    }
    peek(): number {
        if (this.stackSize===0){
            console.log("Stack is empty")
            return Number.MIN_VALUE;
        }
        return this.stackTop!.data;
    }

}
const stack = new LinkedListStack();
stack.push(2);
stack.push(15);
stack.push(20);
console.log(stack.peek())
stack.pop();
console.log(stack.peek())
console.log(stack.getSize())