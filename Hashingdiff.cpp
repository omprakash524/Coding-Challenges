#include<bits/stdc++.h>
using namespace std;

int main(){
    unordered_map<char, int> unmap;
    string s = "aaAaa";
    for(char c : s){
        unmap[c]++;
    }
    for(auto it : unmap){
        cout<<it.first<<" : "<<it.second<<endl;
    }
    map<char, int> m;
    for(char c : s){
        m[c]++;
    }
    cout<<endl;
    for(auto it : m){
        cout<<it.first<<" : "<<it.second<<endl;
    }
    

    return 0;
}