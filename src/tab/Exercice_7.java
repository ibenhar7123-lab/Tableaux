package tab;

public class Exercice_7 {
    public static int elementMajoritaire(int[] t) {

        // Cas tableau vide
        if (t.length == 0) {
            return -1;
        }

        // 1ère étape : trouver le candidat
        int candidat = 0;
        int compteur = 0;

        for (int x : t) {

            if (compteur == 0) {
                candidat = x;
                compteur = 1;
            }
            else if (x == candidat) {
                compteur++;
            }
            else {
                compteur--;
            }
        }

        // 2ème étape : vérifier le candidat
        int occurrences = 0;

        for (int x : t) {
            if (x == candidat) {
                occurrences++;
            }
        }

        // Vérification : strictement plus que n/2
        if (occurrences > t.length / 2) {
            return candidat;
        }

        return -1;
    }


    public static void main(String[] args) {

        int[][] tests = {
            {3, 3, 4, 3, 5},
            {2, 2, 1, 2, 3, 2, 2},
            {1, 1, 1, 1},
            {7},
            {1, 2, 3, 4},
            {1, 2, 2, 3},
            {1, 1, 2, 2},
            {-1, -1, -1, 2, 3},
            {-2, -2, -2, -2, 1, 3},
            {},
            {10}
        };

        for (int i = 0; i < tests.length; i++) {

            System.out.print("Test " + (i + 1) + " : [");

            for (int j = 0; j < tests[i].length; j++) {
                System.out.print(tests[i][j]);

                if (j < tests[i].length - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println("]");

            int resultat = elementMajoritaire(tests[i]);

            System.out.println("Element majoritaire = " + resultat);
            System.out.println();
        }
    
}
}
