# 原型模式
## 描述
创建一个对象的副本，根据需要去修改它。不会改变原来的对象。

## 案例
英雄联盟中有个角色叫萨科（小丑），他的大招就是创建一个复制体，这个复制体有同样的血量，蓝量，但是造成的伤害会比较低, 这里我们简化为攻击力。

首先我们定义这个对象:
```java
import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Shaco implements Cloneable{
    private String name;
    private double hp;
    private double mana;
    private double attack;

    @Override
    public Shaco clone() {
        try {
            Shaco clone = (Shaco) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            clone.name = "clone->" + name;
            clone.attack = clone.attack / 2;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

```
这里实现了clone方法和Cloneable接口，将创建的新对象攻击力设置为原本的一半。

```java
public class App {
    public static void main(String[] args) {
        Shaco shaco = new Shaco("Shaco", 1000, 200, 100);
        System.out.println(shaco);

        Shaco clone = shaco.clone();
        System.out.println("After clone:");
        System.out.println(shaco);
        System.out.println(clone);
    }
}

```

输出：
```shell
Shaco(name=Shaco, hp=1000.0, mana=200.0, attack=100.0)
After clone:
Shaco(name=Shaco, hp=1000.0, mana=200.0, attack=100.0)
Shaco(name=clone->Shaco, hp=1000.0, mana=200.0, attack=50.0)
```