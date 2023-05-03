/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[][]}
 */
var findDifference = function(nums1, nums2) {
    const set1 = new Set();
    const set2 = new Set();

    for(const num of nums1){
      set1.add(num);
    }

    for(const num of nums2){
      set2.add(num);
    }

    const arr1 = [];
    const arr2 = [];

    for(const num of set1){
      if(!set2.has(num)){
        arr1.push(num);
      }
    }

    for(const num of set2){
      if(!set1.has(num)){
        arr2.push(num);
      }
    }

    return [arr1, arr2]
};