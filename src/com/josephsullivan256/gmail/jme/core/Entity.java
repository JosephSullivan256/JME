package com.josephsullivan256.gmail.jme.core;

import java.util.List;

public interface Entity {
	public void add(Component c);
	public void remove(Class<?> c);
	public <T extends Component>T get(Class<T> type);
	public List<Component> getComponents();
}
