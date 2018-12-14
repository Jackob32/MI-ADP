package command;

import proxy.IGameModel;

public class StopMoveCannonDownCommand extends AbsGameCommand
{
    public StopMoveCannonDownCommand(IGameModel subject)
    {
        super(subject);
    }

    @Override
    public void execute()
    {
        this.subject.stopMoveCannonDown();
    }
}