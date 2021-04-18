package MaxHeapProject;

import java.util.*;
import java.io.*;

public class Main 
{
    public static void main(String arg[])
    {
        try{
            MaxHeapInterface heap = new MaxHeap<Integer>(100);
            
            File file = new File("datasorted.txt");
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
    
    
    }    
}
