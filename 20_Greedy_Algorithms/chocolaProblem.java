import java.util.*;

public class chocolaProblem {
    public static void main(String[] args) {

        int n = 4, m = 6;

        Integer costVer[] = {2,1,3,1,4};
        Integer costHor[] = {4,1,2};

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0;
        int v = 0;

        int horizontalPieces = 1;
        int verticalPieces = 1;

        int cost = 0;


        while(h < costHor.length && v < costVer.length) {

            if(costVer[v] > costHor[h]) {

                // Vertical cut
                cost += costVer[v] * horizontalPieces;
                verticalPieces++;
                v++;

            } else {

                // Horizontal cut
                cost += costHor[h] * verticalPieces;
                horizontalPieces++;
                h++;
            }
        }


        while(h < costHor.length) {
            cost += costHor[h] * verticalPieces;
            horizontalPieces++;
            h++;
        }


        while(v < costVer.length) {
            cost += costVer[v] * horizontalPieces;
            verticalPieces++;
            v++;
        }


        System.out.println("Minimum cost of cuts is = " + cost);
    }
}