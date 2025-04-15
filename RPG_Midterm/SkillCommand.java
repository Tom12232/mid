public class SkillCommand implements Command {
    private String skillName;

    public SkillCommand(String skillName) {
        this.skillName = skillName;
    }

    @Override
    public void execute(Player p, GameContext c) {
        Room room = c.getCurrentRoom();
        Monster m = room.getMonster();

        if (m == null || !m.isAlive()) {
            System.out.println("這裡沒有怪物可以施放技能。");
            return;
        }

        Skill skill = new FireballSkill();
        if (skill.getName().equalsIgnoreCase(skillName)) {
            skill.use(p, m);
        } else {
            System.out.println("你不會這個技能。");
        }
    }
}
