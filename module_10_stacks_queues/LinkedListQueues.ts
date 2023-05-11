class LLNode{
    public next: LLNode|null
    constructor(public data: number) {
        this.next = null;
    }
}

class LinkedListQueue {
    private first: LLNode | null;
    private last: LLNode | null;

    constructor() {
        this.first = null;
        this.last = null;
    }
    //Add at the rear (enqueue)
    add(data: number): void {
        const node = new LLNode(data);
        if (this.last!==null){
            this.last.next = node;
        }
        this.last = node
        if (this.first === null){
            this.first = this.last;
        }
    }
    remove(): number {
        if (this.isEmpty()) {
            throw Error("Empty!")
        }
        const data = this.first.data;
        this.first = this.first.next;
        if (this.first === null){
            this.last = null;
        }
        return data;
    }
    isEmpty(): boolean {
        return this.first===null;
    }
    peek(): number {
       if (this.isEmpty()){
           throw Error("Empty!")
       }
       return this.first.data;
    }

}
const queue = new LinkedListQueue();
queue.add(2);
queue.add(5);
queue.add(7);
console.log(queue.peek())
console.log(queue)