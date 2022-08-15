package commands;

import com.sun.org.apache.xpath.internal.operations.Bool;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.awt.*;
import java.net.URL;
import java.util.Scanner;

public class RedditCommand extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent e) {
        if(e.getAuthor().isBot()) return;
        String[] message = e.getMessage().getContentRaw().split(" ");
        String subreddit = message[1];
        JSONParser parser = new JSONParser();
        String link = "https://api.popcat.xyz/subreddit/"+subreddit;
        String name = "", title = "", active_users = "", members = "", icon = "", redditlink = "";
        Boolean nsfw;

        if(message[0].equalsIgnoreCase("$reddit")){
            try{
                URL url = new URL(link);
                Scanner sc = new Scanner(url.openStream());
                String lines = "";
                while(sc.hasNext()){
                    lines += sc.nextLine();
                }
                e.getMessage().delete().queue();

                JSONObject obj = new JSONObject(lines);
                name = obj.getString("name");
                title = obj.getString("description");
                active_users = obj.getString("active_users");
                members = obj.getString("members");
                icon = obj.getString("icon");
                nsfw = obj.getBoolean("over_18");
                redditlink = obj.getString("url");

                EmbedBuilder eb = new EmbedBuilder();
                eb.setColor(Color.red);
                eb.setTitle(name);
                eb.setDescription(title);
                eb.addField("Member count: ", members, true);
                eb.addField("Active users count: ", active_users, true);
//                eb.addField("Over_18: ", nsfw, true);
                eb.addField("Url: ", redditlink, true);
                eb.setThumbnail(icon);

                e.getChannel().sendMessageEmbeds(eb.build()).queue();


            }catch (Exception e1){
                e.getChannel().sendMessage("There was some problem. Please try again later! :)");
            }
        }
    }
}
