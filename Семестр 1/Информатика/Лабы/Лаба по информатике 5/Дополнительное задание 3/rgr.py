import numpy as np
import matplotlib.pyplot as plt

# Задаем значения R и deltaR
R = 5
deltaR = 0.1

# Создаем массив значений deltaR
deltaR_values = np.linspace(0, 1, 100)

# Вычисляем значения площади для каждого deltaR
S_values = 2 * np.pi * R * deltaR_values

# Создаем график для аналитического решения
plt.plot(deltaR_values, S_values, label='Аналитическое решение', color='blue')

# Создаем график для точного значения (для сравнения)
plt.axhline(y=np.pi, color='red', linestyle='--', label='Точное значение')

# Оформление графика
plt.xlabel('Изменение радиуса, deltaR')
plt.ylabel('Площадь, S')
plt.title('Сравнение аналитического и точного решения')
plt.legend()
plt.grid(True)
plt.show()
