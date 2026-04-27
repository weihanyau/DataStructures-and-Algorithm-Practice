using namespace std;

#include <iostream>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

class Solution {
   public:
    bool isPalin(const string& s, int l, int r) {
        while (l < r) {
            if (s[l++] != s[r--]) return false;
        }
        return true;
    }

    vector<vector<int>> palindromePairs(vector<string>& words) {
        vector<vector<int>> result;

        unordered_map<string, vector<int>> firstMap;
        unordered_map<string, vector<int>> secondMap;
        unordered_set<string> palindromeMap;

        for (int idx = 0; idx < words.size(); idx++) {
            string word = words[idx];
            if (word == "") continue;

            string pair = "";
            for (int j = word.size() - 1; j >= 0; j--) {
                pair += word[j];
                // remaining prefix is word[0..j-1]; add if it's a palindrome
                if (j == 0 || isPalin(word, 0, j - 1)) {
                    firstMap[pair].push_back(idx);
                }
            }

            pair = "";
            for (int j = 0; j < (int)word.size(); j++) {
                pair = word[j] + pair;
                if ((int)pair.size() == (int)word.size()) continue;
                // remaining suffix is word[j+1..end]; add if it's a palindrome
                if (j + 1 == (int)word.size() || isPalin(word, j + 1, word.size() - 1)) {
                    secondMap[pair].push_back(idx);
                }
            }

            bool isPalindrome = true;
            for (int start = 0, end = word.size() - 1; start < end; start++, end--) {
                if (word[start] != word[end]) {
                    isPalindrome = false;
                    break;
                }
            }

            if (isPalindrome) {
                palindromeMap.insert(word);
            }
        }

        for (int i = 0; i < words.size(); i++) {
            string& word = words[i];

            if (word == "") {
                for (int j = 0; j < words.size(); j++) {
                    if (i == j) continue;
                    if (palindromeMap.count(words[j]) == 1) {
                        result.push_back({i, j});
                        result.push_back({j, i});
                    }
                }
                continue;
            }

            if (firstMap.find(word) != firstMap.end()) {
                vector<int> indexArray = firstMap[word];
                for (int index : indexArray) {
                    if (i == index) continue;
                    result.push_back({i, index});
                }
            }

            if (secondMap.find(word) != secondMap.end()) {
                vector<int> indexArray = secondMap[word];
                for (int index : indexArray) {
                    if (i == index) continue;
                    result.push_back({index, i});
                }
            }
        }

        cout << "firstMap" << endl;
        for (const auto& [key, value] : firstMap) {
            cout << key << " | ";
            for (const int& v : value) {
                cout << v;
            }
            cout << endl;
        }

        cout << "secondMap" << endl;
        for (const auto& [key, value] : secondMap) {
            cout << key << " | ";
            for (const int& v : value) {
                cout << v;
            }
            cout << endl;
        }

        cout << "result" << endl;
        cout << "[";
        for (vector<int>& r : result) {
            cout << "[";
            for (int& index : r) {
                cout << index << ",";
            }
            cout << "]";
        }
        cout << "]" << endl;

        return result;
    }
};

int main() {
    Solution test;
    // vector<string> words = {"abcd", "dcba", "lls", "s", "sssll"};
    // test.palindromePairs(words);

    // vector<string> words1 = {"bat", "tab", "cat"};
    // test.palindromePairs(words1);

    // vector<string> words2 = {"a", "abc", "aba", ""};
    // test.palindromePairs(words2);

    vector<string> words3 = {"abaabaa", "aaba"};
    test.palindromePairs(words3);
    return 0;
}