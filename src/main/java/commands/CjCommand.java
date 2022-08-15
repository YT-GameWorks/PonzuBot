package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class CjCommand extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent e) {
        if(e.getAuthor().isBot())return;
        String message = e.getMessage().getContentRaw();
        String link = "https://api.popcat.xyz/oogway?text=Cj%E3%81%AF%E6%B4%BE%E6%89%8B%E3%81%AA%E7%A5%9E%E3%81%AE%E7%A5%9E%E3%81%A7%E3%81%99";
        String query = "これは事実です";

        if(message.equalsIgnoreCase("$cj")){
            e.getMessage().delete().queue();
            e.getChannel().sendMessage(link).queue();
            e.getChannel().sendMessage(query).queue();
        }
    }
}
