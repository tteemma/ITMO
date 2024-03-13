import numpy as np
import matplotlib.pyplot as plt

# Определение функций
def f(x):
    return (4 * x**3) / (1 - 2 * x)**2

def g(x):
    return 2 * x - np.sin(x / 2)

# Создание массива значений x
x_values = np.linspace(-1, 1, 400)

# Вычисление значений функций для каждого x
f_values = f(x_values)
g_values = g(x_values)

# Построение графика
plt.figure(figsize=(10, 6))

# График функции f(x)
plt.plot(x_values, f_values, label='f(x)')

# График функции g(x)
plt.plot(x_values, g_values, label='g(x)')

# Оформление графика
plt.axhline(0, color='black',linewidth=0.5)
plt.axvline(0, color='black',linewidth=0.5)
plt.grid(color = 'gray', linestyle = '--', linewidth = 0.5)
plt.title('Графики функций f(x) и g(x)')
plt.xlabel('x')
plt.ylabel('y')
plt.legend()

# Показать график
plt.show()
