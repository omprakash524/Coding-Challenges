/*
class Node {
  public:
    int data;
    Node *left;
    Node *right;

    Node(int x) {
        data = x;
        left = NULL;
        right = NULL;
    }
}; */

class Solution
{
    void preorder(int sum, int len, int &maxLen, int &maxSum, Node *root)
    {
        if (!root)
            return;
        sum += root->data;
        len++;
        if (root->left == NULL && root->right == NULL)
        {
            if (len > maxLen)
            {
                maxLen = len;
                maxSum = sum;
            }
            else if (len == maxLen)
            {
                maxSum = max(sum, maxSum);
            }
            return;
        }
        preorder(sum, len, maxLen, maxSum, root->left);
        preorder(sum, len, maxLen, maxSum, root->right);
    }

public:
    int sumOfLongRootToLeafPath(Node *root)
    {
        // code here
        if (!root)
        {
            return NULL;
        }
        int maxSum = 0;
        int maxLen = 0;
        preorder(0, 0, maxLen, maxSum, root);
        return maxSum;
    }
};