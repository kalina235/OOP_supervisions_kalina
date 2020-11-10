public class ex5
{
    public static int[][] create(int n)
    {
        int[][] a = new int[n][n];
        return a;
    }
    public static void main(String[] args)
    {
        int[][] a = create(11);
        for(int i=0;i<a.length;i++)
        {
            for (int j = 0; j < a[0].length; j++)
                System.out.print(a[i][j]+ " ");
            System.out.println();
        }
    }
}
