/**Convert Roman Number to corresponding integer value
 * I  1
 * V  5
 * X  10
 * L  50
 * C  100
 * D  500
 * M  1000
 *
 * Input range is [1, 3999]
 * When a smaller number is placed before a larger number, their values are subtracted
 * e.g. XL - 40, MCMIV - 1904*/
const romanToInt = (romanVal) => {
    romanVal = romanVal.toUpperCase();
    const romanIntObj = {I: 1, V: 5, X: 10, L: 50, C: 100, D: 500, M: 1000};
    const romanChars = Object.keys(romanIntObj); // [I, V, X, L, C, D, M]
    let total = 0;


    for (let i = 0; i< romanVal.length; i ++){
        if (romanChars.indexOf(romanVal[i]) === -1){
            return 0;
        }
        if (romanIntObj[romanVal[i]] < romanIntObj[romanVal[i+1]]){
            const val = romanIntObj[romanVal[i+1]] - romanIntObj[romanVal[i]];
            total +=val;
            i++;
        }else {
            total += romanIntObj[romanVal[i]]
        }
    }
    return total;
}
console.log(romanToInt("MCMXCIV"))
