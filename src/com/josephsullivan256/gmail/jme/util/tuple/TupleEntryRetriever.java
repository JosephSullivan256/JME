package com.josephsullivan256.gmail.jme.util.tuple;

public class TupleEntryRetriever<T> {
	
	private int index;
	
	public TupleEntryRetriever(int index){
		this.index = index;
	}
	
	@SuppressWarnings("unchecked")
	public T get(Tuple t){
		return (T) t.get(index);
	}
}
