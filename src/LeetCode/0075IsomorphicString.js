/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isIsomorphic = function(s, t) {
    const map = new Map();
    const set = new Set();

    for(let i = 0; i < s.length; i++){
      if(map.get(s[i]) === undefined){
        if(set.has(t[i])){
          return false;
        }
        map.set(s[i], t[i]);
        set.add(t[i]);
        continue;
      }
      if(map.get(s[i]) !== t[i]){
        return false;
      }
    }
    return true;
};