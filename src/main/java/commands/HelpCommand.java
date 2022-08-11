package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class HelpCommand extends ListenerAdapter {
    public void onMessageReceived (MessageReceivedEvent e){
        Message message = e.getMessage();
        String content = message.getContentRaw();

        if(e.getAuthor().isBot()) return;

        if(content.equalsIgnoreCase("$help")){
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("\uD835\uDCD2\uD835\uDCF8\uD835\uDCF6\uD835\uDCF6\uD835\uDCEA\uD835\uDCF7\uD835\uDCED\uD835\uDCFC\n");
            eb.setDescription("These are the bot commands: ");
            eb.setColor(Color.PINK);
            e.getChannel().sendMessageEmbeds(eb.build()).queue();


        }

    }
}
