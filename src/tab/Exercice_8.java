package tab;

public class Exercice_8 {
    public static void afficherElementsManquants(int[] t) {

        int n = t.length;

        // Tableau de marquage
        boolean[] vu = new boolean[n + 1];

        // Marquer les valeurs présentes
        for (int x : t) {
            if (x >= 1 && x <= n) {
                vu[x] = true;
            }
        }

        // Afficher les éléments manquants
        boolean trouve = false;

        System.out.print("Elements manquants : ");

        for (int k = 1; k <= n; k++) {
            if (!vu[k]) {
                System.out.print(k + " ");
                trouve = true;
            }
        }

        if (!trouve) {
            System.out.print("Aucun element manquant");
        }

        System.out.println();
    }


    public static void main(String[] args) {

        int[][] tests = {
            {1, 3, 3, 5},
            {1, 2, 3, 4},
            {3, 3, 3},
            {1, 1, 1, 1},
            {4, 2, 2, 1, 5},
            {1},
            {}
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

            afficherElementsManquants(tests[i]);

            System.out.println();
        }
    }
}
