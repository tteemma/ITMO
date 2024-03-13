import numpy as np
import matplotlib.pyplot as plt

# Каноническое уравнение кривой
A = 1
B = 3 / 2
C = 32

# Генерация значений x в заданном диапазоне
x = np.linspace(-15, 15, 400)

# Вычисление соответствующих значений y
y_positive = np.sqrt((C - A * x**2) / B)
y_negative = -np.sqrt((C - A * x**2) / B)

# Построение графика
plt.figure(figsize=(8, 6))
plt.plot(x, y_positive, label='Positive branch')
plt.plot(x, y_negative, label='Negative branch')
plt.title('Graph of the Canonical Equation: $x\'^2 + \\frac{3}{2}y\'^2 = 32$')
plt.xlabel('$x\'$')
plt.ylabel('$y\'$')
plt.axhline(0, color='black',linewidth=0.5)
plt.axvline(0, color='black',linewidth=0.5)
plt.grid(color = 'gray', linestyle = '--', linewidth = 0.5)
plt.legend()
plt.show()
