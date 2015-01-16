'''
Created on 25 Jan 2010

@author: Daniel Acton (code@danielacton.com)
'''
import unittest
from com.danielacton.datastructures.LinkedList import LinkedList


class Test(unittest.TestCase):

    def testConstruction(self):
        x = LinkedList()
        self.assertEqual(0, x.get_size())
        self.assertFalse(x.contains("a"))
        
    def testAddSingle(self):
        x = LinkedList()
        x.add("node1")
        self.assertEqual(1, x.get_size())
        self.assertTrue(x.contains("node1"))

    def testAddMultiple(self):
        x = LinkedList()
        x.add("node1")
        x.add("node2")
        x.add("node3")
        self.assertEqual(3, x.get_size())
        self.assertTrue(x.contains("node1"))
        self.assertTrue(x.contains("node2"))
        self.assertTrue(x.contains("node3"))

    def testRemoveSingle(self):
        x = LinkedList()
        x.add("node1")
        x.add("node2")
        x.add("node3")
        x.remove("node1")
        self.assertEqual(2, x.get_size())
        self.assertFalse(x.contains("node1"))
        self.assertTrue(x.contains("node2"))
        self.assertTrue(x.contains("node3"))

    def testRemoveMultiple(self):
        x = LinkedList()
        x.add("node1")
        x.add("node2")
        x.add("node3")
        x.remove("node1")
        x.remove("node2")
        self.assertEqual(1, x.get_size())
        self.assertFalse(x.contains("node1"))
        self.assertFalse(x.contains("node2"))
        self.assertTrue(x.contains("node3"))

    def testRemoveAll(self):
        x = LinkedList()
        x.add("node1")
        x.add("node2")
        x.add("node3")
        x.remove("node1")
        x.remove("node2")
        x.remove("node3")
        self.assertEqual(0, x.get_size())
        self.assertFalse(x.contains("node1"))
        self.assertFalse(x.contains("node2"))
        self.assertFalse(x.contains("node3"))

    def testRemoveNonExisting(self):
        x = LinkedList()
        x.remove("node1")
        x.add("node1")
        x.remove("node3")
        self.assertEqual(1, x.get_size())
        self.assertTrue(x.contains("node1"))
        self.assertFalse(x.contains("node3"))

    def testRemoveFirst(self):
        x = LinkedList()
        x.add("node1")
        x.add("node2")
        x.add("node3")
        x.remove("node1")
        self.assertEqual(2, x.get_size())
        self.assertTrue(x.contains("node3"))
        self.assertTrue(x.contains("node2"))
        self.assertFalse(x.contains("node1"))

    def testRemoveLast(self):
        x = LinkedList()
        x.add("node1")
        x.add("node2")
        x.add("node3")
        x.remove("node3")
        self.assertEqual(2, x.get_size())
        self.assertTrue(x.contains("node1"))
        self.assertTrue(x.contains("node2"))
        self.assertFalse(x.contains("node3"))

    def testRemoveMiddle(self):
        x = LinkedList()
        x.add("node1")
        x.add("node2")
        x.add("node3")
        x.remove("node2")
        self.assertEqual(2, x.get_size())
        self.assertTrue(x.contains("node1"))
        self.assertTrue(x.contains("node3"))
        self.assertFalse(x.contains("node2"))

    def testIndexOf(self):
        x = LinkedList()
        self.assertEqual(-1, x.index_of("node1"))
        x.add("node1")
        self.assertEqual(0, x.index_of("node1"))
        x.add("node2")
        x.add("node3")
        x.add("node4")
        x.add("node5")
        self.assertEqual(0, x.index_of("node1"))
        self.assertEqual(1, x.index_of("node2"))
        self.assertEqual(2, x.index_of("node3"))
        self.assertEqual(3, x.index_of("node4"))
        self.assertEqual(4, x.index_of("node5"))
        self.assertEqual(-1, x.index_of("node6"))
        x.remove("node2")
        self.assertEqual(0, x.index_of("node1"))
        self.assertEqual(-1, x.index_of("node2"))
        self.assertEqual(1, x.index_of("node3"))
        self.assertEqual(2, x.index_of("node4"))
        self.assertEqual(3, x.index_of("node5"))
        self.assertEqual(-1, x.index_of("node6"))

    def testAddMany(self):
        x = LinkedList()
        x.add_many(["node1", "node2", "node3", "node4"]);
        self.assertEqual(0, x.index_of("node1"))
        self.assertEqual(1, x.index_of("node2"))
        self.assertEqual(2, x.index_of("node3"))
        self.assertEqual(3, x.index_of("node4"))
        self.assertEqual(4, x.get_size())
        
    def testAddManyRemoveOne(self):
        x = LinkedList()
        x.add_many(["node1", "node2", "node3", "node4"]);
        self.assertEqual(0, x.index_of("node1"))
        self.assertEqual(1, x.index_of("node2"))
        self.assertEqual(2, x.index_of("node3"))
        self.assertEqual(3, x.index_of("node4"))
        self.assertEqual(4, x.get_size())
        x.remove("node2")
        self.assertEqual(0, x.index_of("node1"))
        self.assertEqual(-1, x.index_of("node2"))
        self.assertEqual(1, x.index_of("node3"))
        self.assertEqual(2, x.index_of("node4"))
        self.assertEqual(3, x.get_size())

    def testAddManyRemoveMany(self):
        x = LinkedList()
        x.add_many(["node1", "node2", "node3", "node4"]);
        self.assertEqual(0, x.index_of("node1"))
        self.assertEqual(1, x.index_of("node2"))
        self.assertEqual(2, x.index_of("node3"))
        self.assertEqual(3, x.index_of("node4"))
        self.assertEqual(4, x.get_size())
        x.remove_many(["node2", "node3", "node4"])
        self.assertEqual(0, x.index_of("node1"))
        self.assertEqual(-1, x.index_of("node2"))
        self.assertEqual(-1, x.index_of("node3"))
        self.assertEqual(-1, x.index_of("node4"))
        self.assertEqual(1, x.get_size())

    def testAddManyRemoveAll(self):
        x = LinkedList()
        x.add_many(["node1", "node2", "node3", "node4"]);
        self.assertEqual(0, x.index_of("node1"))
        self.assertEqual(1, x.index_of("node2"))
        self.assertEqual(2, x.index_of("node3"))
        self.assertEqual(3, x.index_of("node4"))
        self.assertEqual(4, x.get_size())
        x.remove_many(["node1", "node2", "node3", "node4"])
        self.assertEqual(-1, x.index_of("node1"))
        self.assertEqual(-1, x.index_of("node2"))
        self.assertEqual(-1, x.index_of("node3"))
        self.assertEqual(-1, x.index_of("node4"))
        self.assertEqual(0, x.get_size())
        x.add_many(["node5", "node6", "node7", "node8"]);
        self.assertEqual(-1, x.index_of("node1"))
        self.assertEqual(-1, x.index_of("node2"))
        self.assertEqual(-1, x.index_of("node3"))
        self.assertEqual(-1, x.index_of("node4"))
        self.assertEqual(0, x.index_of("node5"))
        self.assertEqual(1, x.index_of("node6"))
        self.assertEqual(2, x.index_of("node7"))
        self.assertEqual(3, x.index_of("node8"))
        self.assertEqual(4, x.get_size())
        x.remove_many(["node5", "node6", "node7", "node8"])
        self.assertEqual(-1, x.index_of("node5"))
        self.assertEqual(-1, x.index_of("node6"))
        self.assertEqual(-1, x.index_of("node7"))
        self.assertEqual(-1, x.index_of("node8"))
        self.assertEqual(0, x.get_size())

if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()