class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> val = new Stack();
    Stack<Long> diff = new Stack();
    public void push(int x) {
        val.push(x);
        diff.push((long)min - (long)x);
        if (min > x)
            min = x;
    }

    public void pop() {
        val.pop();
        long offset = diff.pop();
        if (offset > 0)
            min = (int)((long)min + offset);
    }

    public int top() {
        return val.peek();
    }

    public int getMin() {
        return min;
    }
}
