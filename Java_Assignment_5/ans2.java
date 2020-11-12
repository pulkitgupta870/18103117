import java.util.*;
	import java.lang.*;
	public class ans2 extends Thread
	{
	    static int factors = 0;
	    static int cur = 0;        
	    int start;
	    ans2(int start)
	    {
	        this.start = start;
	    }
	    public void run()
	    {
	        int temp=0;
	        for(int i=start; i<this.start+10000; i++)
	        {
	            temp=0;
	            for(int j=1; j<=i; j++)
	            {
	                if(i%j==0)
	                {
	                    temp+=1;
	                }
	            }
	            if(temp>factors)
	            {
	                synchronized(this)
	                {
	                    factors = temp;
	                    cur = i;
	                }
	            }
	        }
	    }
	    public static void main(String[] args)
	    {
	        ans2 thread1 = new ans2(1);
	        ans2 thread2 = new ans2(10001);
	        ans2 thread3 = new ans2(20001);
	        ans2 thread4 = new ans2(30001);
	        ans2 thread5 = new ans2(40001);
	        ans2 thread6 = new ans2(50001);
	        ans2 thread7 = new ans2(60001);
	        ans2 thread8 = new ans2(70001);
	        ans2 thread9 = new ans2(80001);
	        ans2 thread10 = new ans2(90001);
	        long st = System.currentTimeMillis();
	        thread1.start();
	        thread2.start();
	        thread3.start();
	        thread4.start();
	        thread5.start();
	        thread6.start();
	        thread7.start();
	        thread8.start();
	        thread9.start();
	        thread10.start();
	        try{
	        thread1.join();
	        thread2.join();
	        thread3.join();
	        thread4.join();
	        thread5.join();
	        thread6.join();
	        thread7.join();
	        thread8.join();
	        thread9.join();
	        thread10.join();
	        }
	        catch(Exception e)
	        {
	            System.out.println(e);
	        }
	        Long et = System.currentTimeMillis();
	        System.out.println("Number having the highest factors = " + cur + ", which has factors = " + factors);
	        System.out.println("Time taken : " + (et -st) + " ms.");
	    }
	}

