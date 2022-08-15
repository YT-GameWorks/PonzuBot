package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.ls.LSInput;

import java.awt.*;

public class KermitCommand extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent e) {
    if(e.getAuthor().isBot()) return;
    String message = e.getMessage().getContentRaw();
    String link = "https://api.popcat.xyz/gun?image=https://s.yimg.com/ny/api/res/1.2/8qHYl9PBbuB9Pu.DgteLsg--/YXBwaWQ9aGlnaGxhbmRlcjt3PTY0MDtoPTM2MA--/https://s.yimg.com/uu/api/res/1.2/3hBtyJvhJueXkGChvl4hYQ--~B/aD0xMTI0O3c9MjAwMDthcHBpZD15dGFjaHlvbg--/http://media.zenfs.com/en-US/homerun/time_72/0377651ad11e6190eef21a8d019445a8";

    if(message.equalsIgnoreCase("$kermit")){
        e.getMessage().delete().queue();
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("Be careful. I saw that.");
            eb.setColor(Color.BLACK);
            eb.setImage(link);
            e.getChannel().sendMessageEmbeds(eb.build()).queue();
        }
    }
}
