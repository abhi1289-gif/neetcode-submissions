class Twitter {

    public class Pair{
        int id;
        int twit;

        Pair(int id, int twit){
            this.id = id;
            this.twit = twit;
        }
    }

    HashMap<Integer, HashSet<Integer>> mapp = new HashMap<>();
    Stack<Pair> st = new Stack<>();

    public Twitter(){
        st.clear();
    }
    
    public void postTweet(int userId, int tweetId) {
        st.push(new Pair(userId, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Stack<Pair> nt = new Stack<>();
        List<Integer> ans = new ArrayList<>();

        HashSet<Integer> hs = mapp.getOrDefault(userId, new HashSet<>());

        while(st.size() > 0){
            Pair temp = st.pop();
            if((temp.id == userId || hs.contains(temp.id)) && ans.size() < 10) ans.add(temp.twit);
            nt.push(temp);
        }

        while(nt.size() > 0){
            Pair temp = nt.pop();
            st.push(temp);
        }

        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        mapp.putIfAbsent(followerId, new HashSet<>());
        mapp.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(mapp.containsKey(followerId)){
            mapp.get(followerId).remove(followeeId);
        }
    }
}

