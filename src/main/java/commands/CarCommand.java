package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class CarCommand extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        if (event.getAuthor().isBot()) return;
        String lines = "";
        JSONParser parser = new JSONParser();
        String image = "", title = "";

        if (event.getMessage().getContentRaw().equalsIgnoreCase("$car")) {
            try {
                URL carURL = new URL("https://api.popcat.xyz/car");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(carURL.openConnection().getInputStream()));

                while ((lines = bufferedReader.readLine()) != null) {
                    JSONArray array = new JSONArray();
                    array.add(parser.parse(lines));

                    event.getChannel().sendMessage(lines).queue();

                    for (Object o : array) {
                        org.json.simple.JSONObject jsonObject = (JSONObject) o;

                        image = (String) jsonObject.get("image");
                        title = (String) jsonObject.get("title");
                    }
                }

                bufferedReader.close();

                event.getMessage().delete().queue();
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle(title);
                eb.setImage(image);

                event.getChannel().sendMessageEmbeds(eb.build()).queue();

            } catch (Exception e1) {
                event.getChannel().sendMessage("Exception occured.").queue();
            }


        }
    }
}
