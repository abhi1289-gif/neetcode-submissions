class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int l = 0;
        int r = m-1;
        int t = 0;
        int d = n-1;
        List<Integer> ans = new ArrayList<>();

        while(l<=r && t<=d){

            int a = l;
            while(a<=r){
                ans.add(matrix[t][a]);
                a++;
            }

            a = t+1;
            while(a<=d){
                ans.add(matrix[a][r]);
                a++;
            }

            if(t<d){
                a = r-1;
                while(a>=l){
                    ans.add(matrix[d][a]);
                    a--;
                }
            }

            if(l<r){
                a = d-1;
                while(a>t){
                    ans.add(matrix[a][l]);
                    a--;
                }
            }
            
            l++;
            r--;
            t++;
            d--;
        }

        return ans;
    }
}