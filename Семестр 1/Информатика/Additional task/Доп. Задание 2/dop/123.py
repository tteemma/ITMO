
def hamming_code(message):

    # Вычисляем проверочные биты
    p1 = message[0] ^ message[2] ^ message[4] ^ message[6]
    p2 = message[1] ^ message[2] ^ message[5] ^ message[6]
    p3 = message[3] ^ message[4] ^ message[5] ^ message[6]

    # Вычисляем позицию бита с ошибкой (если он есть)
    error_position = p1 * 1 + p2 * 2 + p3 * 4

    # Исправляем ошибку (если она есть)
    if error_position > 0:
        message[error_position - 1] = 1 - message[error_position - 1]

    # Возвращаем только информационные биты
    return [message[2], message[4], message[5], message[6]], error_position

# Пример использования
message = [int(i) for i in list(input())]
info_bits, error_position = hamming_code(message)
print("Информационные биты:", *info_bits)
if error_position > 0:
    print("Ошибка в бите:", error_position)
else:
    print("Ошибок нет")

