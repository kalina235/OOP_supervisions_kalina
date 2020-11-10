public class ex4
{
    public static int sum(int[] a, int i)
    {
        if (i == a.length) {
            return 0;
        }
        return a[i]+sum(a, i+1);
    }
    public static int[] cumSum(int[] a)
    {
        int[] pref =  new int[a.length];
        int i = 1;
        pref[0]=a[0];
        while (i < a.length)
        {
            pref[i]=pref[i-1]+a[i];
            i++;
        }
        return pref;
    }
    public static int[] positives(int[] a)
    {
        int j = 0;
        int[] pom = new int[a.length+1];
        for(int i=0;i<a.length;i++)
        {
            if(a[i]>0)
            {
                pom[j]=a[i];
                j++;
            }
        }
        if (j == 0)
        {
            int[] err = new int[1];
            err[0]=-1; //Not sure how to throw exceptions
            return err;
        }
        pom[j+1] = -1;
        int i = 0;
        int[] pos = new int[j];
        while(pom[i] > 0)
        {
            pos[i]=pom[i];
            i++;
        }
        return pos;
    }
    private static int[] initialise(int n)
    {
        int[] a = new int[n];
        for(int i=0;i<n;i++)
            a[i] = (i-2)*2;
        return a;
    }
    public static void main(String[] args)
    {
        int[] a = initialise(10); a[7]=-5;
        int[] prefSum = cumSum(a);
        int[] pos = positives(a);
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println("\nSum is " + sum(a, 0) + ".\n Here are the prefix sums:");
        for (int i = 0; i < prefSum.length; i++)
            System.out.print(prefSum[i] + " ");
        System.out.println(" \nand all the positive numbers:");
        for (int i = 0; i < pos.length; i++)
            System.out.print(pos[i] + " ");
    }
}