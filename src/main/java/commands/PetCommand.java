package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.ImageProxy;

import java.util.List;

public class PetCommand extends ListenerAdapter {
     public void onMessageReceived(MessageReceivedEvent e){
         if(e.getAuthor().isBot()) return;
         String link = "https://api.popcat.xyz/pet?image=";
         String message = e.getMessage().getContentRaw();
         String avatarLink;

         if(message.equalsIgnoreCase("$pet")){
             avatarLink = e.getAuthor().getEffectiveAvatarUrl();
             e.getChannel().sendMessage(avatarLink).queue();
             EmbedBuilder eb = new EmbedBuilder();
             String finalLink = link + avatarLink;
             e.getChannel().sendMessage(finalLink).queue();
             eb.setImage(finalLink);
             e.getChannel().sendMessageEmbeds(eb.build()).queue();
         }
     }
}
