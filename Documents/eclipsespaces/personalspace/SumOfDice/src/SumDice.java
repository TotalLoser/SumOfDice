import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
//test
public class SumDice
{
	// hoo hoo
	public static void main(String[] args)
	{
		try
		{
			Scanner in = new Scanner(new File("dice.txt"));
			ArrayList<Integer> dice = new ArrayList<Integer>();
			while(in.hasNext())
				dice.add(Integer.parseInt(in.nextLine()));
			ArrayList<Integer> freqs = new ArrayList<Integer>();
			ArrayList<Integer> arr = sumsOfDice(0, dice);
			for(Object num : arr.toArray())
			{
				if((int)num >= freqs.size())
					addTilSize(freqs, (int)num);
				freqs.set((int)num, freqs.get((int)num) + 1);	
			}
			System.out.println(freqs);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

	}
	private static void addTilSize(ArrayList<Integer> freqs, int num)
	{
		while(freqs.size() <= num)
			freqs.add(0);
	}
	public static ArrayList<Integer> sumsOfDice(int index, ArrayList<Integer> dice)
	{
		ArrayList<Integer> out = new ArrayList<Integer>();
		if(index == dice.size() - 1)
		{
			for(int i = 0; i < dice.get(index); i++)
				out.add(i);
			return out;
		}
		for(int i = 1; i <= dice.get(index); i++)
		{
			for(int num : sumsOfDice(index + 1, dice))
				out.add(i + num);
		}
		return out;
	}
}
