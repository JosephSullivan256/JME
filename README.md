# JME
Joe's Modular Engine. Flexible framework for creating games in Java.

Creating games is really hard. Who knew? After frustrating myself many times, I decided that I would re-invent the wheel in Java. JME is a game engine that simple provides the modular structure around which one can design their game. Entity Component System (ECS) is nice, but after working with it, I decided to change the overall structure of my engine while incorporating aspects of the design when helpful.

The engine is based around Contexts, Actions, and Dependencies.

## Context
In a game, contexts can represent everything from a menu to level. Their job: hold Dependencies and Actions.

## Action
An action is simply something that does something. That's it.

Each Context has a list of Actions, and it calls them off one-by-one whenever one wants to update the Context.

Where Actions get fun is the built in implementations. These provide for nesting Actions, Systems (as part of ECS), etc.
Example: IntervalSuperAction. This class is an action that stores a list of actions, calling them off one-by-one whenever it needs to update. Rather than simply calling its "sub" Actions every time the context is updated, an IntervalSuperAction will run according to a prespecified interval, allowing the developer to have a consistent experience across hardware.

## Dependency
Sometimes Actions need to share some things. Afterall, sharing is caring. Solution: dependencies. Let's say multiple Actions need a window. Make it a dependency. Let's say multiple Actions need, I don't know, to share some entities (ECS time, baby). Use an EntityCollection as a dependency.

## Extra
Don't want to have to initialize the entire engine in code? Check out JML-ContextBuilder, a project that uses DOXML (my XML interpreter) to initialize the engine from an XML document.
