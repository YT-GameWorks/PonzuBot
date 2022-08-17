package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.json.JSONObject;

import java.awt.*;
import java.net.URL;
import java.util.Scanner;

public class SongCommand extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent e){
        if(e.getAuthor().isBot()) return;

        String message = e.getMessage().getContentRaw();
        String query = message.substring(6).replace(" ", "+");
        String link = "https://api.popcat.xyz/lyrics?song="+query;
        String lines = "", title = "", image = "", artist = "", lyrics = "";

        if(message.toLowerCase().startsWith("$song")){
            try{
                URL url = new URL(link);
                Scanner sc = new Scanner(url.openStream());

                e.getMessage().delete().queue();

                while(sc.hasNext()){
                    lines += sc.nextLine();
                }

                JSONObject object = new JSONObject(lines);
                title = object.getString("title");
                image = object.getString("image");
                artist = object.getString("artist");
                lyrics = object.getString("lyrics");

                EmbedBuilder eb = new EmbedBuilder();
                eb.setThumbnail(image);
                eb.setTitle(title);
                eb.setColor(Color.magenta);
                eb.addField("Artist: ", artist, false);
                eb.setDescription(lyrics);

                e.getChannel().sendMessageEmbeds(eb.build()).queue();

            }catch (Exception e1){
                e.getChannel().sendMessage("Couldn't find lyrics to the song. Try another song! :)").queue();
            }
        }
    }
}
