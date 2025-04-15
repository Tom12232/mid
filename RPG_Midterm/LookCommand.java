public class LookCommand implements Command {
    @Override
    public void execute(Player p, GameContext c) {
        Room room = c.getCurrentRoom();
        System.out.println("你正在：" + room.getName());
        System.out.println(room.getDescription());

        Monster monster = room.getMonster();
        if (monster != null && monster.isAlive()) {
            System.out.println("這裡有一隻怪物：「" + monster.getName() + "」，血量剩下 " + monster.getHp());
        } else {
            System.out.println("這裡沒有怪物。");
        }

        if (room.hasPotion()) {
            System.out.println("你注意到角落有一瓶藥水。可用 use potion 指令使用。");
        }

        System.out.println("出口方向有：" + room.getExitString());
    }
}
