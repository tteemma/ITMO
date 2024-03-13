import numpy as np
import matplotlib.pyplot as plt

# Замените X_squared_plus_Y_squared_minus_c на ваше уравнение
def equation(X, Y):
    return X**2 + Y**2 - c

# Значение c, полученное после преобразований
c = 32

# Генерация точек для построения графика
X = np.linspace(-10, 10, 400)
Y = np.linspace(-10, 10, 400)
X, Y = np.meshgrid(X, Y)

# Вычисление значения уравнения в каждой точке
Z = equation(X, Y)

# Построение графика
plt.contour(X, Y, Z, levels=[0], colors='r')
plt.xlabel('X')
plt.ylabel('Y')
plt.title('График уравнения после преобразований')
plt.grid(True)
plt.axis('equal')
plt.show()