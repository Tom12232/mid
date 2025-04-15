public class MoveCommand implements Command {
    private String direction;

    public MoveCommand(String direction) {
        this.direction = direction;
    }

    @Override
    public void execute(Player p, GameContext c) {
        Room next = c.getCurrentRoom().getExit(direction);
        if (next != null) {
            c.setCurrentRoom(next);
            System.out.println("你移動到了：" + next.getName());
        } else {
            System.out.println("這個方向沒有路可以走。");
        }
    }
}
