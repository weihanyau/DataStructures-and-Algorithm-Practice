/**
 * @param {string[]} strs
 * @return {number}
 */
var numSimilarGroups = function(strs) {
  let group = 0;
  for(let i = 0; i < strs.length; i++){
    if(strs[i] === null) continue;
    let temp = strs[i];
    strs[i] = null;
    group++;
    dfs(strs, temp);
  } 
  return group;
};

function dfs(strs, s){
  for(let i = 0; i < strs.length; i++){
    if(strs[i] === null) continue;
    if(checkSimilar(strs[i], s)){
      let similarString = strs[i];
      strs[i] = null;
      dfs(strs, similarString);
    }
  }
}

function checkSimilar(str1, str2) {
  if(str1 === str2) return true;
  let notSimilarChar = 0;
  for(let i = 0; i < str1.length && notSimilarChar <= 2; i++){
    if(str1[i] !== str2[i]){
      notSimilarChar++;
    }
  }
  return notSimilarChar == 2;
}