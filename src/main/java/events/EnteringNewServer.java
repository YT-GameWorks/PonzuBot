package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class EnteringNewServer extends ListenerAdapter {
    @Override
    public void onGuildJoin(@NotNull GuildJoinEvent event) {
        super.onGuildJoin(event);
        String link = "https://api.popcat.xyz/welcomecard?background=https://images2.alphacoders.com/121/thumb-1920-1218248.png&text1=Ponzu%20Bot&text2=This+is+a+bot+made+by+CJ&text3=Cj%230020&avatar=https://i.pinimg.com/originals/ae/e4/08/aee4087209048b44cbab506194d699b3.jpg";
        EmbedBuilder eb1 = new EmbedBuilder();
        eb1.setColor(Color.magenta);
        eb1.setImage(link);

        event.getGuild().getSystemChannel().sendMessageEmbeds(eb1.build()).queue();

        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("\uD83C\uDF61  \uD835\uDCDF\uD835\uDCF8\uD835\uDCF7\uD835\uDD03\uD835\uDCFE \uD835\uDCD1\uD835\uDCF8\uD835\uDCFD \uD83C\uDF8F");
        eb.setDescription(" Cjが作ったbot☄️ \n コマンドを使う前に$を使ってね❄️\n \n \uD835\uDC08'\uD835\uDC26 \uD835\uDC1A \uD835\uDC1B\uD835\uDC28\uD835\uDC2D \uD835\uDC26\uD835\uDC1A\uD835\uDC1D\uD835\uDC1E \uD835\uDC1B\uD835\uDC32 \uD835\uDC02\uD835\uDC23☄️\n" +
                "Use the $ before using the command :D");
        eb.setColor(Color.orange);
        eb.addField("$info", "botの情報を表示します \n \uD835\uDC9F\uD835\uDCBE\uD835\uDCC8\uD835\uDCC5\uD835\uDCC1\uD835\uDCB6\uD835\uDCCE\uD835\uDCC8 \uD835\uDCC9\uD835\uDCBD\uD835\uDC52 \uD835\uDCBE\uD835\uDCC3\uD835\uDCBB\uD835\uDC5C \uD835\uDC5C\uD835\uDCBB \uD835\uDCC9\uD835\uDCBD\uD835\uDC52 \uD835\uDCB7\uD835\uDC5C\uD835\uDCC9.", true);
        eb.addField("$help", "botのいろんなコマンドを表示します \n \uD835\uDC9F\uD835\uDCBE\uD835\uDCC8\uD835\uDCC5\uD835\uDCC1\uD835\uDCB6\uD835\uDCCE\uD835\uDCC8 \uD835\uDCC9\uD835\uDCBD\uD835\uDC52 \uD835\uDCB9\uD835\uDCBE\uD835\uDCBB\uD835\uDCBB\uD835\uDC52\uD835\uDCC7\uD835\uDC52\uD835\uDCC3\uD835\uDCC9 \uD835\uDCB8\uD835\uDC5C\uD835\uDCC2\uD835\uDCC2\uD835\uDCB6\uD835\uDCC3\uD835\uDCB9\uD835\uDCC8 \uD835\uDCBB\uD835\uDC5C\uD835\uDCC7 \uD835\uDCC9\uD835\uDCBD\uD835\uDC52 \uD835\uDCB7\uD835\uDC5C\uD835\uDCC9.\uD83D\uDCD6.", true);
        eb.setThumbnail("https://img.freepik.com/free-vector/hen-with-chick-cartoon-illustration_138676-2054.jpg?w=826&t=st=1659342415~exp=1659343015~hmac=723ac6c3c870af4987c15d77c8c51e550d1f33d8376826d30b9ec0e8db1da1d3");

        event.getGuild().getSystemChannel().sendMessageEmbeds(eb.build()).queue();
    }
}
