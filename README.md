google-calendar-widget
===
##概要
Wordpressでグーグルカレンダーを取り込むプラグイン

##使い方
1. 管理画面の"インストール済みプラグイン"から"Google Calendar Widget"を有効化  
2. 管理画面の"外観"->"ウィジェット"で"Google Calendar"を"ウィジェットエリア"にドラッグアンドドロップ  
3. 読み込むカレンダーのID指定などプラグインの設定をする
4. サイトを表示

##Wordpress管理者アカウント
name:test pass:test

##テスト用グーグルカレンダーデータ
サンプルをもとに適宜追加してください．  
必要なIDは右クリック→カレンダーの設定から参照できます．

##その他の必要な情報
1. スタンドアロンモードはlocalhost/wordpress/wp-content/plugins/google-calendar-widget/examples/stand_alone.htmlでアクセスできる

##WebDriver Tips
1.クリック  
driver.findElement(By.xpath("hoge")).click();  

2.ホバー    
// アクション：一連のイベントを作成  
Actions actions = new Actions(driver);    
// 移動先の要素を取得  
WebElement target = driver.findElement(By.xpath("hoge"));  
// ホバーイベントを登録  
actions.moveToElement(target);  
// アクション実行
actions.perform();  

3.リサイズ  
// 指定のウィンドウサイズに変更  
int width = 1000;  
int height = 500;  
driver.manage().window().setSize(new Dimension(width, height));  

// 最大化  
driver.manage().window().maximize();  
