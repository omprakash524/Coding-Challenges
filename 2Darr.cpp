#include<bits/stdc++.h>
using namespace std;

int main(){
    int rows, cols;
    cin >> rows >> cols;
    vector<vector<int>> arr(rows, vector<int>(cols));
    for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){
            cin >> arr[i][j];
        }
    }
    for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){
            cout << arr[i][j] << " ";
        }
        cout << endl;
    }
    int k,n;
    cout<<"Enter the row and column : ";
    cin>>k>>n;
    vector<vector<int>> matrix(k, vector<int>(n));
    for(int i=0; i<k; i++){
        for(int j=0; j<n; j++){
            cin>>matrix[i][j];
        }
    }
    cout<<"The matrix is : "<<endl;
    for(int i=0; i<k; i++){
        for(int j=0; j<n; j++){
            cout<<matrix[i][j]<<" ";
        }
        cout<<endl;
    }
    return 0;
}