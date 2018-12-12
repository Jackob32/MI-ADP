package command;

import proxy.IGameModel;

public class MoveCannonUpCommand extends AbsGameCommand
{
    public MoveCannonUpCommand(IGameModel subject)
    {
        super(subject);
    }

    @Override
    public void execute()
    {
        this.subject.moveCannonUp();
    }
}