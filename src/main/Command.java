package main;

import java.util.Vector;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

public class Command {
	public static Vector<String> words = new Vector<>();
	private static String[] cmd = { "!show info", "!add forbidden words ", "!show warning point" };
	
	public static void showCmd(Message msg, TextChannel ch) {
		if(msg.getContentRaw().equals(cmd[0])) {
			EmbedBuilder embed = new EmbedBuilder();
			String embedMsg = Main.channelRule
							+ "\n\n"
							+ "Command\n"
							+ "-" + cmd[1] + "\"forbidden word\" : add frobidden word\n"
							+ "-" + cmd[2] + " : show your WARNING_POINT";
			
			embed.addBlankField(true);
			embed.setTitle("How to Use?");
			embed.setDescription(embedMsg);
			ch.sendMessage(embed.build()).queue();;
		}
	}
	
	public static void addForbiddenWords(User user, Message msg, TextChannel ch) {
		if(user.getId() == Main.serverManagerID) {
			if(msg.getContentRaw().split("\"")[0].equals(cmd[1])) {
				if(words.indexOf(msg.toString().split("\"")[1]) == -1) {
					words.addElement(msg.toString().split("\"")[1]);
					ch.sendMessage("Successfully Added : " + msg.toString().split("\"")[1]).queue();
				}
				else
					ch.sendMessage("Failure: A word that already exists");
			}
		}
	}
	
	public static void showMyWarnningPoint(User user, Message msg, TextChannel ch) {
		if(msg.getContentRaw().equals(cmd[2])) {
			ch.sendMessage(user.getAsMention() + 
					"'s WARNING_POINT : " + UserInfoManager.getValue(user.getId())).queue();
		}
	}
}
