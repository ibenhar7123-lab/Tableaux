package tab;
import java.util.ArrayDeque;
import java.util.Deque;

public class Exercice_4 {

	    static class Rectangle {
	        int top = -1;
	        int left = -1;
	        int bottom = -1;
	        int right = -1;
	        int area = 0;

	        @Override
	        public String toString() {
	            if (area == 0) return "Aucun rectangle de 1 (aire = 0)";
	            return "aire=" + area + " | top=" + top + ", left=" + left
	                    + ", bottom=" + bottom + ", right=" + right;
	        }
	    }

	    /** Variante simple : aire maximale seulement. */
	    public static int maxRectangle(int[][] m) {
	        return trouverMaxRectangle(m).area;
	    }

	    /** Variante enrichie : aire + coordonnées. O(R x C). */
	    public static Rectangle trouverMaxRectangle(int[][] m) {
	        Rectangle best = new Rectangle();
	        if (m == null || m.length == 0 || m[0].length == 0) return best;

	        int R = m.length, C = m[0].length;
	        int[] h = new int[C]; // histogramme de la ligne courante

	        for (int i = 0; i < R; i++) {
	            // Étape 1 : mise à jour des hauteurs
	            for (int j = 0; j < C; j++) {
	                h[j] = (m[i][j] == 1) ? h[j] + 1 : 0;
	            }

	            // Étape 2 : plus grand rectangle dans l'histogramme (pile d'indices)
	            Deque<Integer> stack = new ArrayDeque<>();
	            for (int j = 0; j <= C; j++) {
	                int cur = (j == C) ? 0 : h[j]; // sentinelle de hauteur 0 à la fin
	                while (!stack.isEmpty() && cur < h[stack.peek()]) {
	                    int height = h[stack.pop()];
	                    int left = stack.isEmpty() ? 0 : stack.peek() + 1;
	                    int right = j - 1;
	                    int area = height * (right - left + 1);
	                    if (area > best.area) {
	                        best.area = area;
	                        best.left = left;
	                        best.right = right;
	                        best.bottom = i;
	                        best.top = i - height + 1;
	                    }
	                }
	                stack.push(j == C ? 0 : j);
	            }
	        }
	        return best;
	    }

	    public static void main(String[] args) {
	        int[][][] tests = {
	            { {0, 1, 1, 0, 1}, {1, 1, 1, 1, 0}, {1, 1, 1, 1, 0}, {1, 1, 0, 0, 1} }, // 8
	            { {0} },                                                                // 0
	            { {1} },                                                                // 1
	            { {0, 0, 0, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0} },             // 4
	            { {1, 1, 0, 1}, {1, 1, 0, 1}, {0, 0, 1, 1} },                           // 4
	            { {1, 1, 1}, {1, 1, 1}, {1, 1, 1} },                                    // 9
	            { {0, 0, 0}, {0, 0, 0}, {0, 0, 0} }                                     // 0
	        };

	        for (int k = 0; k < tests.length; k++) {
	            System.out.println("Test " + (k + 1) + " : " + trouverMaxRectangle(tests[k]));
	        }
	    }
	}
