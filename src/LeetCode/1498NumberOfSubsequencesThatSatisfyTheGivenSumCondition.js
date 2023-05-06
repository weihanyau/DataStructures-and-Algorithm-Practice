/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var numSubseq = function(nums, target) {
    nums.sort((a, b) => a - b);
    let l = 0;
    let r = nums.length - 1;
    let pows = [1];
    let totalSequence = 0;
    for(let i = 1; i < nums.length; i++){
      pows.push((pows[i - 1] * 2) % (1e9 + 7));
    }
    while(l <= r){
      if(nums[l] + nums[r] > target){
        r--;
        continue;
      }
      totalSequence = (totalSequence + pows[r - l]) % (1e9 + 7);
      l++;
    }
    return totalSequence;
};