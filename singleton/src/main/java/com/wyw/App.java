package com.wyw;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        var now = System.currentTimeMillis();
        int times = 20000;
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(times);
        for (int i = 0; i < times; i++) {
            executorService.execute(() -> {
//                var instance = SingletonThreadSafe.getInstance();
                var instance = SingletonDoubleCheckLocking.getInstance();
                map.put(instance.toString(), map.getOrDefault(instance.toString(), 0) + 1);
            });
        }
        map.entrySet().forEach(System.out::println);
        System.out.println(System.currentTimeMillis() - now);
        executorService.shutdown();
    }
}
