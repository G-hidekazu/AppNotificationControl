# AppNotificationControl

Betweenアプリの通知をワンタップでON/OFFするためのシンプルなAndroidアプリです。

## 使い方
1. アプリを起動すると通知アクセスの許可画面が開きます。
2. AppNotificationControlの通知アクセスを有効にします。
3. 以降はアプリアイコンをタップするたびにBetween通知のON/OFFが切り替わります。

## 仕様
- Betweenの通知は通知リスナーで検知し、OFF時は通知を即座に消すことで疑似的に無効化します。
- 端末再起動後は再度通知アクセスの有効化が必要になる場合があります。
