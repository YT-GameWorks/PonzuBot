package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.awt.*;
import java.net.URL;
import java.util.Scanner;

public class CarCommand extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        if(event.getAuthor().isBot()) return;

        if(event.getMessage().getContentRaw().equalsIgnoreCase("$car"))
        {
            String lines = "";
            JSONParser parser = new JSONParser();
            String image = "", title = "";
            try {

                URL url = new URL("https://api.popcat.xyz/car");
                Scanner sc = new Scanner(url.openStream());


                while(sc.hasNext()) {
                    lines += parser.parse(sc.nextLine());
                }

                event.getChannel().sendMessage(lines);

                JSONObject obj = new JSONObject(lines);
                image = obj.getString("image");
                title = obj.getString("title");

                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle(title);
                eb.setImage(image);
                eb.setColor(Color.CYAN);
                event.getChannel().sendMessageEmbeds(eb.build()).queue();


            }
            catch (Exception e1) {
                event.getChannel().sendMessage("Please check the command format!").queue();
            }



        }


    }
}
