class Solution:
    def topKFrequent(nums, k):
        def quick_select(left, right):
            pivot = left
            l, r = left, right
            while l < r:
                while l < r and counts[r][1] <= counts[pivot][1]:
                    r -= 1
                while l < r and counts[l][1] >= counts[pivot][1]:
                    l += 1
                counts[l], counts[r] = counts[r], counts[l]
            counts[left], counts[l] = counts[l], counts[left]

            if l + 1 == k:
                return counts[:l+1]
            elif l + 1 < k:
                return quick_select(l + 1, right)
            else:
                return quick_select(left, l - 1)

        if not nums:
            return []

        # Get the counts.
        counts = {}
        for x in nums:
            counts[x] = counts.setdefault(x, 0) + 1

        counts = counts.items()
        # Use quick select to get the top k counts.
        return [c[0] for c in quick_select(0, len(counts) - 1)]