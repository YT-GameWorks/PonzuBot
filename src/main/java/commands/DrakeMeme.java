package commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DrakeMeme extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent e){
        if(e.getAuthor().isBot()) return;

        String message = e.getMessage().getContentRaw();
        String text1 = "";
        String text2 = "";
        String link = "https://api.popcat.xyz/drake?text1=";

        if(message.equalsIgnoreCase("$drake")){
            e.getChannel().sendMessage("Enter text 1: ").queue();
            e.wait();
            text1 = e.getMessage().getContentRaw();
            e.getChannel().sendMessage("Enter text 2: ").queue();
            text2 = e.getMessage().getContentRaw();

            link = link + text1 + "&" + "text2=" + text2;
            e.getChannel().sendMessage(link);
        }
    }
}
