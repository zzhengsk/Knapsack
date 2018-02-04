// This alg. solve the Knapsack problem with brute force(n-tuple enumeration)
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class Ntuple {
	public static void main(String[] args) throws FileNotFoundException	{
		int size = Integer.parseInt(args[0]);
		int[] copies = new int[size];
		int[] values = new int[size];
		int[] weights = new int[size];
		Scanner s1 = new Scanner(new File(args[1]));
		Scanner	s2 = new Scanner(new File(args[2]));
		Scanner	s3 = new Scanner(new File(args[3]));
		int j = 0;
		while(s1.hasNext()){
			copies[j] = s1.nextInt();
			values[j] = s2.nextInt();
			weights[j++] = s3.nextInt();
		}
		s1.close();
		s2.close();
		s3.close();


		int totalV = 0;
		double maxW = 0;
		int maxV = 0;
		int temp = 0;
		int[] chosen = new int[size];
		int[] output = new int[size];
		for(int i = 0; i < size; i++)
		{
			totalV += copies[i]*values[i];
			System.out.println(copies[i] + " " + values[i] + " " + weights[i]);
		}
		maxW = totalV/2.0;
		 System.out.println("maxW~~~~" + maxW);
		while(true){
			temp = 0;
			if((chosen = addOne(copies, chosen)) == null)
				break;
			/*
			for(int i = 0; i < size; i++)
				System.out.print(chosen[i]);
			System.out.println();
			*/
			for(int i = 0; i < size; i++)
				temp += weights[i] * chosen[i];
			if(temp > maxW) // see if it is overweight
				continue;
			else{
				for(int i = 0; i < size; i++)
					temp += values[i] * chosen[i];
				// see if value is max
				if(temp > maxV){
					maxV = temp;
					for(int i = 0; i < size; i++)
						output[i] = chosen[i];
				}
			}
		}
		for(int i = 0; i < size; i++)
			System.out.print(output[i] + " ");
		System.out.println();

	}

	private static int[] addOne(int[] A, int[] P){
		for(int i = 0; i < A.length; i++){
			if(P[i] < A[i]){
				P[i]++;
				return P;
			}
			else
				P[i] = 0;
		}
		return null;
	}



}
	/*
	private static void greedy(){
		double[] A = {5, 40, 8, 2};   // All #
		double[] Cho = {0, 0, 0 ,0};
		double[] W = {.3, .2, .4, 3 }; // weight
		double[] P = {1, .3, .5, 2.5}; // price
		double[] Re = new double[4];
		double MaxV = 0;
		double MaxW = 4;
		double temp = 0;
		while(true){
			temp = 0;
			Cho = addOne(A, Cho);
			if(Cho == null)
				break;
			for(int i = 0; i < 4; i++)
				temp += W[i]*Cho[i];
			if(temp > MaxW) // see if it is overweight
				continue;
			else{
				for(int i = 0; i < 4; i++)
					temp += P[i]*Cho[i];
				// see if value is max
				if(temp > MaxV){
					MaxV = temp;
					for(int i = 0; i < 4; i++)
						Re[i] = Cho[i];
				}
			}
		}

		// finally print out the choice
		for(int i = 0; i < 4; i++)
			System.out.println(Re[i]);

	}

	private static double[] addOne(double[] A, double[] P){
		int i;
		for(i = 0; i < 4; i++){
			if(P[i] < A[i]){
				P[i]++;
				return P;
			}
			else
				P[i] = 0;
		}
		return null;
	}
}
*/
