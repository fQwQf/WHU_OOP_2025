public class NumberSummer implements Processor<Integer> {
    private int sum = 0;

    @Override
    public void process(Integer item) {
        sum += item;
    }

    public int getSum() {
        return sum;
    }
}