/**
 * @param {number[]} A
 * @param {number[]} B
 * @return {number}
 */
var findMedianSortedArrays = function (A, B) {
    let len = A.length + B.length;
    let num1 = findKth(A, 0, B, 0, Math.floor((len + 1) / 2));
    let num2 = findKth(A, 0, B, 0, Math.floor((len + 2) / 2));
    return (num1 + num2) / 2.0;
};

/**
 * @param {number[]} A
 * @param {number} aL
 * @param {number[]} B
 * @param {number} bL
 * @param {number} k
 * @return {number}
 */
function findKth(A, aL, B, bL, k) {
    if (aL >= A.length)
        return B[bL + k - 1];
    if (bL >= B.length)
        return A[aL + k - 1];
    if (k == 1)
        return Math.min(A[aL], B[bL]);

    // TODO 浮点数精度问题
    let pivot1 = aL + k / 2 - 1 < A.length ? A[aL + k/ 2 - 1] : Number.MAX_SAFE_INTEGER;
    let pivot2 = bL + k / 2 - 1 < B.length ? B[bL + k/ 2 - 1] : Number.MAX_SAFE_INTEGER;
    if (pivot1 <= pivot2)
        return findKth(A, aL + k/2, B, bL, k - k/2);
    else
        return findKth(A, aL, B, bL + k/2, k - k /2 );
}