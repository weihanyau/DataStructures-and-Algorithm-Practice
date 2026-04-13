using namespace std;

#include <vector>
#include <unordered_map>

class Solution
{
public:
    vector<int> twoSum(vector<int> &nums, int target)
    {
        unordered_map<int, int> map;
        vector<int> result;
        for (int i = 0; i < nums.size(); i++)
        {
            int leftover = target - nums[i];
            if (map.find(leftover) == map.end())
            {
                map[nums[i]] = i;
                continue;
            }

            result.push_back(i);
            result.push_back(map.at(leftover));
            break;
        }

        return result;
    }
};