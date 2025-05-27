#include<bits/stdc++.h>
using namespace std;
int main(){
    string s = "6759";
    for(int i=0; i<=s.size(); i++){
        for(int j=0; j<i; j++){
            cout<<s[j]<<" ";
        }
        cout<<endl;
    }
    return 0;
}