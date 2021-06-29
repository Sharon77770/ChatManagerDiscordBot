# ChatManagerDiscordBot

**Project_by Sharon77770**

Discord chat management bot. If you use prohibited words, you will receive a warning (WARNING_POINT), and if you receive more than a certain amount, you will be kicked out of the server.

디스코드 채팅 관리 봇입니다. 금지어를 사용하면 경고(WARNING_POINT)를 받으며 일정량 이상 받게되면 서버에서 추방당합니다.


## ENGLISH

Run the Discord bot after setting the basic settings in the Main.java file.

**SETTING:**

-Bot token (String)

-Server Manager's Discord ID (String) **(NOT DISCORD NICKNAME)**

-Forbidden Words (String[])

-MAX Warning Point (int)

-Kick MAX Warning Point Member (boolean)

-Your Channel's Rule (String)


```java
package main;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDABuilder;

public class Main {
	
	//Write Your Bot Token
	private static String token = "WRITE YOUR TOKEN";
	
	//Write Your Discord UserId *USER ID IS NOT YOUR NICKNAME*
	//You can't Use Server Manager Command ex) !Add Forbidden Words "Forbidden Words"
	public static String serverManagerID = "WRITE YOUR DISCORD USER ID";
	
	//Write Forbidden Words ex) {"FUCK", "WTF"}
	//You can add Words at Runtime With !Add Forbidden Words "Forbidden Words"
	public static String[] forbiddenWords = { "Fuck", "WTF" };
	
	//Wirte Your Channel's Max Warning Point
	public static int MaxWarningPoint = 10;
	
	//True:Kick the Member Who Have Max WARNING_POINT
	//FALSE:Send Warning Message about Who Have Max WARING_POINT
	public static boolean KickMaxWarningPointMember = true;
	
	//Write Your Channel's Rule
	//Member Can Read This with !show info
	public static String channelRule = "WRITE YOUR CHANNEL'S RULE";
	
	
	
	public static void main(String[] args) throws LoginException {
		JDABuilder.createDefault(token).addEventListeners(new MyListener()).build();
	}
}
```



## 한국어

Main.java 파일에서 기본 설정 후 실행시켜 주세요.

**설정:**

-봇 토큰 (String)

-서버 관리자 ID (String) **(디스코드 닉네임 아님)**

-금지어 (String[])

-최대 경고 횟수 (int)

-최대 경고를 받은 유저를 추방 할 것인가? (boolean)

-봇을 사용할 채널만의 고유 룰 (String)


```java
package main;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDABuilder;

public class Main {
	
	//Write Your Bot Token
	private static String token = "WRITE YOUR TOKEN";
	
	//Write Your Discord UserId *USER ID IS NOT YOUR NICKNAME*
	//You can't Use Server Manager Command ex) !Add Forbidden Words "Forbidden Words"
	public static String serverManagerID = "WRITE YOUR DISCORD USER ID";
	
	//Write Forbidden Words ex) {"FUCK", "WTF"}
	//You can add Words at Runtime With !Add Forbidden Words "Forbidden Words"
	public static String[] forbiddenWords = { "Fuck", "WTF" };
	
	//Wirte Your Channel's Max Warning Point
	public static int MaxWarningPoint = 10;
	
	//True:Kick the Member Who Have Max WARNING_POINT
	//FALSE:Send Warning Message about Who Have Max WARING_POINT
	public static boolean KickMaxWarningPointMember = true;
	
	//Write Your Channel's Rule
	//Member Can Read This with !show info
	public static String channelRule = "WRITE YOUR CHANNEL'S RULE";
	
	
	
	public static void main(String[] args) throws LoginException {
		JDABuilder.createDefault(token).addEventListeners(new MyListener()).build();
	}
}
```
