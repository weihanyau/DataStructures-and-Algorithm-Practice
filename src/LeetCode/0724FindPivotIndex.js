/**
 * @param {number[]} nums
 * @return {number}
 */
var pivotIndex = function(nums) {
  let sum = 0;
  let leftRunningSum = nums.map((num, idx) => {
    sum += num;
    return sum;
  })
  const totalSum = leftRunningSum[nums.length - 1];

  for(let i = 0; i < nums.length; i++){
    let l = 0;
    let r = 0;
    if(i > 0){
      l = leftRunningSum[i - 1];
    }
    if(i < nums.length - 1){
      r = totalSum - l - nums[i];
    }
    if(l === r){
      return i;
    }
  }
  return -1;
};