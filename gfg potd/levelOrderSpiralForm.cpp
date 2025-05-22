class Solution {
    private:
    void bfs(Node* root, vector<int> & ans){
        if(!root) return;
        bool leftToRight = false;
        queue<Node*> q;
        q.push(root);
        while(!q.empty()){
            int size = q.size();
            vector<int> temp(size);
            for(int i=0; i<size; i++){
                Node* node = q.front();
                q.pop();
                int index = leftToRight ? i : (size - 1 - i);
                temp[index] = node->data;

                if(node->left){
                    q.push(node->left);
                }
                if(node->right){
                    q.push(node->right);
                }
            }
            ans.insert(ans.end(), temp.begin(), temp.end());
            leftToRight = !leftToRight;
        }
    }

    protected : void bfs1(Node *root, vector<int> &ans)
    {
        if(!root) return;
        int isEven = 0;
        queue<Node*> q;
        q.push(root);
        while(!q.empty()){
            int size = q.size();
            vector<int> temp;
            for(int i=0; i<size; i++){
                Node* node = q.front();
                q.pop();
                temp.emplace_back(node->data);
                
                if(node->left) q.push(node->left);
                if(node->right) q.push(node->right);
            }
            if(isEven % 2 == 0){
                ans.insert(ans.end(), temp.rbegin(), temp.rend());
            }else{
                ans.insert(ans.end(), temp.begin(), temp.end());
            }
            isEven++;
        }
    }

  public:
    vector<int> findSpiral(Node* root) {
        // code here
        vector<int> ans;
        bfs1(root, ans);
        return ans;
    }
};