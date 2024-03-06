// This program generates a ragged array randomly
import java.util.concurrent.*;

public class drawRaggedArrayDynamically {

    public static void main(String[] args) {

    	// randomly generate a number for the height in the range of 3 and 10
    	int height = ThreadLocalRandom.current().nextInt(3, 11);

    	char[][] table = new char[height][];

    	for(int i=0; i<height; i++)
    	{
			// randomly generate a number for the columns in the range of 3 and 10
			int clnms = ThreadLocalRandom.current().nextInt(3, 11);

    		table[i] = new char[clnms];
    		for (int j = 0; j < clnms; j++)
    		{
    			table[i][j] = '*';
			}

		}

    	for(int i = 0; i < height; i++)
    	{
    		for (int j = 0; j < table[i].length; j++)
    		{
    			System.out.print(table[i][j] + " ");
			}
    		System.out.println();
		}

    }
}