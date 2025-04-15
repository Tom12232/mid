public class UsePotionCommand implements Command {
    @Override
    public void execute(Player p, GameContext c) {
        Room room = c.getCurrentRoom();
        if (room.hasPotion()) {
            p.takeDamage(-30); // 回復 30 HP（- 傷害 = 回復）
            room.removePotion();
            System.out.println("你喝下了藥水，恢復了 30 HP。你現在有 " + p.getHp() + " HP。");
        } else {
            System.out.println("這裡沒有藥水可用。");
        }
    }
}
