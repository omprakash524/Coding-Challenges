class Solution
{
public:
    int smallestIndex(vector<int> &nums)
    {
        int n = nums.size();
        vector<int> sum;
        for (int i = 0; i < n; i++)
        {
            int temp = nums[i];
            int sumDigit = 0;
            while (temp > 0)
            {
                int ld = temp % 10;
                temp = temp / 10;
                sumDigit += ld;
            }
            if (sumDigit == i)
            {
                sum.emplace_back(i);
            }
        }
        sort(sum.begin(), sum.end());
        if (sum.empty())
        {
            return -1;
        }
        return sum[0];
    }
};