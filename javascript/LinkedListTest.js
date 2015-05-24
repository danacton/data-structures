function testConstructor() {
	var x = new LinkedList();
	assertEquals(1, 1);
}

function testAddOne() {
	var x = new LinkedList();
	x.add('node1');
	assertEquals(1, x.getSize());
}

function testAddMany() {
	var x = new LinkedList();
	x.add('node1');
	x.add('node2');
	x.add('node3');
	x.add('node4');
	assertEquals(4, x.getSize());
	
	assertEquals(0, x.indexOf('node1'));
	assertEquals(1, x.indexOf('node2'));
	assertEquals(2, x.indexOf('node3'));
	assertEquals(3, x.indexOf('node4'));
}

function testRemoveOneStart() {
	var x = new LinkedList();
	x.add('node1');
	x.add('node2');
	x.add('node3');
	x.add('node4');

	assertEquals(4, x.getSize());
	assertEquals(0, x.indexOf('node1'));
	assertEquals(1, x.indexOf('node2'));
	assertEquals(2, x.indexOf('node3'));
	assertEquals(3, x.indexOf('node4'));
	
	x.remove('node1');

	assertEquals(3, x.getSize());
	assertEquals(-1, x.indexOf('node1'));
	assertEquals(0, x.indexOf('node2'));
	assertEquals(1, x.indexOf('node3'));
	assertEquals(2, x.indexOf('node4'));
}

function testRemoveOneEnd() {
	var x = new LinkedList();
	x.add('node1');
	x.add('node2');
	x.add('node3');
	x.add('node4');

	assertEquals(4, x.getSize());
	assertEquals(0, x.indexOf('node1'));
	assertEquals(1, x.indexOf('node2'));
	assertEquals(2, x.indexOf('node3'));
	assertEquals(3, x.indexOf('node4'));
	
	x.remove('node4');

	assertEquals(3, x.getSize());
	assertEquals(0, x.indexOf('node1'));
	assertEquals(1, x.indexOf('node2'));
	assertEquals(2, x.indexOf('node3'));
	assertEquals(-1, x.indexOf('node4'));
}

function testRemoveOneInside() {
	var x = new LinkedList();
	x.add('node1');
	x.add('node2');
	x.add('node3');
	x.add('node4');

	assertEquals(4, x.getSize());
	assertEquals(0, x.indexOf('node1'));
	assertEquals(1, x.indexOf('node2'));
	assertEquals(2, x.indexOf('node3'));
	assertEquals(3, x.indexOf('node4'));
	
	x.remove('node2');

	assertEquals(3, x.getSize());
	assertEquals(0, x.indexOf('node1'));
	assertEquals(-1, x.indexOf('node2'));
	assertEquals(1, x.indexOf('node3'));
	assertEquals(2, x.indexOf('node4'));
}

function testRemoveManyStart() {
	var x = new LinkedList();
	x.add('node1');
	x.add('node2');
	x.add('node3');
	x.add('node4');
	x.add('node5');
	x.add('node6');
	x.add('node7');

	assertEquals(7, x.getSize());
	assertEquals(0, x.indexOf('node1'));
	assertEquals(1, x.indexOf('node2'));
	assertEquals(2, x.indexOf('node3'));
	assertEquals(3, x.indexOf('node4'));
	assertEquals(4, x.indexOf('node5'));
	assertEquals(5, x.indexOf('node6'));
	assertEquals(6, x.indexOf('node7'));
	
	x.remove('node1');
	x.remove('node2');
	x.remove('node3');

	assertEquals(4, x.getSize());
	assertEquals(-1, x.indexOf('node1'));
	assertEquals(-1, x.indexOf('node2'));
	assertEquals(-1, x.indexOf('node3'));
	assertEquals(0, x.indexOf('node4'));
	assertEquals(1, x.indexOf('node5'));
	assertEquals(2, x.indexOf('node6'));
	assertEquals(3, x.indexOf('node7'));
}

function testRemoveManyStart() {
	var x = new LinkedList();
	x.add('node1');
	x.add('node2');
	x.add('node3');
	x.add('node4');
	x.add('node5');
	x.add('node6');
	x.add('node7');

	assertEquals(7, x.getSize());
	assertEquals(0, x.indexOf('node1'));
	assertEquals(1, x.indexOf('node2'));
	assertEquals(2, x.indexOf('node3'));
	assertEquals(3, x.indexOf('node4'));
	assertEquals(4, x.indexOf('node5'));
	assertEquals(5, x.indexOf('node6'));
	assertEquals(6, x.indexOf('node7'));
	
	x.remove('node1');
	x.remove('node2');
	x.remove('node3');

	assertEquals(4, x.getSize());
	assertEquals(-1, x.indexOf('node1'));
	assertEquals(-1, x.indexOf('node2'));
	assertEquals(-1, x.indexOf('node3'));
	assertEquals(0, x.indexOf('node4'));
	assertEquals(1, x.indexOf('node5'));
	assertEquals(2, x.indexOf('node6'));
	assertEquals(3, x.indexOf('node7'));
}

function testRemoveManyEnd() {
	var x = new LinkedList();
	x.add('node1');
	x.add('node2');
	x.add('node3');
	x.add('node4');
	x.add('node5');
	x.add('node6');
	x.add('node7');

	assertEquals(7, x.getSize());
	assertEquals(0, x.indexOf('node1'));
	assertEquals(1, x.indexOf('node2'));
	assertEquals(2, x.indexOf('node3'));
	assertEquals(3, x.indexOf('node4'));
	assertEquals(4, x.indexOf('node5'));
	assertEquals(5, x.indexOf('node6'));
	assertEquals(6, x.indexOf('node7'));
	
	x.remove('node7');
	x.remove('node5');
	x.remove('node6');

	assertEquals(4, x.getSize());
	assertEquals(0, x.indexOf('node1'));
	assertEquals(1, x.indexOf('node2'));
	assertEquals(2, x.indexOf('node3'));
	assertEquals(3, x.indexOf('node4'));
	assertEquals(-1, x.indexOf('node5'));
	assertEquals(-1, x.indexOf('node6'));
	assertEquals(-1, x.indexOf('node7'));
}

function testRemoveManyInside() {
	var x = new LinkedList();
	x.add('node1');
	x.add('node2');
	x.add('node3');
	x.add('node4');
	x.add('node5');
	x.add('node6');
	x.add('node7');

	assertEquals(7, x.getSize());
	assertEquals(0, x.indexOf('node1'));
	assertEquals(1, x.indexOf('node2'));
	assertEquals(2, x.indexOf('node3'));
	assertEquals(3, x.indexOf('node4'));
	assertEquals(4, x.indexOf('node5'));
	assertEquals(5, x.indexOf('node6'));
	assertEquals(6, x.indexOf('node7'));
	
	x.remove('node3');
	x.remove('node4');
	x.remove('node5');

	assertEquals(4, x.getSize());
	assertEquals(0, x.indexOf('node1'));
	assertEquals(1, x.indexOf('node2'));
	assertEquals(-1, x.indexOf('node3'));
	assertEquals(-1, x.indexOf('node4'));
	assertEquals(-1, x.indexOf('node5'));
	assertEquals(2, x.indexOf('node6'));
	assertEquals(3, x.indexOf('node7'));
}

function testIndexOfNonExistent() {
	var x = new LinkedList();

	assertEquals(-1, x.indexOf('blah'));
	x.add('node1');
	assertEquals(-1, x.indexOf('blah'));
	assertEquals(0, x.indexOf('node1'));
}

function testAddRemove() {
	var x = new LinkedList();
	x.add('node1');
	x.add('node2');
	x.add('node3');
	x.add('node4');
	x.add('node5');
	x.add('node6');
	x.add('node7');

	assertEquals(7, x.getSize());
	assertEquals(0, x.indexOf('node1'));
	assertEquals(1, x.indexOf('node2'));
	assertEquals(2, x.indexOf('node3'));
	assertEquals(3, x.indexOf('node4'));
	assertEquals(4, x.indexOf('node5'));
	assertEquals(5, x.indexOf('node6'));
	assertEquals(6, x.indexOf('node7'));

	x.remove('node1');
	x.remove('node2');
	x.remove('node3');
	x.remove('node4');
	x.remove('node5');
	x.remove('node6');
	x.remove('node7');
	
	assertEquals(0, x.getSize());
	assertEquals(-1, x.indexOf('node1'));
	assertEquals(-1, x.indexOf('node2'));
	assertEquals(-1, x.indexOf('node3'));
	assertEquals(-1, x.indexOf('node4'));
	assertEquals(-1, x.indexOf('node5'));
	assertEquals(-1, x.indexOf('node6'));
	assertEquals(-1, x.indexOf('node7'));

	x.add('node1');
	x.add('node2');
	x.add('node3');
	x.add('node4');
	x.add('node5');
	x.add('node6');
	x.add('node7');

	assertEquals(7, x.getSize());
	assertEquals(0, x.indexOf('node1'));
	assertEquals(1, x.indexOf('node2'));
	assertEquals(2, x.indexOf('node3'));
	assertEquals(3, x.indexOf('node4'));
	assertEquals(4, x.indexOf('node5'));
	assertEquals(5, x.indexOf('node6'));
	assertEquals(6, x.indexOf('node7'));
}

function runAllTests() {
	var suite = new TestSuite();
	
	suite.addTest(testConstructor);
	suite.addTest(testAddOne);
	suite.addTest(testAddMany);
	suite.addTest(testRemoveOneStart);
	suite.addTest(testRemoveOneEnd);
	suite.addTest(testRemoveOneInside);
	suite.addTest(testRemoveManyStart);
	suite.addTest(testRemoveManyEnd);
	suite.addTest(testRemoveManyInside);
	suite.addTest(testIndexOfNonExistent);
	suite.addTest(testAddRemove);

	var result = '';
	result += suite.runTestSuite();
	document.getElementById('results').innerHTML = result;
}