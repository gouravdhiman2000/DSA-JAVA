import java.util.PriorityQueue;
public class weakestSoldier {
    static class Row{
        int soldiers;
        int idx;
        public Row(int soldiers, int idx){
            this.soldiers = soldiers;
            this.idx = idx;
        }
        // @Override
        // public int compareTo(Row r2) {
        //     if (this.soldiers == r2.soldiers) {
        //         return this.idx - r2.idx;
        //     }
        //     return this.soldiers - r2.soldiers;
        // }
    }
    public static void main(String[] args) {
        int army[][] ={{1,0,0,0},
                       {1,1,1,1},
                        {1,0,0,0},
                        {1,0,0,0}};
        
        int k = 2;
        PriorityQueue<Row> pq = new PriorityQueue<>((r1, r2) -> {
            if (r1.soldiers == r2.soldiers) {
                //soldier count is equal sort on the basis of index
                return Integer.compare(r1.idx, r2.idx);
            }
            //soldier count is differ sort on the basis of soldier's count
            return Integer.compare(r1.soldiers, r2.soldiers);
        });

        for(int i=0; i<army.length; i++){
            int count = 0;
            for(int j=0; j<army[0].length; j++){
                count += army[i][j] == 1 ? 1 : 0;
            }
            pq.offer(new Row(count, i)); //soldier count ,index
        }

        //find k weakest soldier's
        for(int i=0; i<k; i++){
            System.out.println("R" + pq.poll().idx); //R0, R2
        }
    }
}
