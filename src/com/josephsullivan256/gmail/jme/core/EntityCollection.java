package com.josephsullivan256.gmail.jme.core;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class EntityCollection {
	
	private List<Entity> entities;
	private List<EntitySystem<?>> systems;
	
	public EntityCollection(){
		entities = new ArrayList<Entity>();
		systems = new ArrayList<EntitySystem<?>>();
	}
	
	private class InnerEntity implements Entity {
		private List<Component> components;
		
		public InnerEntity(){
			components = new ArrayList<Component>();
		}
		
		@Override
		public void add(Component c) {
			components.add(c);
			refresh(this,true);
		}
		
		@Override
		public void remove(Class<?> c) {
			ListIterator<Component> it = components.listIterator();
			while(it.hasNext()){
				if(it.next().getClass().equals(c)) it.remove();
			}
			refresh(this,false);
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public <T extends Component> T get(Class<T> type){
			for(Component c: components){
				if(c.getClass() == type){
					return (T) c;
				}
			}
			return null;
		}

		@Override
		public List<Component> getComponents() {
			return components;
		}
	}
	
	private void refresh(Entity e, boolean componentAddition){
		//really inefficient
		//unnecessary if game has not started (since it hasn't been registered yet)
		for(EntitySystem<?> es: systems){
			es.remove(e);
			es.register(e);
		}
	}
	
	public Entity createEntity(){
		InnerEntity e = new InnerEntity();
		entities.add(e);
		return e;
	}
	
	public Entity copyEntity(Entity e){
		InnerEntity ie = new InnerEntity();
		for(Component c: e.getComponents()){
			ie.add(c);
		}
		return ie;
	}
	
	public void addSystem(EntitySystem<?> es){
		systems.add(es);
		for(Entity e : entities){
			//es.remove(e); //inefficient but could be necessary in certain use cases
			es.register(e);
		}
	}
}
