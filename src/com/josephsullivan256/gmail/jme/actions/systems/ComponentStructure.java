package com.josephsullivan256.gmail.jme.actions.systems;

import com.josephsullivan256.gmail.jme.core.Entity;

public class ComponentStructure {
	private Entity e;
	
	public ComponentStructure(Entity e){
		this.e = e;
	}
	
	public Entity getEntity(){
		return e;
	}
}
