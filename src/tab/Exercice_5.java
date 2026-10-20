package tab;

public class Exercice_5 {
	 public static boolean estPermutationCirculaire(int[] t) {

	        // Tableau null ou vide
	        if (t == null || t.length == 0) {
	            return false;
	        }

	        int n = t.length;

	        // Tableau pour détecter les doublons
	        boolean[] vu = new boolean[n + 1];

	        // 1. Vérifier que t est une permutation de 1 à n
	        for (int i = 0; i < n; i++) {

	            int x = t[i];

	            // Valeur hors de [1, n]
	            if (x < 1 || x > n) {
	                return false;
	            }

	            // Doublon
	            if (vu[x]) {
	                return false;
	            }

	            vu[x] = true;
	        }

	        // 2. Trouver la position de 1
	        int pos = -1;

	        for (int i = 0; i < n; i++) {

	            if (t[i] == 1) {
	                pos = i;
	                break;
	            }
	        }

	        // Normalement impossible si la permutation est valide
	        if (pos == -1) {
	            return false;
	        }

	        // 3. Vérifier l'ordre circulaire
	        for (int k = 0; k < n; k++) {

	            int idx = (pos + k) % n;

	            int valeurAttendue = k + 1;

	            if (t[idx] != valeurAttendue) {
	                return false;
	            }
	        }

	        return true;
	    }

	    public static void main(String[] args) {

	        int[][] tests = {
	            {1},
	            {1, 2, 3, 4, 5},
	            {2, 3, 4, 5, 1},
	            {3, 4, 5, 1, 2},
	            {4, 5, 1, 2, 3},
	            {5, 1, 2, 3, 4},
	            {3, 1, 2, 4, 5},
	            {2, 1, 3, 4, 5},
	            {4, 1, 2, 3, 5},
	            {0, 1, 2, 3, 4},
	            {1, 2, 2, 3, 4},
	            {1, 2, 3, 4, 6}
	        };

	        for (int i = 0; i < tests.length; i++) {

	            System.out.print("Test " + (i + 1) + " : ");

	            for (int x : tests[i]) {
	                System.out.print(x + " ");
	            }

	            System.out.println();

	            if (estPermutationCirculaire(tests[i])) {
	                System.out.println("Résultat : true");
	            } else {
	                System.out.println("Résultat : false");
	            }

	            System.out.println();
	        }
	    
	}
}
