import re
pattern = r'\".*?\"'
w1 = 'Моряки прокричали - "Ура" - "Ура" - "Ура"!'


print(re.search(pattern, w1))


