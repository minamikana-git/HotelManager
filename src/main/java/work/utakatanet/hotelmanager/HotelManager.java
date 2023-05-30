package work.utakatanet.hotelmanager;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIBukkitConfig;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import work.utakatanet.hotelmanager.command.CommandHandler;


public class HotelManager extends JavaPlugin implements Listener {
    private Inventory checkInGUI;
    private Inventory checkOutGUI;

    @Override
    public void onEnable() {
        // プラグインの初期化処理
        initializeGUIs();
        getServer().getPluginManager().registerEvents(this, this);

        // CommandAPI
        CommandAPI.onLoad(new CommandAPIBukkitConfig(this));
        CommandAPI.onEnable();
        // コマンド登録
        CommandHandler.registerCommands();
        spawnHotelNPC();{
    }


        private void
            World world = Bukkit.getWorld("ワールド名");  // ホテルが存在するワールドを指定してください
            Location location = new Location(world, x, y, z);  // NPCを配置する座標を指定してください

            // NPCの作成処理を記述
            Entity entity = world.spawnEntity(location, EntityType.VILLAGER);  // 例として、村人（Villager）をNPCとして使用します
            if (entity instanceof Villager) {
                Villager npc = (Villager) entity;
                npc.setCustomName("Hotel NPC");  // NPCの名前を設定してください
                npc.setCustomNameVisible(true);  // NPCの名前を表示するかどうかを設定します

                // その他のNPCの設定を行うことができます
            }
        }
    }


    private void spawnHotelNPC() {
        World world = Bukkit.getWorld("world");  // ホテルが存在するワールドを指定してください
        Location location = new Location(world, x, y, z);  // NPCを配置する座標を指定してください

        // NPCの作成処理を記述
        Entity entity = world.spawnEntity(location, EntityType.VILLAGER);  // 例として、村人（Villager）をNPCとして使用します
        if (entity instanceof Villager) {
            Villager npc = (Villager) entity;
            npc.setCustomName("うたまろ");  // NPCの名前を設定してください
            npc.setCustomNameVisible(true);  // NPCの名前を表示するかどうかを設定します

            // その他のNPCの設定を行うことができます
        }
    }

@Override
    public void onDisable() {
        // プラグインの停止処理
    }

    private void initializeGUIs() {
        // チェックイン用GUIの初期化
        checkInGUI = Bukkit.createInventory(null, 9, "Check-In");
        // GUIにアイテムを追加するなどの初期化処理を行う
        checkInGUI.setItem(0,new ItemStack(Material.DIAMOND));
        checkInGUI.setItem(1,new ItemStack(Material.GOLD_INGOT));

        // チェックアウト用GUIの初期化
        checkOutGUI = Bukkit.createInventory(null, 9, "Check-Out");
        // GUIにアイテムを追加するなどの初期化処理を行う
        checkOutGUI.setItem(0,new ItemStack(Material.IRON_INGOT));
        checkOutGUI.setItem(1,new ItemStack(Material.COAL));
    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();
        player.openInventory(checkInGUI); // チェックイン用GUIを開く
        if (event.getInventory().equals(checkInGUI)) {
            event.setCancelled(true); // GUI内でのアイテムの移動をキャンセル

            if (clickedItem != null) {
                if (clickedItem.getType().equals(Material.CLOCK)) {
                    // チェックインボタンが押された場合の処理
                    // 日付の設定や合計金額の計算などを行う
                    // 次の画面に進むための処理を記述
                }
            }
            player.openInventory(checkOutGUI); // チェックアウト用GUIを開く
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


    private boolean playerHasEnoughMoney(Player player, double amount) {

        return false;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("createhotel")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("このコマンドはプレイヤーから実行してください。");
                return true;
            }

            Player player = (Player) sender;
            // ホテル全体を選択してコマンドを実行する処理を記述

            return true;
        } else if (command.getName().equalsIgnoreCase("createroom")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("このコマンドはプレイヤーから実行してください。");
                return true;
            }

            Player player = (Player) sender;
            // ホテル内の個室の範囲を選択してコマンドを実行する処理を記述

            return true;
        }

        return false;
    }
}