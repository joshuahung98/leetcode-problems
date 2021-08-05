/*
 * There is a row of n houses, where each house can be painted one of three colors: red, blue, or green. The cost of painting each house with a 
 * certain color is different. You have to paint all the houses such that no two adjacent houses have the same color. The cost of painting each house 
 * with a certain color is represented by an n x 3 cost matrix costs. For example, costs[0][0] is the cost of painting house 0 with the color red; 
 * costs[1][2] is the cost of painting house 1 with color green, and so on... Return the minimum cost to paint all houses.
 *
 * notes: at your current index, you have to choose the min cost of whatever was before you, assuming you are taking the current color you are on. 
 * Then, add it into your current index. At the end, find the min of the last indices of all 3 colors. 
 *
 * Runtime: O(n)
 * Space: O(m*n) 
 */
public class Solution {
    public int minCost(int[][] costs) {
        if(costs==null||costs.length==0){
            return 0;
        }
        for(int i=1; i<costs.length; i++){
            costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][1],costs[i-1][0]);
        }
        int n = costs.length-1;
        return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
    }
}