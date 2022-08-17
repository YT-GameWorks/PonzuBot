package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class HelpCommand extends ListenerAdapter {
    public void onMessageReceived (MessageReceivedEvent e){
        Message message = e.getMessage();
        String content = message.getContentRaw();

        if(e.getAuthor().isBot()) return;

        if(content.equalsIgnoreCase("$help")){
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("\uD835\uDCD2\uD835\uDCF8\uD835\uDCF6\uD835\uDCF6\uD835\uDCEA\uD835\uDCF7\uD835\uDCED\uD835\uDCFC\n");
            eb.setDescription("These are the bot commands: Type $help (commmand) for more info. Example: $help anime.");
            eb.addField("$anime", "Gives you anime gifs.", false);
            eb.addField("$car", "Gives you random car images.", false);
            eb.addField("$drake", "Makes the drake meme.", false);
            eb.addField("$fact", "Gives a random fact.", false);
            eb.addField("$fox", "Gives a random fox image.", false);
            eb.addField("$info", "Gives info about the bot.", false);
            eb.addField("$invite bot","Gives link to invite the bot to your server.", false);
            eb.addField("$kermit", "Gives you a kermit pic.", false);
            eb.addField("$meme", "Gives you random memes.", false);
            eb.addField("$movie", "Gives you info about any movie.", false);
            eb.addField("$reddit", "Gives info about any subreddit.", false);
            eb.addField("$song", "Gives lyrics of any english song.", false);

            eb.setColor(Color.PINK);
            e.getChannel().sendMessageEmbeds(eb.build()).queue();


        }

    }
}
