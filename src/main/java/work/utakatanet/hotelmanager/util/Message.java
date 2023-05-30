package work.utakatanet.hotelmanager.util;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Message {

    public static String prefix = getColored("&6[HotelManager]"); // プラグインのプレフィックス
    public static String errorNotEnoughArguments = getColored("&c引数が足りません！"); // 引数の数が足りない時のエラー
    public static String errorIllegalArgument = getColored("&c引数が正しくありません。"); // 引数が正しくない時のエラー

    public static String getColored(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static String nullToString(Object object) {
        if (object == null) return "";
        if (!(object instanceof String)) return "";
        return object.toString();
    }

    public static void sendMessage(CommandSender sender, Boolean needPrefix, String msg) { sendMessage((Player) sender, needPrefix, msg); }
    public static void sendMessage(Player player, Boolean needPrefix, String msg) {
        String prefix_ = "";
        if (needPrefix) prefix_ = prefix;

        player.sendMessage(prefix_ + " " + getColored(msg));
    }

}
