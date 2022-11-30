/**Binary Search
 * Given sorted array X[] of n elements, search a given element key in X[]. If key exists return its index,
 * otherwise return -1*/
var binarySearch = function (arr, key, l, r) {
    if (l === void 0) { l = 0; }
    if (r === void 0) { r = arr.length - 1; }
    if (l > r) {
        return -1;
    }
    var mid;
    if ((r - l) % 2 === 0) {
        mid = l + (r - l) / 2;
    }
    else {
        mid = l + ((r - l) + 1) / 2;
    }
    if (arr[mid] === key)
        return mid;
    if (key < arr[mid]) {
        return binarySearch(arr, key, l, mid - 1);
    }
    else {
        return binarySearch(arr, key, mid + 1, r);
    }
};
console.log("Binary Search sln");
console.log(binarySearch([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,], 10));
