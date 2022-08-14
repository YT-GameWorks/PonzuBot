package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.awt.*;
import java.net.URL;
import java.util.Scanner;

public class FoxCommand extends ListenerAdapter {
    @Override
    public void onMessageReceived (MessageReceivedEvent e){
         if(e.getAuthor().isBot()) return;  //checking if the message is sent by a bot

        String message = e.getMessage().getContentRaw();
        if(message.equalsIgnoreCase("$fox") || message.equalsIgnoreCase("$kitsune")){
            JSONParser parser = new JSONParser();
            String image = "";
           try {
               URL url = new URL("https://randomfox.ca/floof/");
               Scanner sc = new Scanner(url.openStream());

               String content = "";
               while(sc.hasNext()){
                   content += parser.parse(sc.nextLine());
               }

               JSONObject ob = new JSONObject(content);
                image = ob.getString("image");

               EmbedBuilder eb = new EmbedBuilder();
               eb.setColor(Color.orange);
               eb.setImage(image);
               eb.setTitle("\uD835\uDC9C \uD835\uDCBB\uD835\uDCC1\uD835\uDC5C\uD835\uDC5C\uD835\uDCBB \uD835\uDCBB\uD835\uDC5C\uD835\uDCC7 \uD835\uDCCE\uD835\uDC5C\uD835\uDCCA :)");
               e.getChannel().sendMessageEmbeds(eb.build()).queue();

           }
           catch (Exception e1){
               e.getChannel().sendMessage("Something went wrong. Try again later! :) ").queue();
           }
        }

    }
}
