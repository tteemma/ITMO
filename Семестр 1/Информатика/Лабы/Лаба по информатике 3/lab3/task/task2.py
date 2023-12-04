import re

def sovle(string):
    pattern = re.compile(r"ВТ(?:\W*[\s-]+\w+){0,4}[\s-]+ИТМО")
    return pattern.findall(string)

#data = 'А ты знал, что ВТ – лучшая кафедра в ИТМО?'

#match = re.findall(r"ВТ(?:\W*[\s-]+\w+){0,4}[\s-]+ИТМО",data)
#print(match)