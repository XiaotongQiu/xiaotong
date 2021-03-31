//Koko loves to eat bananas. There are n piles of bananas, the ith pile has pile
//s[i] bananas. The guards have gone and will come back in h hours. 
//
// Koko can decide her bananas-per-hour eating speed of k. Each hour, she choose
//s some pile of bananas and eats k bananas from that pile. If the pile has less t
//han k bananas, she eats all of them instead and will not eat any more bananas du
//ring this hour. 
//
// Koko likes to eat slowly but still wants to finish eating all the bananas bef
//ore the guards return. 
//
// Return the minimum integer k such that she can eat all the bananas within h h
//ours. 
//
// 
// Example 1: 
//
// 
//Input: piles = [3,6,7,11], h = 8
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: piles = [30,11,23,4,20], h = 5
//Output: 30
// 
//
// Example 3: 
//
// 
//Input: piles = [30,11,23,4,20], h = 6
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= piles.length <= 104 
// piles.length <= h <= 109 
// 1 <= piles[i] <= 109 
// 
// Related Topics 二分查找 
// 👍 159 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 0;
        int r = getMaxPile(piles) + 1;
        while (l < r) {
            mid = (r - l) / 2 + l;
            if (canFinish(piles, h, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;

    }

    public boolean canFinish(int[] piles, int h, int speed) {
        int t = 0;
        for (int p : piles) {
            t += timeCost(p, speed);
            if (t > h) {
                return false;
            }
        }
å
        return true;
    }

    public int timeCost(int pile, int speed) {
        return pile / speed + ((pile % speed) > 0 ? 1 : 0);
    }

    public int getMaxPile(int[] piles) {
        int max = -1;
        for (int p: piles) {
            if (p > max) {
                max = p;
            }
        }

        return max;
    }
}


//leetcode submit region end(Prohibit modification and deletion)
