# Design Pattern Examples

A set of design pattern examples all about heroes, arenas, and monsters, completely unit-tested.

## Factory-Method

[Code](https://github.com/arestivo/designpatterns-hero/tree/master/src/main/java/com/aor/factorymethod) | [Tests](https://github.com/arestivo/designpatterns-hero/tree/master/src/test/java/com/aor/factorymethod)

How *enemies* can use a **factory method** to decide what weapon they use in battle. 
The *abstract* **Enemy** class has an *abstract* **createWeapon** method overridden 
by the concrete enemy classes; each returning a different weapon. When attacking 
the hero, enemies use whichever weapon was selected by the **createWeapon** method.

```
public abstract class Enemy {
  private final Weapon weapon;
  public Enemy() { this.weapon = createWeapon(); }
  protected abstract Weapon createWeapon();
  public void attack(Hero hero) { weapon.attack(hero); }
}
```

Concrete enemy class **Spider** overriding the **createWeapon** method and returning two 
dangerous **fangs** as its weapon of choice:

```
public class Spider extends Enemy {
    @Override
    protected Weapon createWeapon() {
        return new Fang(2);
    }
}
```

## Composite

[Code](https://github.com/arestivo/designpatterns-hero/tree/master/src/main/java/com/aor/composite) | [Tests](https://github.com/arestivo/designpatterns-hero/tree/master/src/test/java/com/aor/composite)

How a **Hoard** of enemies can behave as a single **Enemy** by using the *composite* pattern.
A **Hoard** of enemies contains a **List** of enemies (of many different types) but is also 
itself an **Enemy**.

```
public Hoard(Position position) {
  super(position);
    this.enemies = new ArrayList<>();
  }
}
```

When moving, all enemies in the hoard move at the same time, when attacking they unite
as a single foe:

```
public void moveUp() {
  super.moveUp();
    for (Enemy enemy : enemies) enemy.getPosition().moveTo(getPosition());
}

public void attack(Hero hero) {
  for (Enemy enemy : enemies)
    enemy.attack(hero);
}
```

## Command

[Code](https://github.com/arestivo/designpatterns-hero/tree/master/src/main/java/com/aor/command) | [Tests](https://github.com/arestivo/designpatterns-hero/tree/master/src/test/java/com/aor/command)

How by encapsulating behavior inside **commands**, we can control **heroes** and then, as if
toying with entropy, we can reverse the arrow of time simply by **stacking** commands and
then **popping** them out and **undoing** what they have done:

```
public class Hero {
  public void execute(HeroCommand command) {
    command.execute(this);
    commands.add(command);
  }

  public void undo() {
    HeroCommand command = commands.pop();
    command.undo(this);
  }
}
```

## Observer

[Code](https://github.com/arestivo/designpatterns-hero/tree/master/src/main/java/com/aor/observer) | [Tests](https://github.com/arestivo/designpatterns-hero/tree/master/src/test/java/com/aor/observer)

How **enemies** do not need to know who is **observing** them, as long as **observers** all follow
the same interface. If that's the case, then telling all **observers** something changed is
as easy as pie:

```
public class Enemy {
  public void setEnergy(int energy) {
    this.energy = energy;
    for (EnemyObserver observer : observers)
      observer.energyChanged(this);
  }
}
```

The **enemy** has no idea the **arena** is spying; it will be kicked out as soon as its energy 
reaches zero.

```
public Arena {
  public void addEnemy(Enemy enemy) {
    enemies.add(enemy);
    enemy.addEnemyObserver(new EnemyObserver() {
      public void energyChanged(Enemy enemy) {
        if (enemy.getEnergy() <= 0) enemies.remove(enemy);
      }
    }
  }
}
```

## Strategy

[Code](https://github.com/arestivo/designpatterns-hero/tree/master/src/main/java/com/aor/strategy) | [Tests](https://github.com/arestivo/designpatterns-hero/tree/master/src/test/java/com/aor/strategy)

How by combining **strategies**, we can have much more *variety* without much more work.
An **enemy** only does whatever its **strategy** dictates, and different types of actions 
can have different types of strategies, as long as they all have the same interface.

```
public interface AttackStrategy {
    void attack(Enemy enemy, Hero hero);
}

public interface MoveStrategy {
    void move(Enemy enemy, Hero hero);
}
```

This way, not even the enemy needs to know how its strategy works when attacking the 
unsuspecting hero:

```
public abstract class Enemy {
  public void attack(Hero hero) {
    this.attackStrategy.attack(this, hero);
  }
}
```

## State

[Code](https://github.com/arestivo/designpatterns-hero/tree/master/src/main/java/com/aor/state) | [Tests](https://github.com/arestivo/designpatterns-hero/tree/master/src/test/java/com/aor/state)

How heroes can be in different **states**; as if they had multiple personalities. Each 
personality being responsible for the hero's behavior and even for personality changes. 

```
public Hero(Position position) {
    this.position = position;
    this.energy = 10;
    this.state = new NormalState(this);
}
```

## Decorator

[Code](https://github.com/arestivo/designpatterns-hero/tree/master/src/main/java/com/aor/decorator) | [Tests](https://github.com/arestivo/designpatterns-hero/tree/master/src/test/java/com/aor/decorator)

## Adapter

[Code](https://github.com/arestivo/designpatterns-hero/tree/master/src/main/java/com/aor/adapter) | [Tests](https://github.com/arestivo/designpatterns-hero/tree/master/src/test/java/com/aor/adapter)
