package main;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MyListener extends ListenerAdapter{
	@Override
	public void onReady(ReadyEvent event) {
		for(int cnt = 0; cnt < Main.forbiddenWords.length; ++cnt) {
			Command.words.add(Main.forbiddenWords[cnt]);
		}
	}
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		if(event.getAuthor().isBot())
			return;
		
		Message msg = event.getMessage();
		User user = event.getAuthor();
		Member mb = event.getMember();
		TextChannel ch = event.getTextChannel();
		String id = user.getId();
		
		if(!UserInfoManager.isContainKey(id))
			UserInfoManager.addNewUser(id);
		
		
		for(int cnt = 0; cnt < Command.words.size(); ++cnt) {
			if(msg.toString().contains(Command.words.get(cnt))) {
				UserInfoManager.warning(id);
				break;
			}
		}
		
		UserInfoManager.banWarning(id, ch, user, mb);
		
		Command.showCmd(msg, ch);
		Command.addForbiddenWords(user, msg, ch);
		Command.showMyWarnningPoint(user, msg, ch);
	} 
}
