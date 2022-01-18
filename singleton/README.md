# 单例模式
## 描述
单例模式全局对于该类只需要创建一个实例对象。

## 案例
单例模式有多种实现。这里不和游戏挂钩，注重的还是模式的实现方式。

我们首推的首先方式是通过枚举：
```java
public enum SingletonEnum {
    INSTANCE
}
```

其次是静态内部类：
```java
public class SingletonInnerClass {

    private SingletonInnerClass() {}

    public SingletonInnerClass getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final SingletonInnerClass INSTANCE = new SingletonInnerClass();
    }
}
```

然后是饿汉式的，就是立即进行初始化的：
```java
public class SingletonEagle {
    private SingletonEagle() {}

    private static final SingletonEagle INSTANCE = new SingletonEagle();

    public static SingletonEagle getInstance() {
        return INSTANCE;
    }
}
```

最后是懒汉式的，延迟初始化的方式。先从简单的不考虑线程安全的代码看起：
```java
public class SingletonThreadSafe {
    private SingletonThreadSafe() {
    }

    private static SingletonThreadSafe instance;

    public static SingletonThreadSafe getInstance() {
        if (instance == null) {
            synchronized (SingletonThreadSafe.class) {
                if (instance == null) {
                    instance = new SingletonThreadSafe();
                }
            }
        }

        return instance;
    }
}

```

接下来，看看我们的测试代码：
```java
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        int times = 10000;
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(times);
        for (int i = 0; i < times; i++) {
            executorService.execute(() -> {
                SingletonThreadUnsafe instance = SingletonThreadUnsafe.getInstance();
                map.put(instance.toString(), map.getOrDefault(instance.toString(), 0) + 1);
            });
        }
        map.entrySet().forEach(System.out::println);
        executorService.shutdown();
    }
}
```

在测试中，可能会输出多种结果，以下是这次测试输出的结果：
```shell
com.wyw.SingletonThreadUnsafe@478b45cc=1
com.wyw.SingletonThreadUnsafe@274612bb=9990
com.wyw.SingletonThreadUnsafe@54ebaa04=1
```

可以看到违背了我们单例模式的原则。但不能否认这种实现方式，这种实现只能用在不会出现线程安全的环境下。
接下来是线程安全的写法, 这种写法使用重量锁来保障线程安全, 这意味着一些性能和时间的损耗：
```java
public class SingletonThreadSafe {
    private SingletonThreadSafe() {
    }

    private static volatile SingletonThreadSafe instance;

    public static SingletonThreadSafe getInstance() {
        if (instance == null) {
            synchronized (SingletonThreadSafe.class) {
                if (instance == null) {
                    instance = new SingletonThreadSafe();
                }
            }
        }

        return instance;
    }
}

```

以下是《Effective Java》提出的一种优化方式：
```java
public class SingletonDoubleCheckLocking {
    private SingletonDoubleCheckLocking() {}

    private static volatile SingletonDoubleCheckLocking instance;

    public static SingletonDoubleCheckLocking getInstance() {
        var result = instance;
        if (result == null) {
            synchronized (SingletonDoubleCheckLocking.class) {
                result = instance;
                if (result == null) {
                    instance = result = new SingletonDoubleCheckLocking();
                }
            }
        }
        return result;
    }
}
```