package work.utakatanet.hotelmanagement.command;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.PlayerArgument;
import dev.jorel.commandapi.arguments.StringArgument;
import dev.jorel.commandapi.exceptions.WrapperCommandSyntaxException;
import dev.jorel.commandapi.executors.CommandArguments;
import dev.jorel.commandapi.executors.PlayerCommandExecutor;
import org.bukkit.entity.Player;
import work.utakatanet.hotelmanagement.util.Message;

import java.util.Objects;

public class HotelsCommand {

    public static void register() {

        new CommandAPICommand("hotels") // ここで /"hotels" が登録される
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
                .withSubcommand(new CommandAPICommand("hotel") // /hotels "hotel" サブコマンドを登録

                        // /hotels hotel "npc" サブコマンド
                        .withSubcommand(new CommandAPICommand("npc")
                                .withSubcommand(new CommandAPICommand("create")
                                        .executesPlayer((player, args) -> { // /hotels npc create

                                            if (args.args().length < 1) {
                                                player.sendMessage(Message.prefix + "" + Message.errorNotEnoughArguments);
                                                return;

                                            }
                                        })
                                )
                        )

                        // /hotels hotel "remove" サブコマンド
                        .withSubcommand(new CommandAPICommand("remove")
                                .executesPlayer((player, args) -> { // /hotels remove
                                    if (args.args().length < 1) {
                                        player.sendMessage(Message.prefix + "" + Message.errorNotEnoughArguments);
                                        return;
                                    }
                                })
                        )

                        // /hotels hotel "list" サブコマンド
                        .withSubcommand(new CommandAPICommand("list")
                                .executesPlayer((player, args) -> { // /hotels hotel list
                                    if (args.args().length < 1) {
                                        player.sendMessage(Message.prefix + "" + Message.errorNotEnoughArguments);
                                        return;
                                    }


                                })
                        )
                        // /hotels hotel "info" サブコマンド
                        .withSubcommand(new CommandAPICommand("info")
                                .executesPlayer((player, args) -> { // /hotels hotel info
                                    if (args.args().length < 1) {
                                        player.sendMessage(Message.prefix + "" + Message.errorNotEnoughArguments);
                                        return;
                                    }
                                })
                        )
                        // /hotels hotel "room create" サブコマンド
                        .withSubcommand(new CommandAPICommand("room")
                                .withSubcommand(new CommandAPICommand("create"))
                                .executesPlayer((player, args) -> { // /hotels hotel room create
                                    if (args.args().length < 1) {
                                        player.sendMessage(Message.prefix + "" + Message.errorNotEnoughArguments);
                                        return;
                                    }
                                })
                        )
                )
                .register();


    } // これは registerメソッドの閉じかっこ

}
