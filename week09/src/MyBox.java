public class MyBox<T> {
    private T item;

    public void set(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }

    @Override
    public String toString() {
        return "MyBox{" +
                "item=" + item +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyBox<?> other = (MyBox<?>) o;
        if (item == null) {
            return other.item == null;
        }
        return item.equals(other.item);
    }
}