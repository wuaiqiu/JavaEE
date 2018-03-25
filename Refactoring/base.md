# Base

**一.六大原则**

```
单一职责原则
每个类只实现一种功能

依赖倒置原则
类应该继承于抽象类

开闭原则
避免对原来的类进行修改

迪米特原则
降低类中对象之间的依赖

接口隔离原则
一个接口只实现一种功能

里氏代换原则
任何基类出现的地方，子类都可以替换
```

<br>

**二.行为型(用于不同类之间的通信)**

```
责任链模式:不同等级的请求形成一条链,高等级依次向低等级传递消息

命令模式:不同命令处理不同事件（多个命令实现类,一个命令调用者）
策略模式:同一件事情不同的处理方法(同一个问题的多个处理方法,一个策略调用者)

备忘录模式:保存一个对象的状态，并可以恢复
状态模式:多个不同的状态类改变唯一一个对象的状态
观察者模式:某个对象的状态被改变，通知其他对象

中介者模式:处理两个不同类的通信
迭代器模式:处理底层的迭代功能
模板模式:子类只能实现抽象类的抽象方法,而抽象类来控制程序流程
访问者模式:通过第三方类同一实现某一接口实现的子类
```

<br>

**三.创建型(用于创建对象)**

```
单例模式:整个程序只提供一个实例对象
原型模式:利用一次实例化多次克隆对象来避免对象多次实例化
建造者模式:将不同类别的类组成不同功能的复杂类
工厂模式:一个可以创建不同对象的类
抽象工厂模式:一个可以创建不同工厂的类
```

<br>

**四.结构型(用于搭建程序的整体架构)**

```
适配器模式:借助适配器类将让两个不兼容的类相关联
桥接模式:在一个类中引用另一个类，而不需要继承
组合模式:将同一个类不同实例对象组合并构成树结构

装饰者模式:扩展父类某个方法而不修改父类原有实现
过滤模式:将某个对象经层层过滤类处理
代理模式:代理类将某个类方法添加前置操作与后置操作

享元模式:将工厂模式创建的不同对象保存下来，供下一次使用
外观模式:封装实现过程，只对外提供调用接口
```