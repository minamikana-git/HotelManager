package work.utakatanet.hotelmanagement;

import dev.jorel.commandapi.CommandAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import work.utakatanet.hotelmanagement.command.CommandHandler;

public class HotelManager extends JavaPlugin implements Listener {
    private Inventory checkInGUI;
    private Inventory checkOutGUI;

    @Override
    public void onEnable() {
        // プラグインの初期化処理
        initializeGUIs();
        getServer().getPluginManager().registerEvents(this, this);

        // CommandAPI
        CommandAPI.onEnable();

        // コマンド登録
        CommandHandler.registerCommands();
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

}
