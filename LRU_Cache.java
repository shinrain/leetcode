import java.util.*;
import java.lang.*;

// LRU_Cache.java

// Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

// get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
// set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

class Mem{
	int key;
	int value;
	Mem prev;
	Mem next;

	Mem(int _key, int _value){
		key = _key;
		value = _value;
		prev = null;
		next = null;
	}

	public String toString(){
		return "key = "+key+", value = "+value;
	}
}


class LRUCache {
    
    
    int capacity;
    int siz;
    Mem head;
    Mem tail;
    HashMap<Integer, Mem> map;


    public LRUCache(int capacity) {
		this.capacity = capacity;
		siz = 0;
		head = null;
		tail = null;
		map = new HashMap<Integer, Mem>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Mem obj = map.get(key);
        int re = obj.value;
        if(siz == 1 || head == obj)
        	return re;

        

		if(obj == tail)
        {
        	tail = obj.prev;
        	tail.next = null;
        	obj.prev = null;

        	obj.next = head;
        	head.prev = obj;
        	head = obj;
        }else
        {
			obj.prev.next = obj.next;
			obj.next.prev = obj.prev;
        	obj.prev = null;

        	obj.next = head;
        	head.prev = obj;
        	head = obj;
        }
        return re;
    }
    
    public void set(int key, int value) {

        if(map.containsKey(key))
        {	
			map.get(key).value = value; 
			get(key);
        	return;
        }

        Mem obj = new Mem(key, value);
        if(siz < capacity)
        {
        	if(head == null)
        	{
        		head = obj;
        		tail = obj;
        	}
        	else{
	        	obj.next = head;
	        	head.prev = obj;
	        	head = obj;
	        }
	        map.put(key, obj);
	        siz++;
        }
        else{
        	if(siz != 1){
        		map.remove(tail.key);

        		tail.prev.next = null;
                tail = tail.prev;
	        	obj.next = head;
	        	head.prev = obj;
	        	head = obj;
	        	map.put(key, head);

	        }else
	        {
	        	map.remove(head.key);
	        	head = obj;
	        	tail = obj;

	        	map.put(key, obj);
	        }
        }
    }
    public static void main(String[] args){
    	LRUCache LRU = new LRUCache(2);
    	LRU.set(2,1);
    	LRU.set(1,1);
    	LRU.get(2);
    	LRU.set(4,1);
    	LRU.get(1);
    	LRU.get(2);
    	// LRU.set(1,1);
    	// LRU.set(2,2);
    	// LRU.set(3,3);
    	// LRU.set(4,4);
    	// LRU.get(4);
    	// LRU.get(3);
    	// LRU.get(2);
    	// LRU.get(1);

    	// LRU.set(5,5);
    	// LRU.get(1);
    	// LRU.get(2);
    	// LRU.get(3);
    	// LRU.get(4);
    	// LRU.get(5);



    }
}