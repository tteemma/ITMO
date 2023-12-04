import task3_1
import unittest

class TestTask3_1(unittest.TestCase):
    def test_default(self):
        data = "students.spam@yandex.ru"
        result = ["yandex.ru"]
        self.assertEquals(result, task3_1.sovle(data))
    def test_normalEmail(self):
        data = "uchenik.ITMO@gmail.com"
        result = ["gmail.com"]
        self.assertEquals(result,task3_1.sovle(data))
    def test_withoutEmail(self):
        data = "HelloMir@Im"
        result = []
        self.assertEquals(result,task3_1.sovle(data))
    def test_with_two_dots(self):
        data = "ITMO.Study@email.com"
        result = ["email.com"]
        self.assertEquals(result,task3_1.sovle(data))
    def test_break(self):
        data = "break@ email.ds @dwd. e"
        result = []
        self.assertEquals(result, task3_1.sovle(data))