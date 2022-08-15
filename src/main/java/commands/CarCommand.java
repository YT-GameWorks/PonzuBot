package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class CarCommand extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        if (event.getAuthor().isBot()) return;
        String lines = "";
        String image = "", title = "";

        if (event.getMessage().getContentRaw().equalsIgnoreCase("$car")) {
            try{
                URL url = new URL("https://api.popcat.xyz/car");
                Scanner scanner = new Scanner(url.openStream());

                while(scanner.hasNext()){
                    lines += scanner.nextLine();
                }
                scanner.close();
                event.getMessage().delete().queue();

                JSONObject obj = new JSONObject(lines);
                image = obj.getString("image");
                title = obj.getString("title");

                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle(title);
                eb.setColor(Color.CYAN);
                eb.setImage(image);



                event.getChannel().sendMessageEmbeds(eb.build()).queue();


            }catch (Exception e1){
                event.getChannel().sendMessage("There was some problem. Please try again later! :)");
            }


        }
    }
}
