package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class HELPCOMMANDEXPLAINER extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent e) {
        if(e.getAuthor().isBot()) return;
        String[] message = e.getMessage().getContentRaw().split(" ");

        EmbedBuilder eb = new EmbedBuilder();
        e.getMessage().delete().queue();

        if(message[0].equalsIgnoreCase("$help") && message[1].equalsIgnoreCase("anime")){
            eb.setTitle("$anime");
            eb.setDescription("Type $anime (category). For example: $anime hug. The categories are given below: ");
            eb.addField("Categories: ", "baka, bite, blush, bored, cry, cuddle, dance, facepalm, feed, handhold, happy, highfive, hug, kick,kiss, laugh, pat, poke, pout, punch, shoot, shrug, slap, sleep, smile, smug, stare, think, thumbsup, tickle, wave, wink, yeet", false);
            eb.setColor(Color.orange);
            eb.setThumbnail("https://c.tenor.com/aF0ipAtOk9cAAAAM/spy-x-family-anya.gif");
            e.getChannel().sendMessageEmbeds(eb.build()).queue();

        }

            if(message[0].equalsIgnoreCase("$help") && message[1].equalsIgnoreCase("drake")){
                eb.setTitle("$drake");
                eb.setColor(Color.orange);
                eb.setDescription("Type $anime!text1!text2 for the meme. For example: $drake!other bots!Ponzu bot.");
                eb.setThumbnail("https://c.tenor.com/5qgd8AW8fOMAAAAd/drake-dance.gif");
                e.getChannel().sendMessageEmbeds(eb.build()).queue();
            }
                if(message[0].equalsIgnoreCase("$help") && message[1].equalsIgnoreCase("movie")){
                    eb.setTitle("$movie");
                    eb.setDescription("Type $movie (movie name) to get details about a movie. Example: $movie minions.");
                    eb.setThumbnail("https://c.tenor.com/mWpYDtV1zTkAAAAC/minions-shh.gif");
                    eb.setColor(Color.orange);
                    e.getChannel().sendMessageEmbeds(eb.build()).queue();
                }
                    if(message[0].equalsIgnoreCase("$help") && message[1].equalsIgnoreCase("reddit")){
                        eb.setTitle("$reddit");
                        eb.setDescription("Type $reddit (subreddit name) to get details about any subreddit. Example: $reddit memes.");
                        eb.setThumbnail("https://cdn.dribbble.com/users/244018/screenshots/1506924/reddit-dude.gif");
                        eb.setColor(Color.orange);
                        e.getChannel().sendMessageEmbeds(eb.build()).queue();
                    }
//                        if(message[0].equalsIgnoreCase("$help") && message[1].equalsIgnoreCase("")){
//
//                        }
    }
}
