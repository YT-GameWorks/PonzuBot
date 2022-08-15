package commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CocktailCommand extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent e){
        if(e.getAuthor().isBot()) return;

        String message = e.getMessage().getContentRaw();
        String query = message.substring(9);

        if(message.toLowerCase().startsWith("$cocktail"));
    }
}
