package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class PetCommand extends ListenerAdapter {
     public void onMessageReceived(MessageReceivedEvent e){
         if(e.getAuthor().isBot()) return;
         String link = "https://api.popcat.xyz/pet?image=";
         String[] message = e.getMessage().getContentRaw().split(" ");
         String avatarLink = "";
         String member1 = message[1];

         if(message[0].equalsIgnoreCase("$pet")){
             avatarLink = e.getAuthor().getAvatarUrl();
             EmbedBuilder eb = new EmbedBuilder();
             String finalLink = link + avatarLink;
             eb.setImage(finalLink);
             e.getChannel().sendMessageEmbeds(eb.build()).queue();

             
         }
     }
}
