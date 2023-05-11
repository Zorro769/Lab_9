import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws Exception {
        try{
            byte arr[] = new byte[8];
            System.out.println("The first stream");
            for(int i =0;i < arr.length;i++)
            {
                arr[i] = (byte)(Math.random() * 10);
                System.out.println(arr[i]);
            }

            byte[] arr_2 = new byte[8];
            System.out.println("The second stream");
            for(int i = 0;i < arr_2.length;i++)
            {
                arr_2[i] = (byte)(Math.random() * 10);
                System.out.println(arr_2[i]);
            }

            InputStream in1 = new ByteArrayInputStream(arr);
            InputStream in2 = new ByteArrayInputStream(arr_2);
            Vector myVector = new Vector();
            myVector.add(in1);
            myVector.add(in2);
            Enumeration num = myVector.elements();
            SequenceInputStream inAll = new SequenceInputStream(num);
            int countAll = 0;
            System.out.println("Consistent summary stream");
            int x;
            while((x = inAll.read()) != -1)
            {
                System.out.println(x + " ");
                countAll++;
            }
            System.out.println("Summary count of elements = " + countAll);
            in1.close();
            in2.close();
            inAll.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}