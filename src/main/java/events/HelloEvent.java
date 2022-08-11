package events;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class HelloEvent extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event){      // on EVENT is how we name the method

        if (event.getAuthor().isBot()) return;

        String name = event.getAuthor().getName();
        Message message = event.getMessage(); //storing the incoming message in a variable. getContentRaw gives string format.
        String content = message.getContentRaw();
        if(content.equalsIgnoreCase("$hello")) {  //condition
            event.getChannel().sendMessage("Hi" + " " + name + " " + ":)").queue();  //always remember the queue()
        }
    }

}
