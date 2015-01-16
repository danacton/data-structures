/**
 * This is a class which represents a test
 * @return
 */
function Test() {
	var testName = '';
	var testFunction = null;
}

/**
 * Assert that two values are equal
 */
function assertEquals(expected, actual) {
	if (expected != actual) {
		throw 'Assertion failed: expected ['+expected+'], but got ['+actual+']'; 
	}
}

function TestSuite() {
	this.tests = [];
	
	/**
	 * Add a test to the suite
	 */
	this.addTest = function(inTest) {
		var x = new Test();
		x.testName = inTest.name;
		x.testFunction = inTest;
		this.tests.push(x);
	}

	/**
	 * Run the test suite
	 */
	this.runTestSuite = function() {
		var result = 'TEST RESULTS: <br/>';
		
		for (var i = 0; i < this.tests.length; i++) {
			
			var testObj = this.tests[i];
			
			var testName = testObj.testName;
			var testFn = testObj.testFunction;
			
			result += testName +': ';
			
			var testOkay = true; 
			try {
				testFn();
			}
			catch (err) {
				result += err;
				testOkay = false;
			}
			
			if (testOkay) {
				result += ' passed';
			}
			
			result += '<br/>';
		}
		
		return result;
	}
}
