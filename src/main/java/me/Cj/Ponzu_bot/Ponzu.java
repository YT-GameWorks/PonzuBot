package me.Cj.Ponzu_bot;

import commands.*;
import events.EnteredServer;
import events.EnteringNewServer;
import events.HelloEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Ponzu {
    public static void main(String[] args) throws LoginException{
        JDA api = (JDA) JDABuilder.createLight("MTAwMzI1MjUxNDgzMDk1ODY2NQ.GFHkA2.gzHL8OMxcNXi5-CaVLHcM0EGan0faH7JyU42gA", GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_INVITES)
                .setStatus(OnlineStatus.ONLINE)
                .setActivity(Activity.listening("HIP - MAMAMOO (마마무)"))
                .build();



        // registering the event in main class
        api.addEventListener(new HelloEvent());
        api.addEventListener(new InfoCommand());
        api.addEventListener(new HelpCommand());
        api.addEventListener(new EnteredServer());
        api.addEventListener(new MemeCommand());
        api.addEventListener(new AnimeCommand());
        api.addEventListener(new CarCommand());
        api.addEventListener(new InviteCommand());
        api.addEventListener(new FoxCommand());
        api.addEventListener(new PetCommand());
        api.addEventListener(new DrakeMeme());
        api.addEventListener(new EnteringNewServer());
        api.addEventListener(new CjCommand());
        api.addEventListener(new KermitCommand());
        api.addEventListener(new RedditCommand());
        api.addEventListener(new MovieCommand());

    }
}
