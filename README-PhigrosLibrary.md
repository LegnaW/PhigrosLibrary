- [PhigrosLibrary简单应用](#phigroslibrary-简单应用)
- [PhigrosLibrary高级应用](#phigroslibrary的高级应用)
# PhigrosLibrary

基于Phigros 3.0.0

### 功能

对Phigros云存档的序列化和反序列化

封装并优化了常用函数(B19,BestN,目标ACC)

### Java开发者使用PhigrosLibrary

必须以JDK17开发

方法1：

下载项目源码

复制PhigrosLibrary目录到您的项目根目录

在您的项目根目录的settings.gradle添加一行

`include 'PhigrosLibrary'`

在需要引用PhigrosLibrary的项目的build.gradle里修改dependencies

```groovy
dependencies {
    implementation project(':PhigrosLibrary')
}
```

方法2：

下载Release内PhigrosLibrary.jar文件

放入您的项目根目录的libs文件夹下

在需要引用PhigrosLibrary的项目的build.gradle里修改 dependencies
```groovy
dependencies {
    implementation files('libs/PhigrosLibrary.jar')
}
```

## PhigrosLibrary 简单应用

以下代码获取了Phigros账户的B19信息和推分信息。

PhigrosUser.readInfo为读取定数信息，本类库不保存定数信息。

[定数表](https://raw.githubusercontent.com/7aGiven/PhigrosLibrary/master/difficulty.csv)

PhigrosUser对象执行update方法可以更新存档URL，否则会输出旧的B19图
```java
class Main {
    public static void main(String[] args) {
        PhigrosUser.readInfo(bufferReader);
        var user = new PhigrosUser(sessionToken);
        Summary summary = user.update();
        SongLevel[] songLevels = user.getB19();
        SongExpect[] accAll = user.getExpects(); //获取所有可推分歌曲的acc和目标acc
        SongExpect acc = user.getExpect("青芽.茶鸣拾贰律");
    }
}
```
Summary结构
```java
public final class Summary {
    public byte saveVersion;       //存档版本
    public short challengeModeRank;//课题分
    public float rankingScore;     //rks
    public byte gameVersion;       //客户端版本号
    public String avatar;          //头像
    public short[] cleared = new short[4];  //完成曲目数量
    public short[] fullCombo = new short[4];//FC曲目数量
    public short[] phi = new short[4];      //AP曲目数量
}
```
Level结构
```java
public enum Level {
    EZ,HD,IN,AT
}
```
SongLevel的结构是这样的。
```java
public class SongLevel implements Comparable<SongLevel>{
    public String id;  //曲目Id
    public Level level;
    public int s;      // 分数
    public float a;    //ACC
    public boolean c;  //FC
    public float difficulty;// 定数
    public float rks;  // 单曲rks
    @Override
    public int compareTo(SongLevel songLevel) {
        return Double.compare(songLevel.rks, rks);
    }
}
```
SongExpect的结构是这样的。
```java
public class SongExpect implements Comparable<SongExpect> {
    public String id;   //曲目Id
    public Level level;
    public float acc;
    public float expect;//目标ACC
    @Override
    public int compareTo(SongExpect songExpect) {
        return Float.compare(expect - acc, songExpect.expect - songExpect.acc);
    }
}
```

### PhigrosUser的public方法
```java
public class PhigrosUser {
    public String session;
    public URI saveUrl;
    public PhigrosUser(String session);//使用SessionToken初始化
    public PhigrosUser(URI saveUrl);//使用saveUrl初始化
    public static void readInfo(BufferedReader reader);//读取定数表
    public String getPlayerId();//获取玩家昵称
    public Summary update();//使用SessionToken更新saveUrl，并返回Summary
    public SongLevel[] getB19();//获取Best Phi和Best 19
    public SongLevel[] getBestN(int num);//获取Best Phi和Best N
    public SongExpect[] getExpect(String id);//获取曲目的所有等级的ACC和目标ACC
    public SongExpect[] getExpects();//获取所有可推分歌曲的ACC和目标ACC
    public <T extends GameExtend> T get(Class<T> clazz);//获取类为clazz的存档(详情高级应用)
    public <T extends GameExtend> void modify(Class<T> clazz, ModifyStrategy<T> strategy);//修改存档
    public void downloadSave(Path path);//备份存档到path
    public void uploadSave(Path path);  //从path恢复存档
}
```

## PhigrosLibrary的高级应用

注意：如果只想查询B19和ACC，请使用快速使用的例子，PhigrosUser内的对这两个常用情景有优化。

Phigros云存档包含5部分内容和Summary

gameRecord, gameKey, gameProgress, user, settings和Summary

其中gameRecord和gameKey为字典结构，其他四个是普通的结构。

获取这5个对象的方法：
```java
class Main {
    public static void main(String[] args) {
        PhigrosUser.readInfo(bufferReader);
        var user = new PhigrosUser(sessionToken);
        Summary summary = user.update();
        user.get(GameRecord.class);
        user.get(GameKey.class);
        user.get(GameProgress.class);
        user.get(GameUser.class);
        user.get(GameSettings.class);
    }
}
```
Summary结构
```java
public final class Summary {
    public Instant updatedAt;      //存档更新时间
    public byte saveVersion;       //存档版本
    public short challengeModeRank;//课题分
    public float rankingScore;     //rks
    public byte gameVersion;       //客户端版本号
    public String avatar;          //头像
    public short[] cleared = new short[4];  //完成曲目数量
    public short[] fullCombo = new short[4];//FC曲目数量
    public short[] phi = new short[4];      //AP曲目数量
}
```
GameSettings结构
```java
public class GameSettings implements SaveModule {
    public boolean chordSupport;     //多押辅助
    public boolean fcAPIndicator;    //开启FC/AP指示器
    public boolean enableHitSound;   //开启打击音效
    public boolean lowResolutionMode;//低分辨率模式
    public String deviceName;        //设备名
    public float bright;             //背景亮度
    public float musicVolume;        //音乐音量
    public float effectVolume;       //界面音效音量
    public float hitSoundVolume;     //打击音效音量
    public float soundOffset;        //铺面延迟
    public float noteScale;          //按键缩放
}
```
GameUser结构
```java
public class GameUser implements SaveModule {
    public boolean showPlayerId;//右上角展示用户id
    public String selfIntro;    //自我介绍
    public String avatar;       //头像
    public String background;   //背景曲绘
}
```
GameProgress结构
```java
class GameProgress implements SaveModule {
    public boolean isFirstRun;                //首次运行
    public boolean legacyChapterFinished;     //过去的章节已完成
    public boolean alreadyShowCollectionTip;  //已展示收藏品Tip
    public boolean alreadyShowAutoUnlockINTip;//已展示自动解锁IN Tip
    public String completed;          //剧情完成(显示全部歌曲和课题模式入口)
    public int songUpdateInfo;        //？？？
    public short challengeModeRank;   //课题分
    public short[] money = new short[5];//data货币
    public byte unlockFlagOfSpasmodic;//痉挛解锁
    public byte unlockFlagOfIgallta;  //Igallta解锁
    public byte unlockFlagOfRrharil;  //Rrhar'il解锁
    public byte flagOfSongRecordKey;  //IN达到S(倒霉蛋,船,Shadow,心之所向,inferior,DESTRUCTION 3,2,1,Distorted Fate)
    public byte randomVersionUnlocked;//Random切片解锁
    public boolean chapter8UnlockBegin;      //第八章入场
    public boolean chapter8UnlockSecondPhase;//第八章第二阶段
    public boolean chapter8Passed;           //第八章通过
    public byte chapter8SongUnlocked;        //第八章各曲目解锁
}
```
对于GameRecord的结构(Map)
```java
public class GameRecord extends LinkedHashMap<String, LevelRecord[]> implements SaveModule {}
public class LevelRecord {
    public boolean c;//Full Combo
    public int s;    //分数
    public float a;  //ACC
}
```
对于GameKey的结构(Map)
```java
public class GameKey extends LinkedHashMap<String, GameKeyValue> implements SaveModule {
    public byte lanotaReadKeys;    //读取Lanota收藏品(解锁倒霉蛋和船的AT)
    public boolean camelliaReadKey;//读取极星卫破译收藏品(解锁S.A.T.E.L.L.I.T.E.的AT)
}
public class GameKeyValue {
    public byte readCollection; //读收藏品
    public boolean unlockSingle;//解锁单曲
    public byte collection;     //收藏品
    public boolean illustration;//曲绘
    public boolean avatar;      //头像
}
```
修改存档请使用
`<T extend SaveModule> PhigrosUser.modify(Class<T> clazz, ModifyStrategy<T> strategy)`
```java
@FunctionalInterface
interface ModifyStrategy<T extends SaveModule> {
    T apply(T data) throws IOException;
}
```
修改存档示例

Phigros使用Summary的异同来判断是否给出使用云端和使用本地界面

PhigrosUser.modify强制修改Summary中的课题分为003(正常游玩不可能获得)

这样修改完就无需清除游戏数据来云存档覆盖本地。
```java
class Main {
    public static void main(String[] args) {
        var user = new PhigrosUser(sessionToken);
        user.update();
        String songId = "青芽.茶鸣拾贰律";
        int level = Level.IN.ordinal();
        int s = 1000000;
        float a = 100f;
        boolean c = true;
        user.modify(GameRecord.class, gameRecord -> {
            LevelRecord[] levelRecords = gameRecord.get(songId);
            if (levelRecords != null) {
                if (levelRecords[level] != null) {
                    levelRecords[level].s = s;
                    levelRecords[level].a = a;
                    levelRecords[level].c = c;
                } else
                    throw new RuntimeException("未游玩曲目该难度。");
            } else
                throw new RuntimeException("未游玩该曲目。");
        });
    }
}
```
