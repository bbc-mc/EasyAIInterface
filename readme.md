MOD: mod_EasyAIInterface
----

----
    MOD name     : mod_EasyAIInterface
    Author       : bbc_mc (bbc-mc on github)
    publish date : not yet
    status       : develop

----
**2012/10/17 現在開発中のため、以下の内容には開発中の情報が含まれ、不正確な可能性があります。**

## 概要

ゲーム [Minectaft](http://www.mojang.com/) に以下の機能を追加する MOD です。

## 機能

 - AI を簡単に構築する仕組みを追加する
 - AI 構築に利用する Item "チップ"を追加する

## 動作環境・前提

以下の環境が必要です。

  + MC 1.2.5
  + ModLoader

## 参考実装

  + [YoujoMOD] 1.2.1 を利用した実装を upload しています。
    + YoujoMOD 用 AI として実装しています
      + src\minecraft\net\minecraft\src\YoujoAI_EasyAIInterface.java
    + Entity および AIチップ用インベントリとして利用しますが、EasyAIInterface 自体は YoujoMod に依存しません。
    + 以下の条件を満たすEntity であれば、本仕組みを実装可能です。
      + Entity である
      + AI チップを配置できる inventory を持つ
      + 定期的に EAI_Manager の実行関数をキックできる

    **TODO: 別サンプルの例示**

## 使用 ID

+ アイテムID
  + 29001 - 29003 ( 3 )
  + 29101 - 29103 ( 3 )
  + 29201 - 29203 ( 3 )
+ ブロックID
  + なし

## 導入方法

 - zip 内の mods/mod_EasyAIInterface.zip を、あなたの mods フォルダへ投入

## YoujoMod 用 AI 導入方法

 - zip 内の AI/YoujoAI_EasyAIInterface.class を、あなたの youjoAI フォルダへ投入

## ライセンス

  - ソースコードのライセンスは、[MIT license][MIT] と [GPL license][GPL] の Dual License とします

## 免責

  - ご利用は自己責任でお願いします

## 謝辞

  - 拡張性の高い AI プラットフォーム である [YoujoMOD] を公開されている作者様に感謝します

## 公開先 (現在開発中のため、まだ公開されていません)

  - Minecraft 日本非公式ユーザーフォーラム
    - <http://>
  - github (ソースコード)
    - <https://github.com/bbc-mc/EasyAIInterface>

## 更新

----------
####Copyright &copy; 2012 bbc_mc (bbc-mc on github)
####Dual licensed under the [MIT license][MIT] and [GPL license][GPL].

[MIT]: http://www.opensource.org/licenses/mit-license.php
[GPL]: http://www.gnu.org/licenses/gpl.html
[YoujoMOD]: http://forum.minecraftuser.jp/viewtopic.php?f=13&t=2816#p20049
