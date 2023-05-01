/**
 * @param {number[]} salary
 * @return {number}
 */
var average = function(salary) {
    let max = salary[0];
    let min = salary[0];
    let sum = 0;

    for(let i in salary){
      max = Math.max(salary[i], max);
      min = Math.min(salary[i], min);
      sum += salary[i];
    }

    return (sum - min - max) / (salary.length - 2);
};