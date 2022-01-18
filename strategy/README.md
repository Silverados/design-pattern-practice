# 策略模式
## 描述
策略模式允许在运行时选择最适合的算法。

## 案例
英雄联盟里有一些英雄有变身技能，这就意味着需要实现两套技能，技能也可以看成是一种策略。这里我们以豹女为案例。

在人形态，豹女的q丢出标枪，w是放一个夹子，e是回血；豹形态，q撕咬，w跳跃，e爪击。

首先定义我们的策略接口：
```java
public interface Strategy {
    String Q();
    String W();
    String E();
}
```

首先是具体的策略实现，人形态：
```java
public class HumanStrategy implements Strategy{
    @Override
    public String Q() {
        return "Human: throws a spiked javelin";
    }

    @Override
    public String W() {
        return "Human: lays a trap";
    }

    @Override
    public String E() {
        return "Human: heal";
    }
}
```

豹形态：
```java
public class CougarStrategy implements Strategy{
    @Override
    public String Q() {
        return "cougar: take down";
    }

    @Override
    public String W() {
        return "cougar: pounce";
    }

    @Override
    public String E() {
        return "cougar: swipe";
    }
}
```