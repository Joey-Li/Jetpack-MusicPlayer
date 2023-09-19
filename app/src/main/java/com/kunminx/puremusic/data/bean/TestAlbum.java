/*
 * Copyright 2018-present KunMinX
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kunminx.puremusic.data.bean;

import com.kunminx.player.bean.base.BaseAlbumItem;
import com.kunminx.player.bean.base.BaseArtistItem;
import com.kunminx.player.bean.base.BaseMusicItem;

import java.util.List;

/**
 * Create by KunMinX at 19/10/31
 */
public class TestAlbum extends BaseAlbumItem<TestAlbum.TestMusic, TestAlbum.TestArtist> {

  private String albumMid;
  public TestAlbum(String albumId, String title, String summary, TestArtist artist, String coverImg, List<TestMusic> musics) {
    super(albumId, title, summary, artist, coverImg, musics);
  }

  public String getAlbumMid() {
    return albumMid;
  }

  public static class TestMusic extends BaseMusicItem<TestArtist> {

    private String songMid;
    public TestMusic(String musicId, String coverImg, String url, String title, TestArtist artist) {
      super(musicId, coverImg, url, title, artist);
    }

    public String getSongMid() {
      return songMid;
    }
  }

  public static class TestArtist extends BaseArtistItem {

    private String birthday;
    public TestArtist(String name) {
      super(name);
    }

    public String getBirthday() {
      return birthday;
    }
  }
}

