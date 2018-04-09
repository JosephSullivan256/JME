package com.josephsullivan256.gmail.jme.util.tuple;

import java.util.ArrayList;

import com.josephsullivan256.gmail.jme.core.Component;

public class TupleTypeFactory {
	
	private ArrayList<Class<? extends Component>> types;
	private int index;
	
	public TupleTypeFactory(){
		types = new ArrayList<Class<? extends Component>>();
		index = 0;
	}
	
	public <T extends Component> TupleEntryRetriever<T> addEntryType(Class<T> c){
		types.add(c);
		return new TupleEntryRetriever<T>(index++);
	}
	
	public TupleType build(){
		types.trimToSize();
		return new TupleType(new ArrayList<Class<? extends Component>>(types));
	}
}
