import numpy as np
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D

# Создание сетки точек
x = np.linspace(-1, 1, 100)
y = np.linspace(-1, 1, 100)
x, y = np.meshgrid(x, y)

# Уравнение поверхности z1
z1 = x**2 + y**2

# Уравнение поверхности z2
z2 = 2 - x**2 - y**2

# Создание 3D графика
fig = plt.figure(figsize=(8, 8))
ax = fig.add_subplot(111, projection='3d')

# Изображение поверхности z1
ax.plot_surface(x, y, z1, alpha=0.5, rstride=100, cstride=100, color='r', label='z1')

# Изображение поверхности z2
ax.plot_surface(x, y, z2, alpha=0.5, rstride=100, cstride=100, color='b', label='z2')

# Изображение точек пересечения
theta = np.linspace(0, 2 * np.pi, 100)
x_circle = np.cos(theta)
y_circle = np.sin(theta)
z_circle = np.ones_like(theta)

ax.plot(x_circle, y_circle, z_circle, color='k', label='Intersection Circle')

# Настройка графика
ax.set_xlabel('X')
ax.set_ylabel('Y')
ax.set_zlabel('Z')
ax.set_title('3D Plot of Surfaces')

# Отображение графика
plt.legend()
plt.show()
