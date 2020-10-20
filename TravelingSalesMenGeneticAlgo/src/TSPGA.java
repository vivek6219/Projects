import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TSPGA {

	// Step 1: Create an Initial population of some P chromosomes

	// Step 2: Evaluate the fitness of each chromosome

	// Step 3: Choose P/2 parents from the current population via proportional
	// selection (choose 2)

	// step 4: Randomly select two parents to create offspring using a crossover
	// operator

	// step 5: Apply mutation operators for minor changes in the results

	// step 6: Repeat steps 4 and 5 until all parents are selected and mated

	// step 7: Replace old population of chromosomes with new one

	// step 8: Evaluate the fitness of each chromosome in the new population

	// step 9: Terminate if the number of generations meets some upper bound,
	// otherwise go back to step 3

	// (personal notes)
	// using PMX (Partially mapped crossover)
	// population is a subset of all possible solutions (number of solutions)
	// generation is the amount of times you will run it for

	// chromosome is one of the many solution to the given problem
	// gene is one element position of a chromosome
	// Allele is value a gene takes for a particular chromosome
	// Genotype is population in computation space
	// phenotype is population in the actual reeal world solution space.
	// decoding is a process of transforming a solution from the genotype to the
	// phenotype space
	// encoding is a process of transforming the phenotype to genotype space

	// decoding should be fast since it is carried out repeatedly in a GA during
	// fitness value calculation

	// fitness function is a function which takes the solution as an input and
	// produces the suitability of the solution as the output
	// sometimes the fitness and objective function can be the some

	// Genetic Operators: alter the genetic composition of the offspring thru a
	// crossover, mutation, selection,etc

	// we can simply get the initial population by first using the heuristic value
	// for a couple solutions of the cities
	// need to use Permutation representation for the solution
	public final static int adjacencyMatrix[][] = { { 0, 2, 11, 3, 18, 14, 20, 12, 5 },
			{ 2, 0, 13, 10, 5, 3, 8, 20, 17 }, { 11, 13, 0, 5, 19, 21, 25, 8 }, { 3, 10, 5, 0, 6, 4, 12, 15, 1 },
			{ 18, 5, 19, 6, 0, 12, 6, 9, 7 }, { 14, 3, 21, 4, 12, 0, 19, 7, 4 }, { 20, 8, 2, 12, 6, 19, 0, 21, 13 },
			{ 12, 20, 5, 15, 9, 7, 21, 6 }, { 5, 17, 8, 1, 7, 4, 13, 6, 0 }

	};

	// population is the subset of all possible solutions.
	// in other words, how many solutions do we want to solve for i think?
	// GA is a form of stochastic beam search
	public static int generations = 3;
	public static boolean fitnessFlag = true;
	public static double fitnessVal = 0;
	ArrayList<Integer> first;
	ArrayList<Integer> second;

	int globalFirstSum = 0;
	public final static int POPULATION = 10;

	ArrayList<Integer> listOfHeuristics = new ArrayList<Integer>();
	ArrayList<Integer> bestPath = new ArrayList<Integer>();
	int cities[] = new int[8];
	Random rand = new Random();

	int firstCrossOver[];
	int secondCrossover[];

	public static void main(String[] args) {

		int size = 9;
		TSPGA obj = new TSPGA();
		obj.runGA();

	}


	public void runGA() {

		ArrayList<Integer> duplicateBest = new ArrayList<Integer>();

		initializePopulation();
		int best = fitnessFunction(first, second);
//		for (int i : firstCrossOver)
//			System.out.print(firstCrossOver[i]);
//		for(int i: secondCrossover)
//			System.out.print(secondCrossover[i]);

		ArrayList<Integer> list = bestPath;
		System.out.println("BEST VAL: " + best);
		ArrayList<Integer> mutationList = mutationFunction(list);
		for (int i = 0; i < mutationList.size(); i++) {
			// System.out.println(mutationList.get(i));
		}

		crossOverFunction();


	}

	// choose two random chromosomes
	public void initializePopulation() {

		// using numArr with 1 thru 9 cities cuz im retarded
		// so far what this shit does is that it gets a randomly generated path from
		// each city ONCE.
		// (Personal Notes): idk why i didnt just do this instead of overly complicating
		// it and trying to go through that stupid ass adjacency matrix
		// Now what i will do next, is get the heuristic values of each path that it
		// goes through and pass it to fitness function to calculate how good it is.

		first = new ArrayList<>();
		second = new ArrayList<>();


		int numArr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
		for (int i = 0; i < cities.length; i++) {
			first.add(numArr[i]);
			second.add(numArr[i]);
		}

		Collections.shuffle(first);
		Collections.shuffle(second);
//
//		for (int i : second) {
//			System.out.println(i);

	}

	// i will need to rechange the array back to 1 thru 9 instead of 0 thru 8 once i
	// figure how to actually properly do this shit smh
	// numArr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	// this is the same as 1 to 2. 2 to 3. and so on
	// can be represented as adjacencyMatrix[1][2], adjacencyMatrix[2][3]

//fitness function is just going to calculate the value of the paths
//this runs x amount of times according to the population which can be changed and will keep running until a better solution is returned
	public int fitnessFunction(ArrayList<Integer> first, ArrayList<Integer> second) {

		int index = 0;
		int firstSum = 0;
		int secondSum = 0;
		int j = 1;
		int i = 0;
		int k = 0;
		int z = 1;
		int population = POPULATION;

		do {

			// first chromosome
			while (j < first.size()) {
				firstSum += adjacencyMatrix[first.get(i)][first.get(j)];
				// System.out.println(firstSum);

				i++;
				j++;
			}
			// System.out.println("first sum " + firstSum);

			// next chromosome
			while (z < second.size()) {
				secondSum += adjacencyMatrix[second.get(k)][second.get(z)];
				// System.out.println(secondSum);

				k++;
				z++;
			}

			if (firstSum < secondSum) {
				listOfHeuristics.add(firstSum);
				//System.out.println(listOfHeuristics.get(index));

			} else {
				listOfHeuristics.add(secondSum);
				//System.out.println(listOfHeuristics.get(index));

			}
			index++;
			population--;

			initializePopulation();

		} while (population != 0);

		if (population == 0) {
			if (firstSum < secondSum)
				bestPath = first;
			else
				bestPath = second;

		}
		int minimumHeuristic = listOfHeuristics.get(0);



		return minimumHeuristic;


	}


	// crossover using PMX
	public ArrayList<Integer> crossOverFunction() {
		int boundary = first.size() - 1;
		int firstCut = rand.nextInt(boundary);
		int secondCut = rand.nextInt(boundary);
		while (firstCut == secondCut) {
			firstCut = rand.nextInt(boundary);
		}
		if (firstCut > secondCut) {
			int temp = firstCut;
			firstCut = secondCut;
			secondCut = temp;
		}

		int capacity = (secondCut - firstCut) + 1;
		firstCrossOver = new int[capacity];
		secondCrossover = new int[capacity];

		int crossOverIndex = 0;
		for (int i = 0; i < first.size(); i++) {
			if ((i >= firstCut) && i <= secondCut) {
				int a = first.get(i);
				int b = second.get(i);
				firstCrossOver[crossOverIndex] = a;
				secondCrossover[crossOverIndex] = b;
				crossOverIndex++;
			}
		}

		// swap random parts of the two arrays ( chromosomes) in order to mutate
		// we will choose 2 from the last generation in order to assure quality. The
		// smaller the number is from each generation the closer we are to getting the
		// least cost


	}

	// change the best chromsome randomly to achieve genetic diversity
	public ArrayList<Integer> mutationFunction(ArrayList<Integer> heuristicDupes) {

		int firstIndex = rand.nextInt(9);
		int secondIndex = rand.nextInt(9);

		while (firstIndex == secondIndex) {
			firstIndex = rand.nextInt(9);
		}

		if (firstIndex > secondIndex) {
			for (int i = firstIndex; i < secondIndex; i++) {
				int index = rand.nextInt(i);

				int a = heuristicDupes.get(index);
				heuristicDupes.set(index, heuristicDupes.get(i));
				heuristicDupes.set(i, a);

			}
		} else {
			for (int i = secondIndex; i < firstIndex; i++) {
				int index = rand.nextInt(i);

				int a = heuristicDupes.get(index);
				heuristicDupes.set(index, heuristicDupes.get(i));
				heuristicDupes.set(i, a);
		}
	}

		return heuristicDupes;
	}

	@Override
	public String toString() {

		return java.util.Arrays.toString(cities);

	}
}

