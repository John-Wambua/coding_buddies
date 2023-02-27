def modulus_solution(n):
    output =[]
    for i in range(1, n+1):
        if (i % 3 == 0) and (i % 5 == 0):
            output.append('FizzBuzz')
        elif i % 3 == 0:
            output.append('Fizz')
        elif i % 5 == 0:
            output.append('Buzz')
        else:
            output.append(str(i))
    return output

# modulus is expensive at the low level, so try a solution using counting:

def non_modulus_solution(n):
    output = []
    fizzCount = 0
    buzzCount = 0

    for i in range(1, n+1):
        fizzCount += 1
        buzzCount += 1
        if fizzCount == 3 and buzzCount == 5:
            output.append('FizzBuzz')
            fizzCount = 0
            buzzCount = 0
        elif fizzCount == 3:
            output.append('Fizz')
            fizzCount = 0
        elif buzzCount == 5:
            output.append('Buzz')
            buzzCount = 0
        else:
            output.append(str(i))

    return output

# increasing the number of divisibility tests will increase the number of conditional 
# statements exponentially, so only test divisibility with each individual number instead of 
# their combinations ('FizzBuzz' combines two divisibility tests):

def string_concatenation_solution(n, m=1):
    output = []
    for i in range(m, n+1):
        s = ''
        if i % 3 == 0:
            s = s + 'Fizz'
        if i % 5 == 0:
            s = s + 'Buzz'
        if i % 7 == 0:
            s = s + 'Jazz'
        if s == '':
            s = s + str(i)

        output.append(s)

    return output


# code would be more maintainable with a hash table instead of adding conditional statements
def hash_table_solution(n, m=1):
    output = []
    table = {
        3: 'Fizz',
        5: 'Buzz',
    }

    for i in range(m, n+1):
        s = ''
        for key in table:
            if i % key == 0:
                s = s + table[key]
        
        if s == '':
            s = str(i)

        output.append(s)

    return output

# print(non_modulus_solution(15))
# print(hash_table_solution(110, 100))
print(string_concatenation_solution(120, 100))
# print(modulus_solution(20))