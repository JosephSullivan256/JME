package com.josephsullivan256.gmail.jme.util.tuple;

import java.util.List;

import com.josephsullivan256.gmail.jme.core.Component;
import com.josephsullivan256.gmail.jme.core.Entity;

public class TupleType {
	
	private List<Class<? extends Component>> types;
	
	public TupleType(List<Class<? extends Component>> list){
		this.types = list;
	}
	
	public Tuple build(Entity e){
		Component[] objs = new Component[types.size()];
		int index = 0;
		for(Class<? extends Component> type: types){
			Component c = e.get(type);
			if(c == null) return null;
			objs[index] = c;
			index++;
		}
		return new InnerTuple(objs,e);
	}
	
	private static class InnerTuple extends Tuple {
		private Component[] objs;
		public InnerTuple(Component[] objs,Entity e){
			super(e);
			this.objs = objs;
		}
		@Override
		public Object get(int n) {
			return objs[n];
		}
	}
}
