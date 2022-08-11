package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class AhoyCommand extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent e){
        if(e.getAuthor().isBot()) return;

        String message = e.getMessage().getContentRaw();

        if(message.toLowerCase().startsWith("$ahoy")){
            String text = message.substring(6);
            String link = "https://api.funtranslations.com/translate/pirate.json?text=" + text;
            String body = "";
            JSONParser parser = new JSONParser();

            try{
                URL url = new URL(link);

                Scanner sc = new Scanner(url.openStream());

                while(sc.hasNext())
                    body += parser.parse(sc.nextLine());

                e.getChannel().sendMessage(body).queue();

                JSONObject obj = new JSONObject(body);
                JSONObject contents = obj.getJSONObject("contents");
                String translated = contents.getString("translated");

                EmbedBuilder eb = new EmbedBuilder();
                eb.setDescription(translated);
                eb.setColor(Color.orange);
                eb.setThumbnail("https://i.pinimg.com/originals/46/6c/2b/466c2b8cbb84740f787d6cd807d8cb67.jpg");
                eb.setFooter("\uD835\uDC9E\uD835\uDCB6\uD835\uDCC3 \uD835\uDC5C\uD835\uDCC3\uD835\uDCC1\uD835\uDCCE \uD835\uDCB7\uD835\uDC52 \uD835\uDCCA\uD835\uDCC8\uD835\uDC52\uD835\uDCB9 \uD835\uDFE7 \uD835\uDCC9\uD835\uDCBE\uD835\uDCC2\uD835\uDC52\uD835\uDCC8 \uD835\uDCC5\uD835\uDC52\uD835\uDCC7 \uD835\uDCBD\uD835\uDC5C\uD835\uDCCA\uD835\uDCC7.");

                e.getChannel().sendMessageEmbeds(eb.build()).queue();
            }
             catch (Exception ex) {
                 e.getChannel().sendMessage("Limit has been exceeded!").queue();
            }


        }
    }
}
