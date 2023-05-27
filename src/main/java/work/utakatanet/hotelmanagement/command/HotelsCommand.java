package work.utakatanet.hotelmanagement.command;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.StringArgument;
import work.utakatanet.hotelmanagement.util.Message;

public class HotelsCommand {

    public static void register() {

        new CommandAPICommand("hotels")
                .withSubcommand(new CommandAPICommand("create")
                        .withArguments(new StringArgument("hotelName"))
                        .executesPlayer((player, args) -> { // /hotels create

                            // 引数が足りない場合
                            if (args.args().length < 1) {
                                player.sendMessage(Message.prefix + " " + Message.errorNotEnoughArguments);
                                return;
                            }

                            String hotelName = Message.nullToString(args.get(0));

                            // ホテル名が指定されていなければ
                            if (hotelName.equals("")) {
                                Message.sendMessage(player, true, Message.errorIllegalArgument + "ホテル名を指定してください！");
                            }

                            // ここから処理をどうぞー(消しておいてください)
                        })
                )
                .withSubcommand(new CommandAPICommand("hotel")
                        .withArguments(new StringArgument("hotelName"))
                )
                .register();


    }

}
