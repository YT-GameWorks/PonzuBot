package events;

import java.awt.*;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class EnteredServer extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        super.onGuildMemberJoin(event);
       // List<TextChannel> dontDoThis = event.getGuild().getTextChannelsByName("ようこそ-welcome", true);
        TextChannel textChannel = event.getGuild().getSystemChannel();


//        if(textChannel.isEmpty()) return;
//
//        final TextChannel pleaseDontDoThis = dontDoThis.get(0);

        String name = event.getUser().getName();
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("\uD835\uDC3B\uD835\uDC52\uD835\uDCC1\uD835\uDCC1\uD835\uDC5C," + " " + name + "! ✨"); // saying hello with username
        eb.setDescription("あなたが私たちのサーバーに来てくれてとっても嬉しいです！\n" +
                "ルールのテキストチャンネルを見てしっかり理解してください。\n" +
                "遠慮せずにサーバー内を見てまわってね。\n\n" +
                "\uD835\uDE52\uD835\uDE5A \uD835\uDE56\uD835\uDE67\uD835\uDE5A \uD835\uDE67\uD835\uDE5A\uD835\uDE56\uD835\uDE61\uD835\uDE61\uD835\uDE6E \uD835\uDE5A\uD835\uDE6D\uD835\uDE58\uD835\uDE5E\uD835\uDE69\uD835\uDE5A\uD835\uDE59 \uD835\uDE69\uD835\uDE64 \uD835\uDE5D\uD835\uDE56\uD835\uDE6B\uD835\uDE5A \uD835\uDE6E\uD835\uDE64\uD835\uDE6A \uD835\uDE5D\uD835\uDE5A\uD835\uDE67\uD835\uDE5A \uD835\uDE5E\uD835\uDE63 \uD835\uDE64\uD835\uDE6A\uD835\uDE67 \uD835\uDE68\uD835\uDE5A\uD835\uDE67\uD835\uDE6B\uD835\uDE5A\uD835\uDE67! \uD83C\uDF40\n \n" +
                "\uD835\uDE1E\uD835\uDE26 \uD835\uDE36\uD835\uDE33\uD835\uDE28\uD835\uDE26 \uD835\uDE3A\uD835\uDE30\uD835\uDE36 \uD835\uDE35\uD835\uDE30 \uD835\uDE37\uD835\uDE2A\uD835\uDE34\uD835\uDE2A\uD835\uDE35 \uD835\uDE35\uD835\uDE29\uD835\uDE26 \uD835\uDE33\uD835\uDE36\uD835\uDE2D\uD835\uDE26\uD835\uDE34 \uD835\uDE31\uD835\uDE22\uD835\uDE28\uD835\uDE26 \uD835\uDE22\uD835\uDE2F\uD835\uDE25 \uD835\uDE28\uD835\uDE26\uD835\uDE35 \uD835\uDE22\uD835\uDE24\uD835\uDE30\uD835\uDE36\uD835\uDE34\uD835\uDE35\uD835\uDE30\uD835\uDE2E\uD835\uDE26\uD835\uDE25 \uD835\uDE35\uD835\uDE30 \uD835\uDE35\uD835\uDE29\uD835\uDE26\uD835\uDE2E.\n" +
                "\uD835\uDE0D\uD835\uDE26\uD835\uDE26\uD835\uDE2D \uD835\uDE27\uD835\uDE33\uD835\uDE26\uD835\uDE26 \uD835\uDE35\uD835\uDE30 \uD835\uDE24\uD835\uDE29\uD835\uDE26\uD835\uDE24\uD835\uDE2C \uD835\uDE22\uD835\uDE33\uD835\uDE30\uD835\uDE36\uD835\uDE2F\uD835\uDE25 \uD835\uDE35\uD835\uDE29\uD835\uDE26 \uD835\uDE34\uD835\uDE26\uD835\uDE33\uD835\uDE37\uD835\uDE26\uD835\uDE33! \uD83C\uDF8B\n");
        eb.setThumbnail("https://img.freepik.com/free-vector/cute-mother-chicken-with-hen-cartoon-vector-icon-illustration-animal-nature-icon-concept-isolated-premium-vector-flat-cartoon-style_138676-3705.jpg?w=826&t=st=1659350715~exp=1659351315~hmac=4f6292375e8c83e4f08c6b8b0578804c25d860514fbd974c29296117f7273646");
        eb.setImage("https://aniyuki.com/wp-content/uploads/2022/05/aniyuki-anya-spy-x-family-12.gif");
        eb.setColor(Color.RED);
        textChannel.sendMessageEmbeds(eb.build()).queue();
    }
}
