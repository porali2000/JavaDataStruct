package retries;

public class HashEqual {
    int x;
    public HashEqual(int x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
