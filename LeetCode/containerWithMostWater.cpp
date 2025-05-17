// LC - 11

class Solution
{
public:
    int maxArea(vector<int> &height)
    {
        // int n = height.size();
        // int maxx = 0;
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         int h = min(height[i], height[j]);
        //         int w = j - i;
        //         maxx = max(maxx, h * w);
        //     }
        // }
        // return maxx;
        // TC is O(n^2)

        // using two pointers in TC O(n)
        int left = 0, right = height.size() - 1;
        int maxxArea = 0;
        while (left < right)
        {
            int h = min(height[left], height[right]);
            int weight = right - left;
            maxxArea = max(maxxArea, h * weight);
            if (height[left] < height[right])
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        return maxxArea;
    }
};