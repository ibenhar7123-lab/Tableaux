package tab;

public class Exercice_10 {
    public static boolean estCarreMagique(int[][] m) {

        // Somme de référence : première ligne
        int ref = m[0][0] + m[0][1] + m[0][2];

        // Vérifier les lignes
        for (int i = 0; i < 3; i++) {

            int somme = 0;

            for (int j = 0; j < 3; j++) {
                somme += m[i][j];
            }

            if (somme != ref) {
                return false;
            }
        }

        // Vérifier les colonnes
        for (int j = 0; j < 3; j++) {

            int somme = 0;

            for (int i = 0; i < 3; i++) {
                somme += m[i][j];
            }

            if (somme != ref) {
                return false;
            }
        }

        // Diagonale principale
        int diagonalePrincipale = m[0][0] + m[1][1] + m[2][2];

        if (diagonalePrincipale != ref) {
            return false;
        }

        // Diagonale secondaire
        int diagonaleSecondaire = m[0][2] + m[1][1] + m[2][0];

        if (diagonaleSecondaire != ref) {
            return false;
        }

        return true;
    }


    public static void afficherMatrice(int[][] m) {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                System.out.print(m[i][j] + "\t");
            }

            System.out.println();
        }
    }


    public static void main(String[] args) {

        int[][] m1 = {
            {8, 1, 6},
            {3, 5, 7},
            {4, 9, 2}
        };

        int[][] m2 = {
            {2, 7, 6},
            {9, 5, 1},
            {4, 3, 7}
        };

        int[][] m3 = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };

        int[][] m4 = {
            {-1, 2, 0},
            {2, 0, -2},
            {0, -2, 1}
        };

        int[][] m5 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };


        System.out.println("===== TEST 1 =====");
        afficherMatrice(m1);

        if (estCarreMagique(m1)) {
            System.out.println("Carre magique");
        } else {
            System.out.println("Pas un carre magique");
        }

        System.out.println();


        System.out.println("===== TEST 2 =====");
        afficherMatrice(m2);

        if (estCarreMagique(m2)) {
            System.out.println("Carre magique");
        } else {
            System.out.println("Pas un carre magique");
        }

        System.out.println();


        System.out.println("===== TEST 3 =====");
        afficherMatrice(m3);

        if (estCarreMagique(m3)) {
            System.out.println("Carre magique");
        } else {
            System.out.println("Pas un carre magique");
        }

        System.out.println();


        System.out.println("===== TEST 4 =====");
        afficherMatrice(m4);

        if (estCarreMagique(m4)) {
            System.out.println("Carre magique");
        } else {
            System.out.println("Pas un carre magique");
        }

        System.out.println();


        System.out.println("===== TEST 5 =====");
        afficherMatrice(m5);

        if (estCarreMagique(m5)) {
            System.out.println("Carre magique");
        } else {
            System.out.println("Pas un carre magique");
        
    }
}
}
