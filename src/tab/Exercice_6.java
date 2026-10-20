package tab;

public class Exercice_6 {
	  public static int maxSubarraySum(int[] t) {

	        if (t == null || t.length == 0) {
	            return 0;
	        }

	        int currentSum = t[0];
	        int maxSum = t[0];

	        for (int i = 1; i < t.length; i++) {

	            currentSum = Math.max(t[i], currentSum + t[i]);

	            maxSum = Math.max(maxSum, currentSum);
	        }

	        return maxSum;
	    }

	    /**
	     * Affiche la somme maximale et la sous-suite correspondante.
	     */
	    public static void afficherMaxSubarray(int[] t) {

	        if (t == null || t.length == 0) {
	            System.out.println("Tableau vide");
	            return;
	        }

	        int currentSum = t[0];
	        int maxSum = t[0];

	        int start = 0;
	        int bestStart = 0;
	        int bestEnd = 0;

	        for (int i = 1; i < t.length; i++) {

	            // On commence une nouvelle sous-suite
	            if (t[i] > currentSum + t[i]) {
	                currentSum = t[i];
	                start = i;
	            } else {
	                currentSum += t[i];
	            }

	            // Nouveau maximum
	            if (currentSum > maxSum) {
	                maxSum = currentSum;
	                bestStart = start;
	                bestEnd = i;
	            }
	        }

	        System.out.println("Somme maximale : " + maxSum);

	        System.out.print("Sous-suite : ");

	        for (int i = bestStart; i <= bestEnd; i++) {
	            System.out.print(t[i] + " ");
	        }

	        System.out.println();
	        System.out.println("Indices : " + bestStart + " à " + bestEnd);
	    }

	    public static void main(String[] args) {

	        int[][] tests = {
	            {-2, 1, -3, 4, -1, 2, 1, -5, 4},
	            {1, 2, 3, 4},
	            {-1, -2, -3},
	            {5},
	            {-7},
	            {-2, -1, 3, 4, -5},
	            {1, -1, 1, -1, 1}
	        };

	        for (int i = 0; i < tests.length; i++) {

	            System.out.print("Test " + (i + 1) + " : ");

	            for (int x : tests[i]) {
	                System.out.print(x + " ");
	            }

	            System.out.println();

	            System.out.println(
	                "Max = " + maxSubarraySum(tests[i])
	            );

	            afficherMaxSubarray(tests[i]);

	            System.out.println();
	        }
	    
	}
}
