some_arr = [
    [0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0],
    [0, 0, 1, 1, 1],
    [0, 0, 0, 0, 1],
    [0, 0, 0, 1, 1]
]

# LINEAR SEARCH BRUTE FORCE APPROACH
def brute_force_solution(arr, rows, cols):
    max_ones = 0 # maximum number of ones
    max_row_index = -1 # index of row with most ones

    for i in range(rows):
        ones_in_row = 0
        for j in range(cols):
            if arr[i][j] == 1:
                ones_in_row += 1
        
        if ones_in_row > max_ones:
            max_row_index = i
            max_ones = ones_in_row
    
    return max_row_index

# BINARY SEARCH APPROACH 
# binary search a single row
def search_row(row, left, right):
    if left <= right:
        mid = left + (right - left) // 2
        if (row[mid] == 1) and (row[mid - 1] == 0 or mid == 0):
            # found first one
            return mid
        elif row[mid] == 0:
            # search right half
            return search_row(row, mid+1, right)
        else:
            # search left half
            return search_row(row, left, mid-1)
    
    # no one in row
    return -1

def binary_search_solution(arr, rows, cols):
    max_ones = 0
    max_row_index = -1
    for i in range(rows):
        first_one_index = search_row(arr[i], 0, cols -1)
        ones_in_row = cols - first_one_index
        if first_one_index != -1 and ones_in_row > max_ones:
            max_row_index = i
            max_ones = ones_in_row
    return max_row_index

# NESTED LOOP APPROACH
# since each row is sorted, the row with the most ones will have 
# its first one closest to the left end of the row. so we can scan 
# the array somewhat diagonally from top to bottom, left to right, 
# looking for which row has its first one farthest to the left

def nested_loops_solution(arr, rows, cols):
    max_row_index = -1
    current_column = cols - 1 # start from last column
    for i in range(rows):
        while current_column >= 0 and arr[i][current_column] == 1:
            current_column -= 1
            max_row_index = i
    
    return max_row_index

# print(brute_force_solution(some_arr, 5, 5))
# print(binary_search_solution(some_arr, 5, 5))
# print(nested_loops_solution(some_arr, 5, 5))