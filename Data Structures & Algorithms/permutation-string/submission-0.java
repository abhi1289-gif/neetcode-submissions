class Solution {

    public boolean areSame(char arr[], char brr[]){
        for(int i=0; i<26; i++){
            if(arr[i] != brr[i]) return false;
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if(len1 > len2) return false;

        char arr[] = new char[26];
        char brr[] = new char[26];

        for(int i=0; i<len1; i++){
            arr[(s1.charAt(i)-'a')]++;
        }

        for(int i=0; i<len1; i++){
            brr[(s2.charAt(i) - 'a')]++;
        }

        if(areSame(arr, brr)) return true;
        int a = 0;

        for(int i=len1; i<len2; i++){
            brr[(s2.charAt(i)-'a')]++;
            brr[(s2.charAt(a)-'a')]--;
            a++;
            if(areSame(arr, brr)) return true;
        }

        return false;
    }
}