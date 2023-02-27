target_sum = 15
some_arr = [5, 8, 9, 16, -9, 8, 10]
n = len(some_arr)

# BRUTE FORCE / NESTED LOOPS APPROACH
def nested_loops(arr, target):
    for i in range(n):
        for j in range(i+1, n):
            if arr[i] + arr[j] == target:
                return True
    return False

# SORTING & BINARY SEARCH
def binary_search(arr, left, right, target):
    while left <= right:
        mid = left + (right - left) // 2
        if arr[mid] == target:
            return True
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return False

def sort_and_search_solution(arr, target):
    arr.sort()
    for i in range(n):
        found = binary_search(arr, 0, n-1, target_sum - arr[i])
        if found:
            return True
    return False

# TWO POINTERS APPROACH
def two_pointers_solution(arr, target):
    arr.sort()
    left = 0
    right = n - 1

    while left < right:
        if arr[left] + arr[right] == target:
            return True
        elif arr[left] + arr[right] < target:
            left += 1
        else:
            right -= 1
    
    return False

# HASH TABLE SOLUTION
def hash_table_solution(arr, target):
    table = {}
    for i in range(n):
        key = target - arr[i]
        if key in table:
            return True
        table[arr[i]] = True
    
    return False

# print(nested_loops(some_arr, target_sum))
# print(sort_and_search_solution(some_arr, target_sum))
# print(two_pointers_solution(some_arr, target_sum))
# print(hash_table_solution(some_arr, target_sum))