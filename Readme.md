#异步多线程断点下载
###这个是看着http://blog.csdn.net/wwj_748/article/details/20146869博客来的，感谢博主。
---

##FileDownloader
> * 初始化的时候， threadNum 表示了将会新建来下载的线程数
> * 最简单的方式是  即可开启多线程异步下载


```java
	
new FileDownloader(getApplicationContext(), path, saveDir, 3);

```
###未来目标
将多余的代码和布局删除，整合得更加方便。


#边下边放，在线缓冲听音乐
---
一个很简单的例子，没有复杂的功能

> * 直接实例化一个player之后，提供歌曲的连接，提供了快进方法


```java
	 
player = new Player(musicProgress); //提供可以快进的进度条
player.playUrl();提供URI

```

###未来目标
将下载的过程设置成多线程的。