import re
import time


def ymljson(input_file, out_f):
    with open(input_file, 'r', encoding='utf8') as inputFile:
        data = inputFile.readlines()

    pattern_of_day = r'Суббота:\n'
    day_repl = r'{\n"Суббота":\n'

    lst = [
        "Суббота:\n", "  Расписание:\n", "    Пара1:\n", "    Пара2:\n", "    Пара3:\n", "    Пара4:\n", "    Пара5:\n",
        "    Пара6:\n", "    Пара7:\n", "    Пара8:\n"
    ]

    with open(out_f, 'w', encoding='utf8') as out_f:
        for i in range(len(data)):
            if data[i] in ["Суббота:\n"]:
                rpl = re.sub(pattern_of_day, day_repl, data[i])
                out_f.write(rpl)

            elif data[i] in ["  Расписание:\n"]:
                rpl = re.sub("  Расписание:\n", '\t{\n\t"Расписание":\n\t\t{\n', data[i])
                out_f.write(rpl)

            elif data[i] in ["    Пара1:\n", "    Пара2:\n", "    Пара3:\n", "    Пара4:\n", "    Пара5:\n", "    Пара6:\n",
                             "    Пара7:\n", "    Пара8:\n"]:
                brace_str = data[i].lstrip().split(':', maxsplit=1)
                out_f.write('\t\t"' + brace_str[0] + '":' + brace_str[1])
                out_f.write('\t\t\t{\n')

            else:
                if i + 1 == len(data):
                    brace_str = data[i].lstrip().split(':', maxsplit=1)
                    a = brace_str[1].split("\n")
                    out_f.write('\t\t\t\t"' + brace_str[0] + '":' + a[0].lstrip() + "\n")
                elif i + 1 != len(data) and (data[i + 1] in lst):
                    brace_str = data[i].lstrip().split(':', maxsplit=1)
                    a = brace_str[1].split("\n")
                    out_f.write('\t\t\t\t"' + brace_str[0] + '":' + a[0].lstrip() + "\n")
                else:
                    brace_str = data[i].lstrip().split(':', maxsplit=1)
                    a = brace_str[1].split("\n")
                    out_f.write('\t\t\t\t"' + brace_str[0] + '":' + a[0].lstrip() + ",\n")
                if i + 1 != len(data) and data[i + 1] in lst:
                    out_f.write('\t\t\t},\n')

        out_f.write("\t\t\t}\n\t\t}\n\t}\n}"'\n')


yamlFile = r"input_yaml.yml"
jsonOutFile = r"output_json.json"

st = time.time()
for i in range(100):
    ymljson(yamlFile, jsonOutFile)

et = time.time()
tm = et - st

print("Время выполнения, с помощью регулярных выражений - " + str(tm))