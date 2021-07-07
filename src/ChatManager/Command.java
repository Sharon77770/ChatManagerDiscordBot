package ChatManager;

import java.util.Vector;

import main.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

public class Command {
	public static Vector<String> words = new Vector<>();
	private static final String[][] cmd = { 
				{ "!help", "!add forbidden words ", "!show warning point", "!show forbidden words" },
				{ "!도움", "!금지어 추가 ", "!벌점", "!금지어" } 
			};
	
	private static final int KOREAN = 1, ENGLISH = 0;
	
	
	public static void showCmd(Message msg, TextChannel ch) {
		
		if(msg.getContentRaw().equals(cmd[Main.language][0])) {
			
			EmbedBuilder embed = new EmbedBuilder();
			String embedMsg;
			
			if(Main.language == KOREAN) {
				
				embedMsg = Main.channelRule
						+ "\n\n"
						+ "명령어\n"
						+ "-" + cmd[1][1] + "\"금지어\" : 금지어를 추가합니다.\n"
						+ "-" + cmd[1][2] + " : 경고 횟수를 확인합니다.\n"
						+ "-" + cmd[1][3] + " : 금지어 리스트를 보여줍니다.";
			}
			else {
				
				embedMsg = Main.channelRule
						+ "\n\n"
						+ "Command\n"
						+ "-" + cmd[0][1] + "\"forbidden word\" : add frobidden word\n"
						+ "-" + cmd[0][2] + " : show your WARNING_POINT\n"
						+ "-" + cmd[0][3] + " : show list of forbidden words";
			}
			
			embed.addBlankField(true);
			embed.setTitle("How to Use?");
			embed.setDescription(embedMsg);
			ch.sendMessage(embed.build()).queue();;
		}
	}
	
	public static void addForbiddenWords(User user, Message msg, TextChannel ch) {

		if(user.getId().equals(Main.serverManagerID)) {
			
			if(msg.getContentRaw().split("\"")[0].equals(cmd[Main.language][1])) {
				
				if(words.indexOf(msg.toString().split("\"")[1]) == -1) {
					
					words.addElement(msg.toString().split("\"")[1]);
					
					if(Main.language == 1)
						ch.sendMessage("금지어 추가 : " + msg.toString().split("\"")[1]).queue();
					else
						ch.sendMessage("Successfully Added : " + msg.toString().split("\"")[1]).queue();
				}
				else {
					
					if(Main.language == KOREAN)
						ch.sendMessage("실패 : 이미 존재하는 금지어 입니다.");
					else
						ch.sendMessage("Failure : A word that already exists");
				}
			}
		}
	}
	
	public static void showMyWarnningPoint(User user, Message msg, TextChannel ch) {
		if(msg.getContentRaw().equals(cmd[Main.language][2])) {
			
			if(Main.language == KOREAN) {
				ch.sendMessage(user.getAsMention() + 
						"님의 경고 횟수 : " + UserInfoManager.getValue(user.getId())).queue();
			}
			else {
				ch.sendMessage(user.getAsMention() + 
						"'s WARNING_POINT : " + UserInfoManager.getValue(user.getId())).queue();
			}
		}
	}
	
	public static void showForbiddenWords(User user, Message msg, TextChannel ch) {
		if(msg.getContentRaw().equals(cmd[Main.language][3])) {
			
			String newMsg = "List\n\n";
			
			for(int cnt = 0; cnt < words.size(); ++cnt) {
				newMsg += "-" + words.get(cnt) + "\n";
			}
			
			ch.sendMessage(newMsg).queue();
		}
	}
}