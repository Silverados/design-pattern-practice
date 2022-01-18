# 工厂模式
## 描述
提供一个名为"工厂"的类中的静态方法，使用该方法创建对象，让调用方只需要关注需要创建的对象类型，忽略具体的过程。

## 案例
在英雄联盟或者王者荣耀中，5名玩家选择英雄和其他5名玩家对战。考虑一场战斗中，我们需要创建10个英雄。如果使用工厂模式我们会这么做：

首先定义一个基类：
```java
public abstract class Hero {
    public abstract String description();
}
```

然后是我们具体的英雄类型，这里用EZ, JS, LuLu为例：
```java
public class EZ extends Hero{
    @Override
    public String description() {
        return "Hello EZ!";
    }
}

public class JS extends Hero{
    @Override
    public String description() {
        return "Hello JS!";
    }
}

public class LuLu extends Hero{
    @Override
    public String description() {
        return "Hello, LuLu!";
    }
}
```

用一个枚举来指定这些类型,并且提供创建方法：
```java
import lombok.AllArgsConstructor;

import java.util.function.Supplier;
@AllArgsConstructor
public enum HeroType {
    EZ(EZ::new),
    JS(JS::new),
    LULU(LuLu::new);

    private Supplier<Hero> constructor;

    public Supplier<Hero> getConstructor() {
        return constructor;
    }
}
```

然后是我们的工厂：
```java
public class HeroFactory {
    public static Hero newHero(HeroType heroType) {
        return heroType.getConstructor().get();
    }
}
```

在调用方我们只需要关注需要创建什么英雄：
```java
public class App {
    public static void main(String[] args) {
        var hero = HeroFactory.newHero(HeroType.EZ);
        System.out.println(hero.description());

        hero = HeroFactory.newHero(HeroType.JS);
        System.out.println(hero.description());
    }
}
```

控制台输出：
```shell
Hello EZ!
Hello JS!
```