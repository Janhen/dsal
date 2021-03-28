/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
    if (intervals.length < 2)
        return intervals;
    const ret = [];

    ret.sort((a, b) => a[0] - b[0]);
    let start = intervals[0][0];
    let end = intervals[0][1];

    for (let i = 0; i < intervals.length; i ++) {
        let [curStart, curEnd] = intervals[i];
        console.log(curStart + ' ' + curEnd);
        if (curStart <= end) {
            end = Math.max(end, curEnd);
        } else {
            ret.push([start, end]);
            start = curStart;
            end = curEnd;
        }
    }
    ret.push([start, end]);
    return ret;
};