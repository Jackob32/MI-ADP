package command;

import proxy.IGameModel;

public class MoveCannonDownCommand extends AbsGameCommand
{
    public MoveCannonDownCommand(IGameModel subject)
    {
        super(subject);
    }

    @Override
    public void execute()
    {
        this.subject.moveCannonDown();
    }
}