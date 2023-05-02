/**
 * @param {string} s
 * @return {number}
 */
var longestPalindrome = function(s) {
  let map = {};
  let count = 0;
  
  for(let c of s){
    map[c] = (map[c] || 0) + 1;
    if(map[c] % 2 === 0) count += 2;
  }

  return s.length > count ? count + 1 : count;
};