import re

def solve(string):
    pattern_nums = r'\b\d+\b'
    pattern_digs = r'[+=*/-]'

    nums = re.findall(pattern_nums, string)
    digs = re.findall(pattern_digs, string)

    for i in range(len(nums)):
        nums[i] = int(nums[i])
        nums[i] = 4*nums[i]**2 - 7
    res = (nums[0],digs[0],nums[1],digs[1],nums[2])
    result = list(res)
    s =''
    for i in res:
        s += str(i)
        s += ' '
    return s

print(solve("5 + 4 = 9"))