def print_NGE(sequence):
    N = len(sequence)
    stack = []
    result = [-1] * N

    for i in range(N):
        while stack and sequence[stack[-1]] < sequence[i]:
            index = stack.pop()
            result[index] = sequence[i]
        stack.append(i)

    return result


if __name__ == "__main__":
    N = int(input())
    sequence = list(map(int, input().split()))
    result = print_NGE(sequence)
    print(' '.join(map(str, result)))