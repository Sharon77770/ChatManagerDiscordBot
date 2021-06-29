package main;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

public class UserInfoManager {
	private static Map<String, Integer> users = new HashedMap<String, Integer>();
	
	public static void addNewUser(String id) {
		if(users.containsKey(id))
			return;
		
		users.put(id, 0);
	}
	
	public static boolean isContainKey(String id) {
		if(users.isEmpty())
			return false;
		return users.containsKey(id);
	}
	
	public static boolean isEmpty() {
		return users.isEmpty();
	}
	
	public static void warning(String id) {
		if(!isContainKey(id)) 
			return;
		
		users.put(id, users.get(id) + 1);
	}
	
	public static int getValue(String id) {
		return users.get(id);
	}
	
	public static void banWarning(String id, TextChannel ch, User user, Member mb) {
		if(UserInfoManager.getValue(id) >= Main.MaxWarningPoint) {
			if(Main.KickMaxWarningPointMember) {
				mb.kick("You Have Lot of WARNING_POINT").queue();
				users.put(id, 0);
			}
			ch.sendMessage(user.getAsMention() + " Have Over Than " + Main.MaxWarningPoint + " WARNING_POINTS.").queue();
		}
	}
}
