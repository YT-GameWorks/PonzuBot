package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;


public class FactsCommand extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getAuthor().isBot()) return;
        String message = e.getMessage().getContentRaw();



        if(message.toLowerCase().startsWith("$facts")){
            String text = message.substring(7);
            String link = "https://api.popcat.xyz/facts?text=" + text;
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("\uD835\uDC39\uD835\uDCB6\uD835\uDCB8\uD835\uDCC9\uD835\uDCC8");
            eb.setImage(link);
            eb.setColor(Color.red);

            e.getChannel().sendMessageEmbeds(eb.build()).queue();
        }

    }
}
