using namespace std;

#include <vector>
#include <string>
#include <unordered_map>

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, int> map;
        vector<vector<string>> result;
        for(string& str: strs){
            vector<int> arr(26, 0);
            for(char c: str){
                arr[c - 'a']++;
            }
            string key(arr.begin(), arr.end());
            if(map.find(key) == map.end()){
                map[key] = map.size();
                result.push_back({str});
                continue;
            }

            result[map.at(key)].push_back(str);
        }
        return result;
    }
};