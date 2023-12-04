import re

pattern_nums = r'\b\d+\b'
pattern_digs = r'[+=*/-]'

stringg = "20 + 22 = 42"

nums = re.findall(pattern_nums, stringg)
digs = re.findall(pattern_digs, stringg)

for i in range(len(nums)):
    nums[i] = int(nums[i])
    nums[i] = 4*nums[i]**2 - 7

res = nums[0],digs[0],nums[1],digs[1],nums[2]
print(*res)


