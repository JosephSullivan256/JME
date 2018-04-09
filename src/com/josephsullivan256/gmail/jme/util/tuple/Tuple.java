package com.josephsullivan256.gmail.jme.util.tuple;

import com.josephsullivan256.gmail.jme.actions.systems.ComponentStructure;
import com.josephsullivan256.gmail.jme.core.Entity;

public abstract class Tuple extends ComponentStructure {
	public Tuple(Entity e) {
		super(e);
	}

	public abstract Object get(int n);
}
