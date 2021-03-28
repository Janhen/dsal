class Solution:
    def topKFrequent(nums, k):
        if not nums:
            return []

        if len(nums) == 1:
            return nums[0]

        # first find freq - freq dict
        d = {}
        for num in nums:
            if num in d:
                d[num] -= 1 # reverse the sign on the freq for the heap's sake
            else:
                d[num] = -1

        h = []
        from heapq import heappush, heappop
        for key in d:
            heappush(h, (d[key], key))

        res = []
        count = 0
        while count < k:
            frq, item = heappop(h)
            res.append(item)
            count += 1
        return res