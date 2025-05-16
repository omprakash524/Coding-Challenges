#include<bits/stdc++.h>
using namespace std;

class Solution{
public:
    int lengthOfLongestSubstring(string s){
        int left = 0, maxLen = 0;
        set<char> seen;
        for (int right = 0; right < s.size(); right++){
            while (seen.find(s[right]) != seen.end()){
                seen.erase(s[left++]);
            }
            seen.insert(s[right]);
            maxLen = max(maxLen, right - left + 1);
        }
        return maxLen;
    }
};
int main(){
    Solution sol;
    cout << sol.lengthOfLongestSubstring("abcabcbb") << endl;
    return 0;
}