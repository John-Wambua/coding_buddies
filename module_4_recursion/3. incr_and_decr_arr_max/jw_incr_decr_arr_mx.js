/**Find max in an array which is first increasing then decreasing
 * Input X[] = [18,110,210,452,810,500,101,13], Output: 810
 * Input X[] = [1,2,3,4,5,3,2,1], Output: 5*/
var findMinMax = function (arr, l, r) {
    if (l === void 0) { l = 0; }
    if (r === void 0) { r = arr.length - 1; }
    if (l === r) {
        return arr[l];
    }
    var mid = Math.floor(l + (r - l) / 2);
    if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
        return arr[mid];
    }
    if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1]) {
        return findMinMax(arr, l, mid - 1);
    }
    else if (arr[mid] < arr[mid + 1] && arr[mid] > arr[mid - 1]) {
        return findMinMax(arr, mid + 1, r);
    }
};
console.log("Min Max sln");
console.log(findMinMax([1, 2, 3, 4, 5, 3, 2, 1]));
