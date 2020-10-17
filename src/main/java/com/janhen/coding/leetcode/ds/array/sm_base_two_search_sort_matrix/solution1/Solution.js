const twoSum = function (nums, target) {
    const valIdxMap = new Map();
    for (let i = 0; i < nums.length; i ++) {
        const key = target - nums[i];
        if (valIdxMap.has(key)) {
            return [valIdxMap.get(key), i];
        }
        valIdxMap.set(nums[i], i);
    }
};