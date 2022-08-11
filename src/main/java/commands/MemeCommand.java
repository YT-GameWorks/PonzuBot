package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class MemeCommand extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getAuthor().isBot()) return;
        JSONParser parser = new JSONParser();
        String postLink = "";
        String title = "";
        String url = "";
        String test = "gimme";

        if (e.getMessage().getContentRaw().equalsIgnoreCase("$meme")) {
            try {
                URL memeURL = new URL("https://meme-api.herokuapp.com/" + test   );
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(memeURL.openConnection().getInputStream()));

                String lines;
                while((lines = bufferedReader.readLine()) != null){
                    JSONArray array = new JSONArray();
                    array.add(parser.parse(lines));

                    for(Object o : array){
                        JSONObject jsonObject = (JSONObject) o;

                         postLink = (String) jsonObject.get("postLink");
                         title = (String) jsonObject.get("title");
                         url = (String) jsonObject.get("url");
                    }
                }
                bufferedReader.close();

                e.getMessage().delete().queue();
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle(title,postLink);
                eb.setImage(url);
                eb.setColor(Color.CYAN);
                e.getChannel().sendMessageEmbeds(eb.build()).queue();



            } catch (Exception e1) {
                e.getChannel().sendMessage("Hey! Something went wrong. Please try again later :) ").queue();
                e1.printStackTrace();
            }
        }
    }
}
