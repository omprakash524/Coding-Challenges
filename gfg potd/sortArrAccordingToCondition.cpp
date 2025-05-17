#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution{
public:
    vector<int> sortArray(vector<int> &arr, int A, int B, int C)
    {
        // code here
        vector<int> tempArr;
        for (int i = 0; i < arr.size(); i++)
        {
            int num = arr[i];
            int temp = (A * (num * num)) + (B * num) + C;
            tempArr.emplace_back(temp);
        }
        sort(tempArr.begin(), tempArr.end());
        return tempArr;
    }
};

//{ Driver Code Starts.
int main()
{
    int t;
    cin >> t;
    cin.ignore();
    while (t--)
    {
        vector<int> arr;
        string input;

        getline(cin, input);

        stringstream ss(input);
        int number;
        while (ss >> number)
        {
            arr.push_back(number);
        }

        int a, b, c;
        cin >> a >> b >> c;
        cin.ignore();

        Solution obj;
        vector<int> ans = obj.sortArray(arr, a, b, c);
        for (int i = 0; i < ans.size(); i++)
            cout << ans[i] << ' ';
        cout << endl;

        cout << "~" << endl;
    }
    return 0;
}