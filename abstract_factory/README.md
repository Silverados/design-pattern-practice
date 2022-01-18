# 抽象工厂模式
## 描述
工厂的工厂。用于创建一系列相关的对象。

## 案例
在英雄联盟中，对战双方分为红蓝方，对应的有小兵(soldier)、防御塔(turret)、水晶(inhibitor)。

首先定义3种类型：
```java
public interface Soldier {
    String description();
}

public interface Turret {
    String description();
}

public interface Inhibitor {
    String description();
}
```

然后定义对应的红蓝类型：
```java
public class BlueSoldier implements Soldier{
    @Override
    public String description() {
        return "Blue soldier!";
    }
}

public class BlueTurret implements Turret{
    @Override
    public String description() {
        return "Blue turret";
    }
}

public class BlueInhibitor implements Inhibitor{
    @Override
    public String description() {
        return "Blue inhibitor";
    }
}

public class RedSoldier implements Soldier{
    @Override
    public String description() {
        return "Red soldier!";
    }
}

public class RedTurret implements Turret{
    @Override
    public String description() {
        return "Red turret";
    }
}

public class RedInhibitor implements Inhibitor{
    @Override
    public String description() {
        return "Red inhibitor";
    }
}
```

然后定义一个工厂基类：
```java
public interface TeamFactory {
    Soldier createSoldier();
    Turret createTurret();
    Inhibitor createInhibitor();
}

```

接下来定义红方工厂，蓝方工厂：
```java
public class RedTeamFactory implements TeamFactory {
    @Override
    public Soldier createSoldier() {
        return new RedSoldier();
    }

    @Override
    public Turret createTurret() {
        return new RedTurret();
    }

    @Override
    public Inhibitor createInhibitor() {
        return new RedInhibitor();
    }
}

public class BlueTeamFactory implements TeamFactory {
    @Override
    public Soldier createSoldier() {
        return new BlueSoldier();
    }

    @Override
    public Turret createTurret() {
        return new BlueTurret();
    }

    @Override
    public Inhibitor createInhibitor() {
        return new BlueInhibitor();
    }
}

```

最后就是我们工厂的工厂, FactoryMarker负责创建一个工厂：
```java
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Team {
    private Soldier soldier;
    private Inhibitor inhibitor;
    private Turret turret;

    public static class FactoryMaker {

        public static TeamFactory createFactory(TeamType teamType) {
            return switch (teamType) {
                case BLUE -> new BlueTeamFactory();
                case RED -> new RedTeamFactory();
                default -> throw new IllegalArgumentException("teamType not exists");
            };
        }
    }

}
```

在使用上：
```java
public class App {
    private static Team team = new Team();

    public static void main(String[] args) {
        createTeam(TeamType.BLUE);
        System.out.println(team.getSoldier().description());
        System.out.println(team.getTurret().description());
        System.out.println(team.getInhibitor().description());

        createTeam(TeamType.RED);
        System.out.println(team.getSoldier().description());
        System.out.println(team.getTurret().description());
        System.out.println(team.getInhibitor().description());
    }

    public static Team createTeam(TeamType teamType) {
        TeamFactory factory = Team.FactoryMaker.createFactory(teamType);
        team.setSoldier(factory.createSoldier());
        team.setInhibitor(factory.createInhibitor());
        team.setTurret(factory.createTurret());
        return team;
    }
}
```

控制台输出：
```shell
Blue soldier!
Blue turret
Blue inhibitor
Red soldier!
Red turret
Red inhibitor
```