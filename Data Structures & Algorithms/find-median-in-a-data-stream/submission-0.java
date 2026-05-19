class MedianFinder {

    PriorityQueue<Integer> minn = new PriorityQueue<>();
    PriorityQueue<Integer> maxx = new PriorityQueue<>((a, b)-> b-a);

    public MedianFinder() {
        minn.clear();
        maxx.clear();
    }
    
    public void addNum(int num) {
        maxx.add(num);
        minn.add(maxx.poll());

        if(maxx.size() < minn.size()){
            maxx.add(minn.poll());
        }
    }
    
    public double findMedian() {
        if(minn.size() == maxx.size()){
            return (double)((minn.peek() + maxx.peek())/2.0);
        }
        return (double)(maxx.peek());
    }
}
