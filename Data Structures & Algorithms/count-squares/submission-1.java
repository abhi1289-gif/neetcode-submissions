class CountSquares {

    public class Pair{
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    HashMap<Integer, List<Pair>> rows = new HashMap<>();
    HashMap<Integer, List<Pair>> cols = new HashMap<>();

    public CountSquares() {
        rows.clear();
        cols.clear();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        if(rows.containsKey(x)){
            rows.get(x).add(new Pair(x, y));
        }
        else{
            rows.put(x, new ArrayList<>());
            rows.get(x).add(new Pair(x, y));
        }

        if(cols.containsKey(y)){
            cols.get(y).add(new Pair(x, y));
        }
        else{
            cols.put(y, new ArrayList<>());
            cols.get(y).add(new Pair(x, y));
        }
    }
    
    public int count(int[] point) {
        int ans = 0;
        int x = point[0];
        int y = point[1];

        if(!rows.containsKey(x) || !cols.containsKey(y)) return 0;

        for(var p: rows.get(x)){
            if(p.y == y) continue;

            int dist = Math.abs(y - p.y);

            for(var q: cols.get(y)){

                if(dist == Math.abs(x - q.x)){
                    int i = q.x;
                    int j = p.y;

                    if(!rows.containsKey(i)) continue;

                    for(var r: rows.get(i)){
                        if(r.x == i && r.y == j){
                            ans++;
                            continue;
                        }
                    }
                }
            }
        }

        return ans;
    }
}
