package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.guild.invite.GenericGuildInviteEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import net.dv8tion.jda.api.events.guild.invite.GenericGuildInviteEvent;

import java.awt.*;


public class InviteCommand extends ListenerAdapter {


    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getAuthor().isBot()) return;
        String[] message = event.getMessage().getContentRaw().split(" ");
        if(message[0].equalsIgnoreCase("$invite") && message[1].equalsIgnoreCase("bot")){
            EmbedBuilder eb = new EmbedBuilder();
            String invite = event.getChannel().getJDA().getInviteUrl();
            eb.setTitle("\uD835\uDC77\uD835\uDC90\uD835\uDC8F\uD835\uDC9B\uD835\uDC96 \uD835\uDC83\uD835\uDC90\uD835\uDC95");
            eb.setDescription("\uD835\uDC6F\uD835\uDC86\uD835\uDC93\uD835\uDC86 \uD835\uDC8A\uD835\uDC94 \uD835\uDC95\uD835\uDC89\uD835\uDC86 \uD835\uDC8A\uD835\uDC8F\uD835\uDC97\uD835\uDC8A\uD835\uDC95\uD835\uDC86 \uD835\uDC8D\uD835\uDC8A\uD835\uDC8F\uD835\uDC8C \uD835\uDC87\uD835\uDC90\uD835\uDC93 \uD835\uDC95\uD835\uDC89\uD835\uDC86 \uD835\uDC83\uD835\uDC90\uD835\uDC95:\n" +
                   invite );
            eb.setColor(Color.orange);
            eb.setImage("https://i.pinimg.com/736x/2a/a4/3b/2aa43b20bd9a3a5f5e8c8baa71ad0042.jpg");
            event.getChannel().sendMessageEmbeds(eb.build()).queue();

        }

    }

}
