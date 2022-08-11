package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.awt.*;
import java.net.URL;
import java.util.Scanner;

public class AnimeCommand extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent e) {
        if(e.getAuthor().isBot()) return;
        String[] message = e.getMessage().getContentRaw().split(" ");

        if(message.length != 2 && message[0].equalsIgnoreCase("$anime"))
            e.getChannel().sendMessage("Please check the command format using $help.").queue();
        if(message[0].equalsIgnoreCase("$anime") && message.length == 2){

            String category = message[1];
            String link = "https://nekos.best/api/v2/" + category;
            JSONParser parser = new JSONParser();
            String urlLink = "", animeName = "";

            try{
                URL url = new URL(link);

                Scanner sc = new Scanner(url.openStream());
                String line = "";

                while(sc.hasNext()){
                    line += parser.parse(sc.nextLine());
                }

                JSONObject object = new JSONObject(line);
                JSONArray array = object.getJSONArray("results");
                for(int i = 0; i < array.length(); i++){
                    urlLink = array.getJSONObject(i).getString("url");
                    animeName = array.getJSONObject(i).getString("anime_name");
                }
                e.getMessage().delete().queue();

                EmbedBuilder eb = new EmbedBuilder();
                eb.setImage(urlLink);
                eb.setTitle("\uD835\uDCD0\uD835\uDCF7\uD835\uDCF2\uD835\uDCF6\uD835\uDCEE: " + animeName);
                eb.setColor(Color.magenta);

                e.getChannel().sendMessageEmbeds(eb.build()).queue();

            }
            catch (Exception e1){
                e.getChannel().sendMessage("Please enter a valid category!").queue();
            }

        }
    }
}