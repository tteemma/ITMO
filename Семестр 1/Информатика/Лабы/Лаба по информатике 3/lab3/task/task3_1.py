import re

def sovle(string):
    match = re.findall("@(:?\w+\.\w+)",string)
    return match

print(sovle("fewgfyw@yandewfwefwfwex.ru"))