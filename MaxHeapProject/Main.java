package MaxHeapProject;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String arg[])
    {
        try{
        MaxHeapInterface heap = new MaxHeap<Integer>(100);
        
        File file = new File("data_sorted.txt");
        File outFile=new File("output.txt");
        RandomAccessFile inpRaf= new RandomAccessFile(file,"rw");
        RandomAccessFile raf= new RandomAccessFile(outFile,"rw");
        raf.writeBytes("Heap built using sequential insertion: ");
        Integer num;
        Integer array[]=new Integer[100];
        int count=0;
        while(inpRaf.getFilePointer()<inpRaf.length())
        {
            num=Integer.parseInt(inpRaf.readLine());
            array[count++]=num;
            heap.add(num);
        }
        
        for(int i=1;i<=10;++i)
        {
            raf.writeBytes(String.valueOf((Integer)heap.getElementAt(i))+" ");
        }
        raf.writeBytes("\n");
        raf.writeBytes("Number Of Swaps performed in Sequential Heap: "+heap.getSeqSwap()+"\n");
        raf.writeBytes("Heap after 10 removals: ");
        
        for(int i=0;i<10;++i) heap.removeMax();
        for(int i=1;i<=10;++i) raf.writeBytes(String.valueOf((Integer)heap.getElementAt(i))+" ");
        raf.writeBytes("\n");
        MaxHeapInterface optHeap=new MaxHeap(array);
        raf.writeBytes("Heap built using optimal insertion: ");
        for(int i=1;i<=10;++i)
        {
            raf.writeBytes(String.valueOf(optHeap.getElementAt(i))+" ");
        }
        raf.writeBytes("\n");
        raf.writeBytes("Number Of Swaps performed in Sequential Heap: "+optHeap.getOptSwap()+"\n");
        raf.writeBytes("Heap after 10 removals: ");
        for(int i=0;i<10;++i) optHeap.removeMax();
        for(int i=1;i<=10;++i)
        {
            raf.writeBytes(String.valueOf(optHeap.getElementAt(i))+" ");
        }
        raf.close();
        inpRaf.close();

    }
    catch(IOException io)
    {
        System.out.println(io);
    }
    }
   
}
