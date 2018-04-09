package com.josephsullivan256.gmail.jme.actions.systems;

import com.josephsullivan256.gmail.jme.core.Entity;
import com.josephsullivan256.gmail.jme.core.EntitySystem;

public abstract class ComponentStructureSystem<T, K extends ComponentStructure> extends EntitySystem<T>{

	public ComponentStructureSystem(String entityCollection) {
		super(entityCollection);
	}

	@Override
	public void register(Entity e) {
		K cs = buildComponentStructure(e);
		if(cs != null) register(cs);
	}
	
	public abstract void register(K cs);
	public abstract K buildComponentStructure(Entity e);
}
