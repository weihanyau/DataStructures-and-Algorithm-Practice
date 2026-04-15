using namespace std;

#include <vector>
#include <string>

class Solution {
public:

    string encode(vector<string>& strs) {
        string result = "";
        string joinedString = "";

        result.append(to_string(strs.size()));
        result.append(",");

        for(const string& str: strs) {
            result.append(to_string(str.size()));
            result.append(",");
            joinedString.append(str);
        }

        result.append(joinedString);
        return result;
    }

    vector<string> decode(string s) {
        int sizeEnd = s.find_first_of(",");
        int size = stoi(s.substr(0, sizeEnd));
        
        vector<int> wordSizes(size);

        int startPos = sizeEnd + 1;
        for(int i = 0; i < size; i++){
            int endPos = s.find_first_of(",", startPos);
            wordSizes[i] = stoi(s.substr(startPos, endPos - startPos));
            startPos = endPos + 1;
        }

        vector<string> result(size);

        for(int i = 0; i < size; i++){
            result[i] = s.substr(startPos, wordSizes[i]);
            startPos = startPos + wordSizes[i];
        }

        return result;
    }
};


#include <iostream>
void run(vector<string> strs) {
    Solution sol;

    cout << "Input:   [";
    for (int i = 0; i < strs.size(); i++) {
        cout << "\"" << strs[i] << "\"";
        if (i + 1 < strs.size()) cout << ", ";
    }
    cout << "]\n";

    string encoded = sol.encode(strs);
    cout << "Encoded: \"" << encoded << "\"\n";

    vector<string> decoded = sol.decode(encoded);
    cout << "Decoded: [";
    for (int i = 0; i < decoded.size(); i++) {
        cout << "\"" << decoded[i] << "\"";
        if (i + 1 < decoded.size()) cout << ", ";
    }
    cout << "]\n\n";
}

int main() {
    run({"hello", "world"});
    run({"lint", "code", "love", "you"});
    run({""});
    run({});
    return 0;
}
