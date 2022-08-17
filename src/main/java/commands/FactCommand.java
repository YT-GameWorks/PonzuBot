package commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.net.URL;
import java.util.Scanner;

public class FactCommand extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent e) {
        if(e.getAuthor().isBot()) return;

        String message = e.getMessage().getContentRaw();
        String link = "https://api.popcat.xyz/fact";
        String lines = "";
        String fact = "";

        if(message.equalsIgnoreCase("$fact")){
            try{
                URL url = new URL(link);
                Scanner sc = new Scanner(url.openStream());
                e.getMessage().delete().queue();

                while(sc.hasNext()){
                    lines += sc.nextLine();
                }
                JSONObject obj = new JSONObject(lines);
                fact = obj.getString("fact");

                e.getChannel().sendMessage(fact).queue();

            }
            catch(Exception e1){
                e.getChannel().sendMessage("Something went wrong. Try again later! :)").queue();
            }
        }

    }
}
