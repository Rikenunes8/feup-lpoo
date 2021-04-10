## Observer

The *abstract class* **Enemy** (*subject*) can have many **EnemyObserver**s (observer). Every time its
**Position** or *energy* level changes, each observer is notified. The **Spider** (concrete subject) class is a concrete implementation of an **Enemy**. 

The **Arena** (concrete observer), as an **EnemyObserver**, registers for updates on every *Enemy* that it contains. This way, when the *energy* level of an **Enemy** reaches zero, it knows to *remove*
it, and when its position changes it knows that is time to *redraw*.

![Observer UML diagram](/images/uml/observer.svg)


