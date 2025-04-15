public class FireballSkill implements Skill {
    @Override
    public String getName() {
        return "fireball";
    }

    @Override
    public void use(Player p, Monster m) {
        int dmg = p.getAttack() * 2;
        m.takeDamage(dmg);
        p.addDamage(dmg);
        System.out.println("🔥 你施放了火球術，造成 " + dmg + " 傷害！");

        if (!m.isAlive()) {
            System.out.println("🔥 火球燒盡了敵人！你擊敗了 " + m.getName());
            p.addKill();
        }
    }
}
