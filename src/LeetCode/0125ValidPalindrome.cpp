using namespace std;

#include <string>

class Solution {
   public:
    bool isPalindrome(string s) {
        int i = 0;
        int j = s.size() - 1;
        while (i < j) {
            char head = s[i];
            char tail = s[j];

            if (!(head >= 'A' && head <= 'Z' || head >= 'a' && head <= 'z' || head >= '0' && head <= '9')) {
                i++;
                continue;
            }

            if (!(tail >= 'A' && tail <= 'Z' || tail >= 'a' && tail <= 'z' || tail >= '0' && tail <= '9')) {
                j--;
                continue;
            }

            if (tolower(head) == tolower(tail)) {
                i++;
                j--;
                continue;
            }

            return false;
        }

        return true;
    }
};