## 学习笔记

### HashMap
+ HashMap无序
+ HashMap默认的load factor是0.75
+ 当HashMap的load factor达到设定值时，HashMap会扩充HashTable的大小并进行ReHash，HashTable的大小会被扩充为原来的两倍
+ 当key comparable时，HashMap会使用comparison order来break ties
+ HashMap是非同步的，非线程安全的，会产生死锁的问题，需要自己增加同步处理，需要线程安全可以使用ConcurrentHashMap
#### HashMap和HashTable的不同
|不同点|HashMap|HashTable|备注|
|:-:|:-:|:-:|:-:|
|产生时间|JDK1.2|Java产生|
|继承父类|AbstractMap|Dictionary(已被废弃)|都实现了map/cloneable/serializable三个接口| 
|对Null key和Null value的支持|key和value均支持为空|key和value均不支持为空|受此影响，不能使用get()方法判断HashMap中是否存在键，因为可能该键对应的值就为null，而应该使用containsKey()方法来判断|
|线程安全不同|线程不安全|线程安全|
|遍历的内部实现|fail-fast迭代器，当有其他线程改变了结构时，会抛出ConcurrentModificationException，itreater自己的remove方法除外|1.8之后也是fail-fast|ConcurrentModificationException是无法被用来做正式的线程安全判断的|  
|初始容量和每次扩充的大小|初始化大小为16，之后每次扩充，容量变为原来的两倍|默认的大小为11，之后每次变成原来的2n+1|
|计算Hash值的方法|做取模运算时不做除法，只做位运算，又对hash值进行了一些运算来打散数据|直接使用对象的HashCode,是由JDK根据对象的地址或者字符串或者数字算出来的int类型的数值，然后再使用除留余数来获取最终的位置|由于HashTable需要使用除法运算，除法运算效率比较低，因此比较耗时|