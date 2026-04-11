using namespace std;

#include <string>
#include <array>

class Solution
{
public:
    bool isAnagram(string s, string t)
    {
        array<int, 26> sCount;
        array<int, 26> tCount;

        if(s.length() != t.length()) return false;

        for(int i = 0; i < s.length(); i++){
            sCount[s[i] - 'a']++;
            tCount[t[i] - 'a']++;
        }

        for(int i = 0; i < sCount.size(); i++){
            if(sCount[i] != tCount[i]) return false;
        }

        return true;
    }
};