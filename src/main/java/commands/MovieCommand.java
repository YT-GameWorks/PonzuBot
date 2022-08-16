package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.json.JSONObject;

import java.awt.*;
import java.net.URL;
import java.util.Scanner;

public class MovieCommand extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent e){
        if(e.getAuthor().isBot()) return;
        String message = e.getMessage().getContentRaw();
        String query = message.substring(7);
        String encodedQuery = query.replace(" ", "+");
        String link = "https://api.popcat.xyz/imdb?q=" + encodedQuery;
        String lines = "";
        String title = "", year = "", rated = "", genres = "", director = "", actors = "", plot = "", language = "",
                boxoffice = "", poster = "", awards ="";

        if(message.toLowerCase().startsWith("$movie")){
            try{
                URL url = new URL(link);
                Scanner sc = new Scanner(url.openStream());


                while(sc.hasNext()){
                    lines += sc.nextLine();
                }
                sc.close();


                JSONObject obj = new JSONObject(lines);
                title = obj.getString("title");
                year = obj.getString("_yearData");
                rated = obj.getString("rated");
                genres = obj.getString("genres");
                director = obj.getString("director");
                actors = obj.getString("actors");
                plot = obj.getString("plot");
                language = obj.getString("languages");
                boxoffice = obj.getString("boxoffice");
                poster = obj.getString("poster");
                awards = obj.getString("awards");


                EmbedBuilder eb = new EmbedBuilder();
                eb.setImage(poster);
                eb.setDescription(plot);
                eb.setTitle(title);
                eb.addField("Year: ", year, false);
                eb.addField("Rated: ",rated , false);
                eb.addField("Genres: ",genres , false);
                eb.addField("Director: ",director , false);
                eb.addField("Actors: ",actors , false);
                eb.addField("Languages: ",language , false);
                eb.addField("Box office earnings: ",boxoffice , false);
                eb.addField("Awards: ",awards , false);
                eb.setColor(Color.cyan);

                e.getChannel().sendMessageEmbeds(eb.build()).queue();


            }
            catch (Exception exception){
                e.getChannel().sendMessage("Something went wrong. Please try again later :)").queue();
            }
        }
    }
}