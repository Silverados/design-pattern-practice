# 建造者模式
## 描述
将对象的构造和表现分离，使得相同的构造过程可以创建不同的对象。

## 案例
在开始一盘游戏时，我们会选择英雄，召唤师技能，天赋。

首先我们枚举几种英雄：
```java
public enum Hero {
    EZ,
    JS,
    LuLu,
}
```

几种召唤师技能：
```java
public enum Skill {
    FLASH,
    TP,
    HEAL,
}
```

然后创建玩家：

```java
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Player {
    private Hero hero;
    private Skill skill;
    private int talent;

    public Player(Builder builder) {
        hero = builder.hero;
        skill = builder.skill;
        talent = builder.talent;
    }

    public static class Builder {
        private Hero hero;
        private Skill skill;
        private int talent;

        public Builder() {
        }

        public Builder hero(Hero hero) {
            this.hero = hero;
            return this;
        }

        public Builder skill(Skill skill) {
            this.skill = skill;
            return this;
        }

        public Builder talent(int talent) {
            this.talent = talent;
            return this;
        }

        public Player build() {
            return new Player(this);
        }
    }
}

```

创建时使用Builder进行创建：
```java
public class App {
    public static void main(String[] args) {
        var player = new Player.Builder().hero(Hero.EZ)
                .skill(Skill.FLASH)
                .build();
        System.out.println(player);

        player = new Player.Builder().hero(Hero.JS)
                .talent(1)
                .build();
        System.out.println(player);
    }
}

```

控制台输出：
```shell
Player(hero=EZ, skill=FLASH, talent=0)
Player(hero=JS, skill=null, talent=1)
```

这里需要值得一提的是如果使用lombok可以省掉建造者模式的代码。
```java
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class LPlayer {
    private Hero hero;
    private Skill skill;
    private int talent;
}
```

在使用上变为：
```java
public class App {
    public static void main(String[] args) {
        var player2 = new LPlayer.LPlayerBuilder().hero(Hero.JS)
                .skill(Skill.FLASH)
                .talent(1)
                .build();
        System.out.println(player2);
    }
}
```

可以得到输出：
```shell
LPlayer(hero=JS, skill=FLASH, talent=1)
```