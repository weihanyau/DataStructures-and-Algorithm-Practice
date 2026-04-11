using namespace std;

#include <vector>
#include <set>

class Solution
{
public:
    bool containsDuplicate(vector<int> &nums)
    {
        set<int> currNums;
        for (auto &num : nums)
        {
            if (currNums.count(num) == 1)
            {
                return true;
            };

            currNums.insert(num);
        };

        return false;
    }
};