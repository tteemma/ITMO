import re

def solve(string):
    pattern = r'X-/'
    return len(re.findall(pattern,string))