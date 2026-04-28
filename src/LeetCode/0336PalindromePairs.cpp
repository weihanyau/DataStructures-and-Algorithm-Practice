using namespace std;

#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>

class Solution {
   public:
    bool isPalin(const string& s, int l, int r) {
        while (l < r) {
            if (s[l++] != s[r--]) return false;
        }
        return true;
    }

   public:
    vector<vector<int>> palindromePairs(vector<string>& words) {
        vector<vector<int>> result;

        unordered_map<string, vector<int>> lookupMap;

        for (int i = 0; i < words.size(); i++) {
            lookupMap[words[i]].push_back(i);
        }

        for (int curr = 0; curr < words.size(); curr++) {
            string& word = words[curr];
            string reversedWord(word.rbegin(), word.rend());

            if (word == "" || isPalin(word, 0, word.size() - 1)) {
                for (int lookupIndex : lookupMap[""]) {
                    if (lookupIndex == curr) continue;
                    result.push_back({lookupIndex, curr});
                    result.push_back({curr, lookupIndex});
                }
            }

            if (word == "") continue;

            for (int i = 0; i < word.size() - 1; i++) {
                if (isPalin(word, 0, i)) {
                    string reversedCut = reversedWord.substr(0, word.size() - i - 1);
                    vector<int> lookupIndexs = lookupMap[reversedCut];
                    for (int lookupIndex : lookupIndexs) {
                        if (lookupIndex == curr) continue;
                        result.push_back({lookupIndex, curr});
                    }
                }
            }

            for (int i = 0; i < word.size() - 1; i++) {
                if (isPalin(word, word.size() - 1 - i, word.size() - 1)) {
                    string reversedCut = reversedWord.substr(i + 1);
                    vector<int> lookupIndexs = lookupMap[reversedCut];
                    for (int lookupIndex : lookupIndexs) {
                        if (lookupIndex == curr) continue;
                        result.push_back({curr, lookupIndex});
                    }
                }
            }

            for (int lookupIndex : lookupMap[reversedWord]) {
                if (lookupIndex == curr) continue;
                result.push_back({curr, lookupIndex});
            }
        }

        // cout << "firstMap" << endl;
        // for (const auto& [key, value] : firstMap) {
        //     cout << key << " | ";
        //     for (const int& v : value) {
        //         cout << v;
        //     }
        //     cout << endl;
        // }

        // cout << "secondMap" << endl;
        // for (const auto& [key, value] : secondMap) {
        //     cout << key << " | ";
        //     for (const int& v : value) {
        //         cout << v;
        //     }
        //     cout << endl;
        // }

        // cout << "result" << endl;
        // cout << "[";
        // for (vector<int>& r : result) {
        //     cout << "[";
        //     for (int& index : r) {
        //         cout << index << ",";
        //     }
        //     cout << "]";
        // }
        // cout << "]" << endl;

        return result;
    }
};

int main() {
    Solution test;
    vector<string> words = {"abcd", "dcba", "lls", "s", "sssll"};
    test.palindromePairs(words);

    // vector<string> words1 = {"bat", "tab", "cat"};
    // test.palindromePairs(words1);

    // vector<string> words2 = {"a", ""};
    // test.palindromePairs(words2);

    // vector<string> words3 = {"abaabaa", "aaba"};
    // test.palindromePairs(words3);

    // vector<string> words4 = {"abab", "b"};
    // test.palindromePairs(words4);

    // vector<string> words5 = {"baab", "baa"};
    // test.palindromePairs(words5);
    return 0;
}