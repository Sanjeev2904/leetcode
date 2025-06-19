class Solution:
    def maxArea(self, height: List[int]) -> int:
        n = len(height)
        ans = float("-inf")
        left, right = 0, n - 1

        while left < right:
            h = min(height[left], height[right])
            w = right - left
            area = h * w
            ans = max(ans, area)

            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
            
        return ans