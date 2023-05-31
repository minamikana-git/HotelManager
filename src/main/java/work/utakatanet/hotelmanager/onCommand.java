package work.utakatanet.hotelmanager;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.arguments.StringArgument;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import work.utakatanet.hotelmanager.util.Message;

public class onCommand {
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
                            if (hotelName.length == 0;{
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


    /*
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("hotelcreate")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("このコマンドはプレイヤーから実行してください。");
                return true;
            }

            Player player = (Player) sender;
            // ホテル全体を選択してコマンドを実行する処理を記述

            return true;
        } else if (command.getName().equalsIgnoreCase("roomcreate")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("このコマンドはプレイヤーから実行してください。");
                return true;
            }

            Player player = (Player) sender;
            // ホテル内の個室の範囲を選択してコマンドを実行する処理を記述

            return true;
        }

        return false;

        public boolean onCommand(CommandSender,sender, Command cmd, String label, String[] args) {
            if (cmd.getName().equalsIgnoreCase("hotel")) {
                if (args.length > 1 && args[0].equalsIgnoreCase("create")) {
                    String hotelName = args[1];
                    // ホテルを作成する処理
                    return true;
                }

            }

            return false;

            public boolean (CommandSender sender, Command cmd, String label, String[] args) {
                if (cmd.getName().equalsIgnoreCase("hotel")) {
                    if (args.length > 2 && args[1].equalsIgnoreCase("room") && args[2].equalsIgnoreCase("create")) {
                        String hotelName = args[0];
                        // ホテル内のルームを作成する処理
                        return true;
                    }
                }
                return false;

                public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
                    if (cmd.getName().equalsIgnoreCase("hotel")) {
                        if (args.length > 0 && args[0].equalsIgnoreCase("npc") && args[1].equalsIgnoreCase("create")) {
                            // エントランスのNPCを作成する処理


                        }
                    }
                    return true;
                }
            }

        }

    }*/
}

