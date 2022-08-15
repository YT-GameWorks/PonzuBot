package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class DrakeMeme extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent e){
        if(e.getAuthor().isBot()) return;
        String message[] = e.getMessage().getContentRaw().split("!");
        String text1 = "";
        String text2 = "";
        String link = "https://api.popcat.xyz/drake?text1=";
        String query = "";

        if(message[0].equalsIgnoreCase("$drake")){
            text1 = message[1].replace(" ", "%20");
            text2 = message[2].replace(" ", "%20");
            query = text1 + "&text2=" + text2;
            link += query;
            e.getMessage().delete().queue();
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("ꜰᴀᴄᴛꜱ ʙʏ ᴅʀᴀᴋᴇ");
            eb.setImage(link);
            eb.setColor(Color.CYAN);

            e.getChannel().sendMessageEmbeds(eb.build()).queue();

        }
    }
}
