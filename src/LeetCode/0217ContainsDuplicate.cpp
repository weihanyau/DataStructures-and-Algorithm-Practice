using namespace std;

#include <vector>
#include <unordered_set>

class Solution
{
public:
    bool containsDuplicate(vector<int> &nums)
    {
        unordered_set<int> currNums;
        for (int num : nums)
        {
            if (currNums.find(num) != currNums.end())
            {
                return true;
            };

            currNums.insert(num);
        };

        return false;
    }
};