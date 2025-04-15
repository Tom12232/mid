public class AttackCommand implements Command {
    @Override
    public void execute(Player p, GameContext c) {
        Room room = c.getCurrentRoom();
        Monster m = room.getMonster();

        if (m == null || !m.isAlive()) {
            System.out.println("這裡沒有怪物可以攻擊。");
            return;
        }

        // 玩家攻擊怪物
        m.takeDamage(p.getAttack());
        p.addDamage(p.getAttack());
        System.out.println("你對 " + m.getName() + " 造成了 " + p.getAttack() + " 傷害。");

        // 檢查怪物是否死亡
        if (!m.isAlive()) {
            System.out.println("你擊敗了 " + m.getName() + "！");
            p.addKill();
        } else {
            // 怪物反擊
            p.takeDamage(m.getAttack());
            System.out.println(m.getName() + " 反擊你造成了 " + m.getAttack() + " 傷害。");
            System.out.println("你剩下 " + p.getHp() + " HP。");
        }
    }
}
