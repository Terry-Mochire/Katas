//in a town there are N people labelled from 1 to N. There is a rumor that one of these people is secretly the town judge.
// if the town judge exists, then:
// 1. the town judge trusts nobody.
// 2. everybody (except for the town judge) trusts the town judge.
// 3. there is exactly one person that satisfies properties 1 and 2.
// you are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
// if the town judge exists and can be identified, return the label of the town judge. otherwise, return -1.

public class FindJudge {

    int N = 4;
    int[][] trust = {{1,3},{1,4},{2,3},{2,4},{4,3}};
    public static void main(String[] args) {
        FindJudge findJudge = new FindJudge();
        System.out.println(findJudge.findJudge(findJudge.N, findJudge.trust));
    }

    private int findJudge(int N, int[][] trust) {
        int[] trustCount = new int[N+1];
        for(int[] t : trust){
            trustCount[t[0]]--;
            trustCount[t[1]]++;
        }
        for(int i = 1; i <= N; i++){
            if(trustCount[i] == N-1){
                return i;
            }
        }
        return -1;
    }
}
