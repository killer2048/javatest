package com.killer20482.c2;

import java.util.NoSuchElementException;

public class ArrayList22 {
	private static final int DEFAULT_LENGTH = 10;
	private Object[] data;
	private int container;
	private int size=-1;
	public ArrayList22(int container) {
		this.container = container;
		this.data = new Object[container];
	}
	public ArrayList22() {
		this.container = 10;
		this.data = new Object[container];
	}
	
	public int size() {
		return size+1;
	}
	public Object get(int index) {
		if(index>size) {
			throw new IndexOutOfBoundsException();
		}
		return data[index];
	}
	public void add(Object obj) {
		if(isFull()) {
			extendDataArray();
		}
		data[++size] = obj;
		
	}
	
	public boolean isEmpty() {
		return size+1==0;
	}
	
	public boolean isFull() {
		return size+1>=container;
	}
	public Iteratorrr iterator() {
		return new Iter();
	}
	
	private void extendDataArray() {
		//扩展数组
		Object[] newObj = new Object[container+(size+1<DEFAULT_LENGTH?DEFAULT_LENGTH:data.length>>1)];
		System.arraycopy(data, 0,newObj,0, data.length);
		data = newObj;
		container = newObj.length;
	}
	
	private class Iter implements Iteratorrr{
		private int point =0;
//		private final int hash;
		public Iter() {
			//todo:保存hashcode
		}

		@Override
		public boolean hasNext() {
			return point<=size;
		}

		@Override
		public Object next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			} 
//			if(data.hashCode()!=hash) {
//				//todo:data被更改过
//			}
			return data[point++];
		}
		
	}
	
	
	
}
