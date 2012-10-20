MOD: mod_EasyAIInterface
----

----
    MOD name     : mod_EasyAIInterface
    Author       : bbc_mc (bbc-mc on github)
    publish date : 2012/10/19 alpha
    status       : alpha + still develop

----
**現在開発中のため、以下の内容には開発中の情報が含まれ、不正確な可能性があります。**

## 概要

ゲーム [Minectaft](http://www.mojang.com/) に以下の機能を追加する MOD です。

## 機能

 - AI を簡単に構築する仕組みを追加する
 - AI 構築に利用する Item "チップ"を追加する

## 動作環境・前提

以下の環境が必要です。

  + MC 1.2.5
  + Minecraft Forge (開発環境 3.1.1.171)

## 参考実装
  + 以下の条件を満たすEntity であれば、本仕組みを実装可能です。
    + EntityLiving である（もしくはそれを継承している）
    + AI チップを配置できる inventory を持つ
    + 定期的に EAI_Manager の実行関数をキックできる

  + [YoujoMOD] 1.2.1 を利用した実装を作成しました
    + YoujoMOD 用 AI として実装しています
      + src\minecraft\net\minecraft\src\YoujoAI_EasyAIInterface.java
    + Entity および AIチップ用インベントリとして利用しますが、EasyAIInterface 自体は YoujoMod に依存しません。
    [ソースコード][github_YoujoAI]
    [バイナリ @ 非公式フォーラム トピック][topic]

  + AI チップ動作検証用に、インベントリを持つ無機能 Mob を作成しました
    [ソースコード][github_EAIMobSample]
    [バイナリ @ 非公式フォーラム トピック][topic]

## 使用 ID

開発に伴う AI チップの追加で増加する可能性大です。

+ アイテムID
  + 29001 - 29004
  + 29101 - 29102
  + 29201 - 29206
  + 29301 - 29303
+ ブロックID
  + なし

## 導入方法

 - mod_EasyAIInterface.zip を、あなたの mods フォルダへ投入

## YoujoMod 用 AI 導入方法

 - YoujoAI_EasyAIInterface.class を、あなたの youjoAI フォルダへ投入

## ライセンス

  - ソースコードのライセンスは、[MIT license][MIT] と [GPL license][GPL] の Dual License とします

## 免責

  - ご利用は自己責任でお願いします

## 謝辞

  - 拡張性の高い AI プラットフォーム である [YoujoMOD] を公開されている作者様に感謝します

## 公開先

  - Minecraft 日本非公式ユーザーフォーラム
    - <http://forum.minecraftuser.jp/viewtopic.php?f=13&t=6134&p=49598#p49598>
  - github (ソースコード)
    - EasyAIInterface
      <https://github.com/bbc-mc/EasyAIInterface>
    - YoujoAI_EasyAIInterface
      <https://github.com/bbc-mc/YoujoAI_EasyAIInterface>
    - EAIMobSample
      <https://github.com/bbc-mc/EAIMobSample>

## 更新
  2012/10/20
        EasyAIInterface αバージョン公開
        EAI_SampleMob と YoujoAI を別リポジトリへ移動しました

----------
####Copyright &copy; 2012 bbc_mc (bbc-mc on github)
####Dual licensed under the [MIT license][MIT] and [GPL license][GPL].

[MIT]: http://www.opensource.org/licenses/mit-license.php
[GPL]: http://www.gnu.org/licenses/gpl.html
[YoujoMOD]: http://forum.minecraftuser.jp/viewtopic.php?f=13&t=2816#p20049
[topic]: http://forum.minecraftuser.jp/viewtopic.php?f=13&t=6134&p=49598#p49598
[github_EAI]: https://github.com/bbc-mc/EasyAIInterface
[github_EAIMobSample]: https://github.com/bbc-mc/EAIMobSample
[github_YoujoAI]: https://github.com/bbc-mc/YoujoAI_EasyAIInterface

