package work.utakatanet.hotelmanagement;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class HotelManagement extends JavaPlugin implements Listener {
    private Inventory checkInGUI;
    private Inventory checkOutGUI;

    @Override
    public void onEnable() {
        // プラグインの初期化処理
        initializeGUIs();
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // プラグインの停止処理
    }

    private void initializeGUIs() {
        // チェックイン用GUIの初期化
        checkInGUI = Bukkit.createInventory(null, 9, "Check-In");
        // GUIにアイテムを追加するなどの初期化処理を行う

        // チェックアウト用GUIの初期化
        checkOutGUI = Bukkit.createInventory(null, 9, "Check-Out");
        // GUIにアイテムを追加するなどの初期化処理を行う
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();

        if (event.getInventory().equals(checkInGUI)) {
            event.setCancelled(true); // GUI内でのアイテムの移動をキャンセル

            if (clickedItem != null) {
                if (clickedItem.getType().equals(Material.CLOCK)) {
                    // チェックインボタンが押された場合の処理
                    // 日付の設定や合計金額の計算などを行う
                    // 次の画面に進むための処理を記述
                }
            }
        } else if (event.getInventory().equals(checkOutGUI)) {
            event.setCancelled(true); // GUI内でのアイテムの移動をキャンセル

            if (clickedItem != null) {
                if (clickedItem.getType().equals(Material.GOLD_INGOT)) {
                    // 支払いボタンが押された場合の処理
                    // 合計金額の表示や支払いの処理などを行う
                    // チェックアウト完了の処理を記述
                }
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
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

    }

        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (cmd.getName().equalsIgnoreCase("hotel")) {
                if (args.length > 1 && args[0].equalsIgnoreCase("create")) {
                    String hotelName = args[1];
                    // ホテルを作成する処理
                    return true;
                }
            }
        }

            public boolean (CommandSender sender, Command cmd, String label, String[] args) {
                if (cmd.getName().equalsIgnoreCase("hotel")) {
                    if (args.length > 2 && args[1].equalsIgnoreCase("room") && args[2].equalsIgnoreCase("create")) {
                        String hotelName = args[0];
                        // ホテル内のルームを作成する処理
                        return true;
                    }
                }
        }

                public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
                    if (cmd.getName().equalsIgnoreCase("hotel")) {
                        if (args.length > 0 && args[0].equalsIgnoreCase("npc") && args[1].equalsIgnoreCase("create")) {
                            // エントランスのNPCを作成する処理
                            return true;
                        }
                    }
                    return false;
                }
               public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
                  if (cmd.getName().equalsIgnoreCase("hotel")) {
                      if (args.length > 0 && args[0].equalsIgnoreCase("{ホテル名｝") && args[1].equalsIgnoreCase("list")) {
                //
                            return true;
                    }
                }
                  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
                       if (cmd.getName().equalsIgnoreCase("hotel")) {
                           if (args.length > 0 && args[0].equalsIgnoreCase("{ホテル名｝") && args[1].equalsIgnoreCase("info")) {
    }
                           public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
                               if (cmd.getName().equalsIgnoreCase("hotel")) {
                                   if (args.length > 0 && args[0].equalsIgnoreCase("{ホテル名｝") && args[1].equalsIgnoreCase("list")) {
            }

        }

    }
}
