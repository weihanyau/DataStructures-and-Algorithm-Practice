using namespace std;

#include <unordered_map>
#include <vector>

class Solution {
   public:
    int longestConsecutive(vector<int>& nums) {
        unordered_map<int, int> store;
        for (int& num : nums) {
            int prev = num - 1;
            int next = num + 1;

            if (store.find(num) != store.end()) {
                continue;
            }

            if (store.find(prev) != store.end() && store.find(next) != store.end()) {
                store[num] = num;
                if (store[prev] == prev && store[next] == next) {
                    store[prev] = next;
                    store[next] = prev;
                    continue;
                }

                if (store[prev] == prev) {
                    store[prev] = store[next];
                } else {
                    store[store[prev]] = store[next];
                }

                if (store[next] == next) {
                    store[next] = store[prev];
                } else {
                    store[store[next]] = store[prev];
                }
                continue;
            }

            if (store.find(prev) != store.end()) {
                store[num] = store[prev];
                if (store[prev] == prev) {
                    store[prev] = num;
                } else {
                    store[store[prev]] = num;
                }
                continue;
            }

            if (store.find(next) != store.end()) {
                store[num] = store[next];
                if (store[next] == prev) {
                    store[next] = num;
                } else {
                    store[store[next]] = num;
                }
                continue;
            }

            store[num] = num;
        }

        int max = 0;

        for (const auto& [key, value] : store) {
            if ((value - key + 1) > max) {
                max = value - key + 1;
            }
        }

        return max;
    }
};