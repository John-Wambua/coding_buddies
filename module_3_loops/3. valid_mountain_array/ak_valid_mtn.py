def valid_mountain(arr):
    ascending = True
    i = 1
    if len(arr) < 3:
        print('false, too small')
        return
    while(ascending):
        if arr[i] > arr[i-1]:
            if arr[i] < arr[i+1]:
                pass
            elif arr[i] == arr[i+1]:
                print('false 1')
                return
            else:
                peak = arr[i]
                ascending = False
            i += 1
        else:
            print('false 2')
            return

    while(not ascending and i < len(arr)-1):
        if arr[i] > arr[i+1]:
            pass
        else:
            print('false 3, peak: ' + str(peak))
            return
        i += 1

    print('true, peak: ' + str(peak))
    
valid_mountain([1,2,9,78,92,91,91,72,4])