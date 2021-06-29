//Project_by Sharon77770
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
