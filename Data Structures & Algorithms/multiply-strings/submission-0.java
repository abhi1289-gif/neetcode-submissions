class Solution {

    public String zeros(int n){
        String ans = "";
        while(n > 0){
            ans += '0';
            n--;
        }
        return ans;
    }
    
    public String add(String a, String b){
        if(a.isEmpty()) return b;
        else if(b.isEmpty()) return a;

        int carry = 0;

        int n = a.length();
        int m = b.length();

        int i = n-1;
        int j = m-1;

        String ans = "";

        while(i >= 0 && j >= 0){
            int sum = (a.charAt(i) -'0') + (b.charAt(j) - '0') + carry;
            int dig = sum%10;
            carry = sum/10;
            ans = (char)(dig + '0') + ans;
            i--;
            j--;
        }

        while(i >= 0){
            int sum = (a.charAt(i) -'0') + carry;
            int dig = sum%10;
            carry = sum/10;
            ans = (char)(dig + '0') + ans;
            i--;
        }
        while(j >= 0){
            int sum = (b.charAt(j) -'0') + carry;
            int dig = sum%10;
            carry = sum/10;
            ans = (char)(dig + '0') + ans;
            j--;
        }

        if(carry != 0){
            ans = '1' + ans;
        }

        return ans;
    }

    public String product(String a, char b){
        int carry = 0;

        int i = a.length()-1;
        String ans = "";

        while(i >= 0){
            int mp = (a.charAt(i) - '0')*(b - '0') + carry;
            int dig = mp%10;
            carry = mp/10;
            ans = (char)(dig + '0') + ans;
            i--;
        }

        if(carry != 0) ans = (char)(carry + '0') + ans;

        return ans;
    }

    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int i = num2.length()-1;
        String ans = "";

        int z = 0;
        
        while(i >= 0){
            String temp = product(num1, num2.charAt(i));
            temp = temp + zeros(z++);
            ans = add(ans, temp);
            i--;
        }
        return ans;
    }
}