import task2
import unittest

class Test_task2(unittest.TestCase):
    def test_def(self):
        data = "А ты знал, что ВТ – лучшая кафедра в ИТМО"
        result = ["ВТ – лучшая кафедра в ИТМО"]
        self.assertEquals(result, task2.sovle(data))
    def test_withoutWord(self):
        data = "В ИТМО есть 3 спортивных зала"
        result = []
        self.assertEquals(result,task2.sovle(data))
    def test_one_word(self):
        data = "ВТ ИТМО"
        result = ["ВТ ИТМО"]
        self.assertEquals(result,task2.sovle(data))
    def test_two_words(self):
        data = "ВТ значит ИТМО"
        result = ["ВТ значит ИТМО"]
        self.assertEquals(result,task2.sovle(data))
    def test_hard_words(self):
        data = "ВТ это лучший факультет который есть в ИТМО"
        result = []
        self.assertEquals(result,task2.sovle(data))
if __name__ == "__main__":
    unittest.main()