# ratemit
微服务常见的一个措施就是限流，下面主要整理一下常用的限流算法以及code。目前大抵算法分两类

1. 常规桶类算法(令牌桶和漏桶)，核心思想就是三个核心变量，当前桶最大容量、固定时间内可以补充的token数、上次补充token时间。流程如下：






具体详见Eureka、guava 、Resilience4j、dubbo限流。

其中需要注意的两点

a、 桶的预热，就是没出桶是就有全部token还是怎么慢慢填充，具体详见guava 

b、 guava属于预拿的，比如你可以先预拿1000个，后面的需要很长时间才能补充

c、 Resilience4j不提供tryAcquire，只能一个一个的拿

2. 基于滑动窗口，核心思想就是内置一个数组，比如1秒10个，则划分长度为10的数组，每个窗口有一个起始毫秒数，通过窗口滑动的方式记录。目前看到三种算法实现

a、阿里的sentinel(LeapArray)




b、springcloud hystricx旧版本(HystrixRollingNumber)




c、 rxjava time  window()

需要注意的是：

1. hystricx后期已经拥抱rxjava ，之前的HystrixRollingNumber已经被废弃了
