## Composite

The *abstract class* **Enemy** (component) has several sub-classes. Some, like the **Spider** (leaf),
are just your regular enemy that knows how to attack a **Hero**, others, like the **Hoard** (composite) are an aggregation of *enemies*.

As both the **Spider** and the **Hoard** are *enemies*, they both know how to attack a **Hero**, but the **Hoard** does so by attacking with each one of its children *enemies*.

![Composite UML diagram](/images/uml/composite.svg)


