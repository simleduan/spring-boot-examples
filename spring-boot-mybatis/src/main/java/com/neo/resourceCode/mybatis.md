# mybatis一级缓存
## 什么是mybatis一级缓存
mybatis在执行一次查询或更新后，就会将这个语句缓存起来，当再次执行相同的sql时，就从缓存中获取，不再执行相同的语句
## mybatis一级缓存失效情况
mybatis一级缓存是sqlSession级别的缓存

失效情况：
1. 