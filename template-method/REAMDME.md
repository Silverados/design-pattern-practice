# 模板方法
## 描述
可以理解为做一个事情的过程是确定的，但是实现方式可以在子类中定义。

## 案例
开始一把英雄联盟游戏的流程都是这样：选择要玩的模式创建房间 --》 邀请好友 --》 排队 --》 开始

首先定义基础的流程，也就是模板方法的主体：
```java
public abstract class SubtleMethod {

    public abstract void chooseMode();

    public abstract void inviteFriends();

    public void startGame() {
        chooseMode();
        inviteFriends();
        System.out.println("game stated!");
    }
}
```

如果是单排，多排两个实现：
```java
public class SoloQMethod extends SubtleMethod{

    @Override
    public void chooseMode() {
        System.out.println("Choose rank mode!");
    }

    @Override
    public void inviteFriends() {
        System.out.println("Solo queue, so not invited friends!");
    }
}

public class DuoQMethod extends SubtleMethod{
    @Override
    public void chooseMode() {
        System.out.println("Choose rank mode!");
    }

    @Override
    public void inviteFriends() {
        System.out.println("Invite good friends!");
    }
}
```

最后定义一个选择使用方法的主体：
```java
public class Game {
    private SubtleMethod method;

    public Game(SubtleMethod method) {
        this.method = method;
    }

    public void changeMethod(SubtleMethod method) {
        this.method = method;
    }

    public void startGame() {
        method.startGame();
    }
}
```

最后是我们的客户端类：
```java
public class App {
    public static void main(String[] args) {
        Game game = new Game(new SoloQMethod());
        game.startGame();

        game.changeMethod(new DuoQMethod());
        game.startGame();
    }
}
```

输出：
```shell
Choose rank mode!
Solo queue, so not invited friends!
game stated!
Choose rank mode!
Invite good friends!
game stated!
```