package commands;

import com.sun.tools.jdeprscan.scan.Scan;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class JokeCommand extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getAuthor().isBot()) return;
        String message = e.getMessage().getContentRaw();


        if (message.equalsIgnoreCase("$joke")) {
            JSONParser parser = new JSONParser();
            e.getChannel().sendMessage("test").queue();
            String joke = "";

            try {
                URL url = new URL("https://api.popcat.xyz/joke");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));

                String lines;
                while((lines = bufferedReader.readLine()) != null){
                    JSONArray array = new JSONArray();
                    array.add(parser.parse(lines));

                    for(Object o : array) {
                        JSONObject jsonObject = (JSONObject) o;

                        joke = (String) jsonObject.get("joke");

                    }
                }
                bufferedReader.close();
                e.getChannel().sendMessage(joke).queue();

            } catch (Exception e1) {
                e.getChannel().sendMessage("Exception").queue();
            }
        }
    }
}
