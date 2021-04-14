package MaxHeapProject;
public final class MaxHeap<T extends Comparable<? super T>> implements MaxHeapInterface<T>
{
    private T[] heap;
    private int lastIndex;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;
    public int seqSwap=0;
    public int optSwap=0;

    public MaxHeap()
    {
        this(DEFAULT_CAPACITY);
    }


    public MaxHeap(int initialCapacity)
    {
        if(initialCapacity < DEFAULT_CAPACITY)
        {
            initialCapacity=DEFAULT_CAPACITY;
        }
        else if(initialCapacity>MAX_CAPACITY) initialCapacity=MAX_CAPACITY;
        @SuppressWarnings("unchecked")
        T[] tempHeap=(T[]) new Comparable[initialCapacity + 1];
        heap=tempHeap;
        lastIndex=0;
        initialized=true; 
    }

    public int getSeqSwap()
    {
        return seqSwap;
    }

    public int getOptSwap()
    {
        return optSwap;
    }

    public T getElementAt(int index)
    {
        return heap[index];
    }

    public T getMax()
    {
        checkInitialization();
        T root = null;
        if(!isEmpty()) root = heap[1];
        return root;
    }

    public boolean isEmpty()
    {
        return lastIndex < 1;
    }

    public int getSize()
    {
        return lastIndex;
    }

    public void clear()
    {
        checkInitialization();
        while(lastIndex > -1)
        {
            heap[lastIndex]=null;
            lastIndex--;
        }
        lastIndex=0;
    }

    public void checkInitialization()
    {
        if(!initialized)
        {
        @SuppressWarnings("unchecked")
        T[] tempHeap=(T[]) new Comparable[DEFAULT_CAPACITY + 1];
        heap=tempHeap;
        lastIndex=0;
        initialized=true; 
        }
    }

    public void add(T newEntry)
    {
        checkInitialization();
        int newIndex = lastIndex+1;
        int parentIndex=newIndex/2;
        while((parentIndex>0) && newEntry.compareTo(heap[parentIndex])>0)
        {
            heap[newIndex] = heap[parentIndex];
            newIndex = parentIndex;
            parentIndex = newIndex/2;
            seqSwap++;
        }
        heap[newIndex] = newEntry;
        lastIndex++;
    }

    public T removeMax()
    {
        checkInitialization();
        T root = null;
        if(!isEmpty())
        {
            root = heap[1];
            heap[1]=heap[lastIndex];
            lastIndex--;
            reheap(1);
        }
        return root;
    }
}
