# 延迟加载 #

在对应的四种表关系中：一对多，多对一，一对一，多对多
  一对多，多对多：通常情况下我们都是采用延迟加载。
  多对一，一对一：通常情况下我们都是采用立即加载
  
```xml
    <settings>
        <setting name="lazyLoadingEnabled" value="true"/>
        <setting name="aggressiveLazyLoading" value="false"/>
    </settings>

```
