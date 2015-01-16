function LinkedListNode() {
	this.data = null;
	this.next = null;
}

function LinkedList() {
	this.firstNode = null;
	this.lastNode = null;
	this.size = 0;
	
	/**
	 * Add a node to the list
	 */
	this.add = function(data) {
		
		var newNode = new LinkedListNode();
		newNode.data = data;

		if (this.firstNode == null) {
			this.firstNode = newNode;
			this.lastNode = newNode;
		}
		else {
			this.lastNode.next = newNode;
			this.lastNode = newNode;
		}

		this.size++;		
	}
	
	/**
	 * Return the size of the list
	 */
	this.getSize = function() {
		return this.size;
	}
	
	/**
	 * Check where in the list an element is, -1 is not found
	 */
	this.indexOf = function(data) {
		var currentNode = this.firstNode;
		var position = 0;
		var found = false;
	        
        for (; ; position++) {
            if (currentNode == null) {
                break;
            }
            
            if (data == currentNode.data) {
            	found = true;
                break;
            }
                
            currentNode = currentNode.next;
        }
        
        if (!found) {
        	position = -1;
        }
        
        return position;
	}
	
	/**
	 * Return a string representation of the list
	 */
	this.toString = function() {
	    var currentNode = this.firstNode;
	    
	    result = '{';
	    
	    for (i = 0; currentNode != null; i++) {
	    	if (i > 0) {
	    		result += ',';
	    	}
	    	var dataObject = currentNode.data;
	    	
	    	result += (dataObject == null ? '' : dataObject);
	        currentNode = currentNode.next;
	    }
	    result += '}';
	
	    return result;
	}
	
	/**
	 * Remove a node from the list
	 */
	this.remove = function(data) {
		var currentNode = this.firstNode;

        if (this.size == 0) {
        	return;
        }
	        
        var wasDeleted = false;
	                        
        /* Are we deleting the first node? */
        if (data == currentNode.data) {
            
        	/* Only one node in list, be careful! */
            if (currentNode.next == null) {
            	this.firstNode.data = null;
            	this.firstNode = null;
            	this.lastNode = null;
            	this.size--;
            	return;
            }
            
        	currentNode.data = null;
        	currentNode = currentNode.next; 
        	this.firstNode = currentNode;
        	this.size--;
        	return;
        }
	        
        while (true) {
            /* If end of list, stop */
            if (currentNode == null) {
            	wasDeleted = false;
                break;
            }

            /* Check if the data of the next is what we're looking for */
            var nextNode = currentNode.next;
            if (nextNode != null) {
                if (data == nextNode.data) {
                    
                    /* Found the right one, loop around the node */
                    var nextNextNode = nextNode.next;
                    currentNode.next = nextNextNode;
                    
                    nextNode = null;
                    wasDeleted = true;
                    break;
                }
            }
                
            currentNode = currentNode.next;
        }
        
        if (wasDeleted) {
        	this.size--;
        }
	}
}

