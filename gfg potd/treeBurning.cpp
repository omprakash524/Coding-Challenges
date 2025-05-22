#include <bits/stdc++.h>
using namespace std;

class Node {
    public:
      int data;
      Node *left;
      Node *right;
  
      Node(int val) {
          data = val;
          left = right = NULL;
      }
  };

class TreeNode{
    public:
    int data;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int val){
        data = val;
        left = right = NULL;
    }
};
class Solution{
protected:
    void buildGraph(Node *root, Node *parent, unordered_map<int, vector<int>> &graph){
        if (!root)
            return;
        if (parent)
        {
            graph[root->data].push_back(parent->data);
            graph[parent->data].push_back(root->data);
        }
        buildGraph(root->left, root, graph);
        buildGraph(root->right, root, graph);
    }

private:
    unordered_map<int, vector<int>> convertTreeToGraph(Node *root, unordered_map<int, vector<int>> &graph){
        buildGraph(root, nullptr, graph);
        return graph;
    }

public:
    int minTime(Node *root, int target)
    {
        // code here
        unordered_map<int, vector<int>> graph;
        convertTreeToGraph(root, graph);
        unordered_set<int> vis;
        queue<int> q;
        q.push(target);
        vis.insert(target);
        int min = -1;
        while (!q.empty())
        {
            int size = q.size();
            min++;
            for (int i = 0; i < size; i++)
            {
                int temp = q.front();
                q.pop();
                for (auto &it : graph[temp])
                {
                    if (!vis.count(it))
                    {
                        vis.insert(it);
                        q.push(it);
                    }
                }
            }
        }
        return min;
    }
};
class Solution {
  public:
    int minTime(Node* root) {
        // Your code here
        
    }
};
