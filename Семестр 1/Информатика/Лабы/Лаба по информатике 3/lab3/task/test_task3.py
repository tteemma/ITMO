import task3
import unittest

class TestTask3(unittest.TestCase):
    def test_default(self):
        data = "20 + 22 = 42"
        result = [1593, "+", 1929, "=", 7049]
        self.assertEquals(result, task3.solve(data))
    def test_otrCounts(self):
        data = "-1 / -1 = 1"
        result = [-3, '-', -3, '/', -3]
        self.assertEquals(result,task3.solve(data))
    def test_minus(self):
        data = "5.3 + 4.7 = 10"
        result = [93, '+', 29, '=', 57]
        self.assertEquals(result,task3.solve(data))
    def test_multiplication(self):
        data = "10 * 10 = 100"
        result = [393, '*', 393, '=', 39993]
        self.assertEquals(result,task3.solve(data))
    def test_division(self):
        data = "500 / 25 = 20"
        result = [999993, '/', 2493, '=', 1593]
        self.assertEquals(result,task3.solve(data))

