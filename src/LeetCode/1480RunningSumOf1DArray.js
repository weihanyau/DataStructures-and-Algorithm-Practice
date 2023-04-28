/**
 * @param {number[]} nums
 * @return {number[]}
 */
var runningSum = function(nums) {
    let sum = 0;
    nums.forEach((num, idx) => {
      sum += num;
      nums[idx] = sum;
    })
    return nums;
};