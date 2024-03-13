from task import task1, task2, task3_1

task = input("Enter task number (1-3): ")

if task == '1':
    print(task1.solve(input("Enter your string: ")))
elif task == "2":
    print(task2.sovle(input("Enter your string: ")))
elif task == '3':
    print(task3_1.sovle(input("Enter your e-mail: ")))