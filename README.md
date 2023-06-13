## 真香警告：即使不用云音乐听曲，也请务必收藏好该库！

## 公告：

我们就本项目 "被卖课" 一事，在掘金发表一期专访 [《开源项目被人拿去做课程卖了 1000 多万是什么体验》](https://juejin.im/post/5ecb4950518825431a669897)

本项目系我为方便开发者们 **无痛理解 Google 开源 Jetpack MVVM 中每个架构组件的 存在缘由、职责边界**，而 **精心设计的高频应用场景**，

与此同时，本项目是作为 [《重学安卓》](https://xiaozhuanlan.com/topic/6017825943)专栏 Jetpack MVVM 系列文章 “配套项目” 而存在，**文章内容和项目代码设计均涉及本人对 Jetpack MVVM 独家理解，本人对此享有著作权**。

任何组织或个人，未经与作者本人沟通，不得将本项目代码设计和本人对 Jetpack MVVM 独家理解用于 "**打包贩卖、引流、出书 和 卖课**" 等商业用途。

&nbsp;

### 由来

Jetpack-MusicPlayer 是一款基于 Jetpack MVVM 架构音乐播放控制组件，它是因 [“Jetpack-MVVM-Best-Practice”](https://github.com/KunMinX/Jetpack-MVVM-Best-Practice) 这项目需求而存在。

最初寻遍 GitHub 也未找到合适开源库，于是决定另起炉灶，自己编写 **高度解耦、轻松配置、可通过 Maven 仓库远程依赖** 的真正第三方库。

Jetpack-MusicPlayer 使用十分简单，依托于 设计模式原则 及 Java 泛型特性，使用者无需知道内部实现细节，**仅通过继承** Album、Music、Artist **基类 即可完成 业务实体类 定制和扩展**。

此外，在不设置自定义配置情况下，Jetpack-MusicPlayer 最少只需 **一行代码即可运行起来**。

&nbsp;

|                          PureMusic                           |                      LiveData Dispatch                       |                       PlayMode Switch                        |
| :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: |
| ![](https://upload-images.jianshu.io/upload_images/57036-eeaa9ea7399d90d5.gif) | ![](https://upload-images.jianshu.io/upload_images/57036-a9b1831b428993b0.gif) | ![](https://upload-images.jianshu.io/upload_images/57036-466fe782f7170a44.gif) |


&nbsp;

### 目标

Jetpack-MusicPlayer 目标是：**一行代码即可接入 音乐播放控制组件**。

除一键接入省去 99% 繁杂重复工作外，你还可从该项目获得内容包括：

1. 整洁代码风格 和 标准资源命名规范。
2. **LiveData 架构组件 编写第三方库 最佳实践**：通过 "唯一可信源" 结构实现全应用范围内 播放状态可靠一致分发，规避 **软件工程背景下** 滋生各种 **不可预期错误**。
3. 优秀代码分层和封装思想，在不做任何个性化配置情况下，一行代码即可接入。
4. 主体工程基于前沿软件工程安全 JetPack MVVM 架构。
5. AndroidX 和 Material Design 2 全面使用。
6. ConstraintLayout 约束布局最佳实践。
7. 绝不使用 Dagger，绝不使用奇技淫巧、编写艰深晦涩代码。

&nbsp;

如你正在思考 [**如何为项目挑选合适的架构**](https://juejin.cn/post/7106042518457810952)，这项目值得你参考！

&nbsp;

# Download

[![](https://upload-images.jianshu.io/upload_images/57036-f9dbd7810d38ae95.png)](https://www.coolapk.com/apk/247826) [![](https://upload-images.jianshu.io/upload_images/57036-6cf24d0c9efe8362.png)](https://www.coolapk.com/apk/247826)

&nbsp;

### 简单使用：

### 1.初始化装载数据

1.在 build.gradle 中添加依赖。

```groovy
implementation 'com.kunminx.player:player:4.1.0'
```

提示：鉴于 Jcenter 关闭，我们已将仓库迁移至 Maven Central，请自行在根目录 build.gradle 添加 `mavenCentral()`。

2.依据默认专辑实体类 `DefaultAlbum` 结构准备一串数据。

```java
// DefaultAlbum 包含 DefaultMusic 和 DefaultArtist 两个子类：
// 三者的字段可详见 BaseAlbumItem、BaseMusicItem 和 BaseArtistItem。
```

```java
//创建专辑实例
DefaultAlbum album = new DefaultAlbum("001", "Cute", "BenSound");

//为专辑添加作者
List<DefaultArtist> artists = new ArrayList<>();
artists.addArtists(new DefaultArtist("Linda"));
album.setArtist(artists);

//为专辑添加封面
album.setCoverImg("https://images.io/055ef18.png");

//创建音乐实例
List<DefaultMusic> musics = new ArrayList<>();

DefaultMusic music = new DefaultMusic("001", "Tomorrow", artists);
music.setCoverImg("https://images.io/055ef19.png");
music.setUrl("https://bensound.com/sunny.mp3");
musics.add(music);

DefaultMusic music1 = new DefaultMusic("002", "Sunny", artists);
music1.setCoverImg("https://images.io/055ef20.png");
music1.setUrl("https://bensound.com/cute.mp3");
musics.add(music1);

//将音乐添加到专辑
album.setMusics(musics);

```

3.在 Application 中初始化 多媒体播放控制组件。

```java
DefaultPlayerManager.getInstance().init(this);
```

4.在得到数据后，最少只需一行代码 即可完成数据的装载。

```java
//一行代码完成数据的初始化。
DefaultPlayerManager.getInstance().loadAlbum(album);
```



### 2.播放控制

5.在 “视图控制器” 中发送请求，并接收来自 “唯一可信源” 统一分发结果响应。

5.1.在 “视图控制器” 任意处发送请求，例如此处请求 “播放下一首”

```java
DefaultPlayerManager.getInstance().playNext();
```

5.2.在 “视图控制器” 订阅通知处，收听来自 “唯一可信源” 推送结果响应。

5.2.1.例如此处响应 “播放按钮状态” 推送。

```java
DefaultPlayerManager.getInstance().pauseLiveData().observe(this, aBoolean -> {
    mPlayerViewModel.isPlaying.set(!aBoolean);
});
```

5.2.2.此处响应 “当前歌曲详细信息” 推送

```java
DefaultPlayerManager.getInstance().changeMusicLiveData().observe(this, changeMusic -> {
    mPlayerViewModel.title.set(changeMusic.getTitle());
    mPlayerViewModel.artist.set(changeMusic.getSummary());
    mPlayerViewModel.coverImg.set(changeMusic.getImg());
});
```

5.2.3.此处响应 “当前歌曲播放进度” 推送

```java
DefaultPlayerManager.getInstance().playingMusicLiveData().observe(this, playingMusic -> {
    mPlayerViewModel.maxSeekDuration.set(playingMusic.getDuration());
    mPlayerViewModel.currentSeekPosition.set(playingMusic.getPlayerPosition());
});
```

注意：如使用 JSON，请在 ProGuard Rules 中为该实体类目录配置混淆白名单：

```java
-keep class com.kunminx.player.bean.** {*;}
```

&nbsp;

个性化配置详见 [Wiki](https://github.com/KunMinX/Jetpack-MusicPlayer/wiki/%E4%B8%AA%E6%80%A7%E5%8C%96%E9%85%8D%E7%BD%AE)



# Thanks to

[material-components-android](https://github.com/material-components/material-components-android)

[AndroidX](https://developer.android.google.cn/jetpack/androidx)

[HDMediaPlayer](https://github.com/yinhaide/HDMediaPlayer)

[AndroidVideoCache](https://github.com/danikula/AndroidVideoCache)

&nbsp;

# My Pages

Email：[kunminx@gmail.com](mailto:kunminx@gmail.com)

Juejin：[KunMinX 在掘金](https://juejin.im/user/58ab0de9ac502e006975d757/posts)

&nbsp;

# License

```
Copyright 2018-present KunMinX

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```