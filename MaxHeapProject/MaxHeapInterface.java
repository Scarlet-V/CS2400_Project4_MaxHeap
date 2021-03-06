package MaxHeapProject;

public interface MaxHeapInterface<T extends Comparable<? super T>>
{
    public void add(T newEntry);
    public T removeMax();
    public T getMax();
    public boolean isEmpty();
    public int getSize();
    public void clear();
    public T getElementAt(int index);
    public int getSeqSwap();
    public int getOptSwap();
}
