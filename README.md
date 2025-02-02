本项目分为三个部分，分别为PhigrosRpc和PhigrosLibrary和PhigrosLibrary-Cpp。

PhigrosLibrary是Java实现的Phigros云存档解析库。

PhigrosLibrary-Cpp是C++实现的Phigros云存档解析库。

PhigrosRpc是利用http对PhigrosLibrary的封装。

本项目应使用Java 17以上和C++ 11以上

**注：此项目为逆向成果，未非调用任何第三方接口。**

**注：严禁大规模查分对鸽游服务器进行DDOS。**

**注：个人项目，未学习法律，目的为了让大家可以开发自己的查分机器人。**

# 更新资源

1. [头像id](https://github.com/7aGiven/PhigrosLibrary/blob/master/avatar.txt)
2. [收藏品id](https://github.com/7aGiven/PhigrosLibrary/blob/master/collection.csv)
3. 定数表和曲绘请使用项目[Phigros_Resource](https://github.com/7aGiven/Phigros_Resource/)从apk文件中提取(apk可从616.sb下载)

**注：3个文件都在项目根目录下，查看修改时间判断版本。**

# 目录
- [其他语言的实现](#其他语言实现查分)
- [使用本项目的优秀项目](#使用本项目的优秀项目)
- [PhigrosRpc文档](https://github.com/7aGiven/PhigrosLibrary/blob/master/README-PhigrosRpc.md)
- [PhigrosLibrary文档](https://github.com/7aGiven/PhigrosLibrary/blob/master/README-PhigrosLibrary.md)
- [Phigros曲目更新](#phigros-曲目更新) 
- [淘宝店](#phigros-淘宝)
- [Phigros QQ群](#phigros-qq群)

# 其他语言实现查分
### python查分
位于py文件夹，由python原生实现，未调用PhigrosRpc
### C++查分
位于cpp文件夹，由C++原生实现，未调用PhigrosRpc
### Nodejs查分
位于nodejs文件夹，由nodejs通过nodejs C++ addon调用C++查分实现

# 使用本项目的优秀项目
[phi-plugin](https://github.com/catrong/phi-plugin)
云崽bot插件，可查分等非常多的有关Phigros的功能

UI精美，使用nodejs重构本项目的查分，使用本项目nodejs C++ addon的re8
## Phigros 曲目更新
[Phigros_Resource](https://github.com/7aGiven/Phigros_Resource/)可从apk文件中提取定数表(apk可从616.sb下载)

运行以下代码将会在运行目录生成difficulty.csv
```python
pip install UnityPy
python3 gameInformation.py Phigros.apk
```
将生成的difficulty.csv替换项目内的difficulty.csv即可
## Phigros 淘宝店
如果你希望修改存档，但是不会编译和使用项目，怎么办？

https://h5.m.taobao.com/awp/core/detail.htm?ft=t&id=738050220389

点进淘宝店花点小钱让作者帮你改存档。
## Phigros QQ群
加入 282781491 闲聊
