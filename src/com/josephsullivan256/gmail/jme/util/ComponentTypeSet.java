package com.josephsullivan256.gmail.jme.util;

import com.josephsullivan256.gmail.jme.core.Component;
import com.josephsullivan256.gmail.jme.core.Entity;

public class ComponentTypeSet {
	
	Class<? extends Component>[] componentTypes;
	
	@SafeVarargs
	public ComponentTypeSet(Class<? extends Component>... c){
		componentTypes = c;
	}
	
	public boolean matches(Entity e){
		for(Class<? extends Component> c: componentTypes){
			if(e.get(c) == null) return false;
		}
		
		return true;
	}
}
