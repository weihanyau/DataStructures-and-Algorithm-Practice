/**
 * @param {number[][]} mat
 * @return {number}
 */
var diagonalSum = function(mat) {
    let sum = 0;
    let x1 = 0;
    let y1 = 0;
    let x2 = mat.length - 1;
    let y2 = 0;
    while(x1 < mat.length ){
      if(x1 === x2 && y1 === y2){
        sum += mat[y1][x1];
      } else {
        sum += mat[y1][x1];
        sum += mat[y2][x2];
      }
      x1++;
      y1++;
      x2--;
      y2++;
    }
    return sum;
};