using namespace std;

#include <vector>

class Solution {
   public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int l = 0;
        int r = numbers.size() - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum > target) {
                r--;
                continue;
            }

            if (sum < target) {
                l++;
                continue;
            }

            break;
        }

        return {l + 1, r + 1};
    }
};