package tab;

public class Exercice_9 {
	   public static int differenceDiagonales(int[][] m) {

	        int n = m.length;

	        int sommePrincipale = 0;
	        int sommeSecondaire = 0;

	        for (int i = 0; i < n; i++) {

	            // Diagonale principale
	            sommePrincipale += m[i][i];

	            // Diagonale secondaire
	            sommeSecondaire += m[i][n - 1 - i];
	        }

	        int diff = Math.abs(sommePrincipale - sommeSecondaire);

	        System.out.println("Somme diagonale principale : " + sommePrincipale);
	        System.out.println("Somme diagonale secondaire : " + sommeSecondaire);
	        System.out.println("Difference absolue : " + diff);

	        return diff;
	    }


	    public static void afficherMatrice(int[][] m) {

	        for (int i = 0; i < m.length; i++) {

	            for (int j = 0; j < m[i].length; j++) {
	                System.out.print(m[i][j] + "\t");
	            }

	            System.out.println();
	        }
	    }


	    public static void main(String[] args) {

	        int[][] m1 = {
	            {1, 2, 3},
	            {4, 5, 6},
	            {7, 8, 9}
	        };

	        int[][] m2 = {
	            {1, 3, 5},
	            {2, 4, 6},
	            {7, 8, 9}
	        };

	        int[][] m3 = {
	            {5}
	        };

	        int[][] m4 = {
	            {-1, 2},
	            {3, -4}
	        };


	        System.out.println("===== TEST 1 =====");
	        afficherMatrice(m1);
	        differenceDiagonales(m1);

	        System.out.println();


	        System.out.println("===== TEST 2 =====");
	        afficherMatrice(m2);
	        differenceDiagonales(m2);

	        System.out.println();


	        System.out.println("===== TEST 3 =====");
	        afficherMatrice(m3);
	        differenceDiagonales(m3);

	        System.out.println();


	        System.out.println("===== TEST 4 =====");
	        afficherMatrice(m4);
	        differenceDiagonales(m4);
	    }
}
