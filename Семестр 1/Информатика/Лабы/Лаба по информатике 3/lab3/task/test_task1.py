import unittest
import task1

class Test_task1(unittest.TestCase):

    def test_withoutSmile(self):
        data = 'fgy2-CX DEWNx - /sda-dsaewkiuy'
        result = 0
        self.assertEquals(result,task1.solve(data))
    def test_withOneSmile(self):
        data = 'efrruio34/-X-/DEWDW4[gk'
        result = 1
        self.assertEquals(result, task1.solve(data))
    def test_with_lot_of_smile(self):
        data = "X/- FWE X-/ 213 --/DWE X-/"
        result = 2
        self.assertEquals(result,task1.solve(data))
    def test_smile_row(self):
        data = "------X/-P X/- X-/X-----/ ew [a"
        result = 1
        self.assertEquals(result,task1.solve(data))
    def test_smileBroken(self):
        data = "X /// X ---- --X--X/X- /XX-/X"
        result = 1
        self.assertEquals(result,task1.solve(data))

if __name__ == "__main__":
    unittest.main()